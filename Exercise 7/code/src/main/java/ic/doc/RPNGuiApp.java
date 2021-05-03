package ic.doc;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class RPNGuiApp implements Updatable {
    JFrame frame = new JFrame("RPN App");
    JPanel panel = new JPanel();
    JTextField textField = new JTextField(10);

    private String result;
    private RPNModel rpnModel = new RPNModel();

    public RPNGuiApp() {
        rpnModel.addObserver(this);
    }

    public static void main(String args[]) {
        new RPNGuiApp().display();
    }

    private void display() {
        frame.setSize(400,300);

        setUpNumberButtons();
        setUpOperatorButtons();
        panel.add(textField);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setUpOperatorButtons() {
        for (Operator operator : Operator.values()) {
            JButton operatorBtn = new JButton(operator.getLabel());
            panel.add(operatorBtn);
            operatorBtn.addActionListener(e -> { rpnModel.performOperation(operator); });
        }
    }

    private void setUpNumberButtons() {
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(valueOf(i+1));
            panel.add(button);
            final int n = i+1;
            button.addActionListener(e -> { rpnModel.addValue(n); });
        }
    }

    @Override
    public void update(Object value) {
        this.result = value.toString();
        textField.setText(result);
    }

    enum Operator {
        PLUS("+") {
            @Override
            public int apply(Integer num1, Integer num2) {
                return num1+num2;
            }
        },
        MINUS("-") {
            @Override
            public int apply(Integer num1, Integer num2) {
                return num2 - num1;
            }
        },
        TIMES("*") {
            @Override
            public int apply(Integer num1, Integer num2) {
                return num1*num2;
            }
        },
        DIVISION("/") {
            @Override
            public int apply(Integer num1, Integer num2) {
                return num1/num2;
            }
        };

        private String label;

        Operator(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public abstract int apply(Integer num1, Integer num2);
    }
}
