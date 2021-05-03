package Q3;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CardCheckerTest {

  CardChecker cardChecker = new CardChecker();

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  Client client = context.mock(Client.class);
  Observer obs1 = context.mock(Observer.class, "obs1");
  Observer obs2 = context.mock(Observer.class, "obs2");

  // implement your tests here
  @Test
  public void validCardNumberDoesNotTriggerAlert() {

    context.checking(
        new Expectations() {
          {
            exactly(0).of(obs1).alert("1111");
            exactly(0).of(obs2).alert("1111");
          }
        });

    cardChecker.addObserver(obs1);
    cardChecker.addObserver(obs2);
    cardChecker.validate("111122223333");
  }

  @Test
  public void invalidCardNumberTriggersAlert() {
      context.checking(new Expectations() {{
          exactly(1).of(obs1).alert("1111");
          exactly(1).of(obs2).alert("1111");
      }});

      cardChecker.addObserver(obs1);
      cardChecker.addObserver(obs2);
      cardChecker.validate("1111");
  }

  @Test
  public void removedObserversAreNotAlerted() {

      context.checking(new Expectations() {{
          exactly(1).of(obs1).alert("2222");
          exactly(0).of(obs2).alert("2222");
      }});

      cardChecker.addObserver(obs1);
      cardChecker.addObserver(obs2);
      cardChecker.removeObserver(obs2);
      cardChecker.validate("2222");
  }
}
