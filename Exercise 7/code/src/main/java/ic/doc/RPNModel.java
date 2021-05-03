package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RPNModel {
    private Stack<Integer> stack = new Stack<Integer>();
    private boolean binaryOperationAllowed = false;
    private List<Updatable> observers = new ArrayList<Updatable>();

    public RPNModel() {};

    public void addObserver(Updatable observer) {
        observers.add(observer);
    }

    private void updateObservers(Object value) {
        for (Updatable observer : observers) {
            observer.update(value);
        }
    }


    public void updateBinaryOperationIsAllowed() {
        if (stack.size() < 2) {
            binaryOperationAllowed = false;
        } else {
            binaryOperationAllowed = true;
        }
    }


    public void addValue(int value) {
        stack.push(value);
        updateBinaryOperationIsAllowed();
        updateObservers(value);
    }

    public void performOperation(RPNGuiApp.Operator operator) {
        if (binaryOperationAllowed) {
            int result = operator.apply(stack.pop(), stack.pop());
            stack.push(result);
            updateObservers(result);
            updateBinaryOperationIsAllowed();
        } else {
            updateObservers("No enough args for '" + operator.getLabel() + "' operation");
        }
    }
}
