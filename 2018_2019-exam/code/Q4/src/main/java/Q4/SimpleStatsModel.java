package Q4;

import java.util.ArrayList;
import java.util.List;

public class SimpleStatsModel {
    private final List<Integer> numbers = new ArrayList<>();
    private int numbersMax;
    private double numbersMean;

    public double getNumbersMean() {
        numbersMean = numbers.stream().mapToInt(val -> val).average().orElse(0.0);
        return numbersMean;
    }

    public void addNumber(int n) {
        numbers.add(n);
    }

    public int getMax() {
        int max = 0;
        for (int i = 0; i < numbers.size(); i++) {
            max = Math.max(max, numbers.get(i));
        }
        numbersMax = max;
        return numbersMax;
    }
}
