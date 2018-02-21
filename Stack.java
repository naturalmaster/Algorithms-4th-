package basic_DS;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
    }
    public void push(Item item) {
        Node oldFirst;
        oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }
    public Item pop() {
        if (isEmpty()) return null;

        Item top = first.item;
        first = first.next;
        N--;
        return  top;
    }
    public Item peak() {
        if (isEmpty())
            return null;
        return first.item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return N>0;
        }

        @Override
        public Item next() {
            return pop();
        }
    }
}
