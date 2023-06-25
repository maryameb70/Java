package org.mapsa.behavioral.iterator.example;

public class NameRepository implements Container {
    private String[] names = {"maryam", "asma", "zahra", "monire"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    public class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
