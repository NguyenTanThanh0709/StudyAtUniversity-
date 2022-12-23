package Stack;

import java.util.NoSuchElementException;

public interface StackInterface <E> {
    public void push(E item);
    public E pop() throws NoSuchElementException;
    public int size();
    public boolean contains(E item);
    public void print();
    public boolean isEmpty();
    public E getPeek() throws NoSuchElementException;
}
