package Q4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SimpleStats {

  private final List<Integer> numbers = new ArrayList<>();
  private int max;
  private double mean;
  JFrame frame = new JFrame("Simple Stats");
  JPanel panel = new JPanel();
  JTextField currentMaxTextField = new JTextField(11);
  JTextField currentMeanTextField = new JTextField(11);
  SimpleStatsModel simpleStatsModel = new SimpleStatsModel();

  public SimpleStats() {
    frame.setSize(250, 350);
    panel.add(new JLabel("Max: value "));
    panel.add(currentMaxTextField);
    panel.add(new JLabel("Mean: value "));
    panel.add(currentMeanTextField);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // VIEW
  private void display() {

    for (int i = 1; i <= 12; i++) {
      final int n = i;
      JButton button = new JButton(String.valueOf(i));
      button.addActionListener(e -> handleBtnPressed(n));
      panel.add(button);
    }

    frame.getContentPane().add(panel);
    frame.setVisible(true);

  }

  //CONTROLLER
  private void handleBtnPressed(int n) {
    simpleStatsModel.addNumber(n);
    max = simpleStatsModel.getMax();
    mean = simpleStatsModel.getNumbersMean();
    currentMaxTextField.setText(String.valueOf(max));
    currentMeanTextField.setText(String.valueOf(mean));
  }

  public static void main(String[] args) {
    new SimpleStats().display();
  }

}
