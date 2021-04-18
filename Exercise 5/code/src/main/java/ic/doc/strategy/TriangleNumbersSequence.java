package ic.doc.strategy;

public class TriangleNumbersSequence implements Sequence {

    @Override
    public int term(int i) {
        if (i == 0) {
            return 1;
        }
        return (i+1)*(i+2)/2;
    }

}
