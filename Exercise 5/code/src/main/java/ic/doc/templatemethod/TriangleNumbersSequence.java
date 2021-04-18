package ic.doc.templatemethod;

import java.util.Iterator;

public class TriangleNumbersSequence extends ArithmeticSequence {

    @Override
    public int term(int i) {
        checkIndexIsValid(i);
        if (i == 0) {
            return 1;
        }
        return (i+1)*(i+2)/2;
    }

}

