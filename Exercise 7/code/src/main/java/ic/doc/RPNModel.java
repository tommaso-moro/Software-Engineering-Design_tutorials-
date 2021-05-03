package ic.doc;

import java.util.Stack;

import static java.lang.String.valueOf;

class RPNModel {
    private Stack<Integer> stack = new Stack<Integer>();
    private final RPNGuiApp rpnGuiApp;
    private boolean binaryOperationAllowed = false;

    public RPNModel(RPNGuiApp rpnGuiApp) {
        this.rpnGuiApp = rpnGuiApp;
    }
    public RPNModel() {};

    public void performSubtraction() {
        if (binaryOperationAllowed) {   int operand1 = (int) stack.pop();
            int operand2 = (int) stack.pop();
            int result = operand1 - operand2;
            updateTextField(result);
            rpnGuiApp.textField.setText(valueOf(result));

            updateBinaryOperationIsAllowed();
        } else {
            updateTextField("Not enough args for '-'");
        }
    }

    public void performAddition() {
        if (binaryOperationAllowed) {
            int operand1 = stack.pop();
            int operand2 = stack.pop();
            int result = operand1 + operand2;
            stack.push(result);
            updateTextField(result);
            updateBinaryOperationIsAllowed();
        } else {
            updateTextField("Not enough args for '+'");
        }

    }

    public void updateTextField(int value) {
        rpnGuiApp.textField.setText(valueOf(value));
    }

    public void updateTextField(String value) {
        rpnGuiApp.textField.setText(value);
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
    }
}
