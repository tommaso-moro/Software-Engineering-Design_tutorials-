package Q3;


import java.util.ArrayList;
import java.util.List;

public class CardChecker {
    static final int MAX_CARD_NUM_DIGITS = 12;
    private List<Observer> observers = new ArrayList<Observer>();



    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void validate(String cardNumber) {
        if (cardNumber.length() != 12) {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).alert(cardNumber);
            }
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
