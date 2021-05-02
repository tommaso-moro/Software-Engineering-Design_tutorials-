package Q3;

public interface WaitingList {
    void add(Customer customer, Show show, int numTickets);

    void anyoneWaiting(Show show, int numTickets);

}
