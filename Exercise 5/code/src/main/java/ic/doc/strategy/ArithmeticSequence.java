package ic.doc.strategy;

import java.util.Iterator;

public class ArithmeticSequence implements Iterable<Integer> {
    Sequence sequence;

    public ArithmeticSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public int term(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        return sequence.term(i);
    }

    public Iterator<Integer> iterator() {
        return new ArithmeticSequence.SequenceIterator();
    }

    private class SequenceIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return term(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
