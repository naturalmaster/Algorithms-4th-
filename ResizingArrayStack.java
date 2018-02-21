package basic_DS;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;

    public Item pop() {
        if (N==a.length/4 && N >0) resize(a.length/2);
        return a[--N];
    }
    public void push(Item item) {
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    private void resize(int max) {
        Item[] items = (Item[]) new Object[max];
        for (int i=0;i<N;i++) {
            items[i] = a[i];
        }
        a = items;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
