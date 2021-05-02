package Q3;

public class BoxOffice {
    private Theatre theatre;
    private Payment payment;
    private WaitingList waitingList;

    public BoxOffice(Theatre theatre, Payment payment, WaitingList waitingList) {
        this.theatre = theatre;
        this.payment = payment;
        this.waitingList = waitingList;
    }

    public void checkAvailable(Show show, int numTickets) {
    }

    public void bookTickets(Show show, int numTickets, Customer customer) {
        if (theatre.checkAvailable(show, numTickets)) {
            payment.pay((show.price()*numTickets), customer);
            theatre.confirm(show, numTickets);
        } else {
            waitingList.add(customer, show, numTickets);
        }
    }

    public void returnTickets(Show show, int numTickets) {
        waitingList.anyoneWaiting(show, numTickets);
    }
}
