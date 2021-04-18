package ic.doc.templatemethod;

import java.util.Iterator;

abstract public class ArithmeticSequence implements Iterable<Integer> {

    protected void checkIndexIsValid(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
    }

    public abstract int term(int i);

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
