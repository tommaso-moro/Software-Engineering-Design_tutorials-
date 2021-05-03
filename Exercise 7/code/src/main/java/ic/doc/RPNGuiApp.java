package ic.doc;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;

import static java.lang.String.valueOf;

public class RPNGuiApp {
    JFrame frame = new JFrame("RPN App");
    JPanel panel = new JPanel();
    JTextField textField = new JTextField(10);

    public static void main(String args[]) {
        new RPNGuiApp().display();
    }

    private RPNModel rpnModel = new RPNModel(this);

    private void display() {
        frame.setSize(400,300);

        ArrayList<JButton> btnsArray = new ArrayList<JButton>();

        for (int i = 0; i < 4; i++) {
            JButton button = new JButton(valueOf(i+1));
            btnsArray.add(button);
        };


        btnsArray.get(0).addActionListener(e -> {
            int value = 1;
            rpnModel.addValue(value);
            rpnModel.updateTextField(value);

        });

        btnsArray.get(1).addActionListener(e -> {
            int value = 2;
            rpnModel.addValue(value);
            rpnModel.updateTextField(value);

        });

        btnsArray.get(2).addActionListener(e -> {
            int value = 3;
            rpnModel.addValue(value);
            rpnModel.updateTextField(value);

        });

        btnsArray.get(3).addActionListener(e -> {
            int value = 4;
            rpnModel.addValue(value);
            rpnModel.updateTextField(value);

        });

        //add all buttons to panel
        for (int i = 0; i < 4; i++) {
            panel.add(btnsArray.get(i));
        }

        JButton additionButton = new JButton("+");
        additionButton.addActionListener(e -> {
            rpnModel.performAddition();
        });

        JButton subtractionButton = new JButton("-");
        subtractionButton.addActionListener(e -> {
            rpnModel.performSubtraction();
        });

        panel.add(textField);
        panel.add(additionButton);
        panel.add(subtractionButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
