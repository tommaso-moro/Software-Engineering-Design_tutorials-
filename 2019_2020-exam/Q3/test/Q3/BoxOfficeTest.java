package Q3;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class BoxOfficeTest {

  static final Show LION_KING =
      new Show("The Lion King", 44.00);

  static final Show HAMILTON =
      new Show("Hamilton", 80.00);

  static final Customer SALLY = new Customer("Sally Davies");
  static final Customer TOM = new Customer("Thomas Williams");

  // write your tests here

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  Payment payment = context.mock(Payment.class);
  Theatre theatre = context.mock(Theatre.class);
  WaitingList waitingList = context.mock(WaitingList.class);
  Client client = context.mock(Client.class);

  BoxOffice boxOffice = new BoxOffice(theatre, payment, waitingList);

  @Test
  public void bookingATicketCallsACheckForAvailability() {
    context.checking(new Expectations() {{
      exactly(1).of(theatre).checkAvailable(LION_KING, 4);
      ignoring(waitingList).add(SALLY, LION_KING, 4);
    }});

    boxOffice.bookTickets(LION_KING, 4, SALLY);
  }

  @Test
  public void ifThereIsAvailabilityThenBoxOfficeIssuesPayment() {
    context.checking(new Expectations() {{
      ignoring(theatre).checkAvailable(LION_KING, 4); will(returnValue(true));
      exactly(1).of(payment).pay((LION_KING.price()*4), SALLY);
      ignoring(theatre).confirm(LION_KING, 4);

    }});
    boxOffice.bookTickets(LION_KING, 4, SALLY);
  }

  @Test
  public void ifPaymentSuccessfulThenBoxOfficeConfirmsBookingToTheatre() {
    context.checking(new Expectations() {{
      ignoring(theatre).checkAvailable(LION_KING, 4); will(returnValue(true));
      ignoring(payment).pay((LION_KING.price()*4), SALLY);
      exactly(1).of(theatre).confirm(LION_KING, 4);

    }});

    boxOffice.bookTickets(LION_KING, 4, SALLY);

  }

  @Test
  public void ifNoAvailabilityThenClientIsPutInWaitingList() {
    context.checking(new Expectations() {{
      ignoring(theatre).checkAvailable(HAMILTON, 2); will(returnValue(false));
      exactly(1).of(waitingList).add(TOM, HAMILTON, 2);
    }});

    boxOffice.bookTickets(HAMILTON, 2, TOM);
  }

  @Test
  public void returningShowTicketsTriggersCheckForClientsWaitingForThatShow() {
    context.checking(new Expectations() {{
      exactly(1).of(waitingList).anyoneWaiting(HAMILTON, 4);
    }});

    boxOffice.returnTickets(HAMILTON, 4);
  }

  @Test
  public void ifClientMatchingCriteriaIsFoundWaitingThenBookingIsMadeForClient() {
    context.checking(new Expectations() {{
      ignoring(waitingList).anyoneWaiting(HAMILTON, 4);
    }});

    boxOffice.returnTickets(HAMILTON, 4);

  }

}
