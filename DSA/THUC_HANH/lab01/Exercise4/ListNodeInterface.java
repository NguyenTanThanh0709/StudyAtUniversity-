
import java.util.NoSuchElementException;

public interface ListNodeInterface <E> {
    public void addFirst(E item);
    public void addAfter(Node<E> curr, E item) throws NoSuchElementException;
    public void addLast(E item);
    public E removeFirst() throws NoSuchElementException;
    public E removeAfter(Node<E> curr) throws NoSuchElementException;
    public E removeLast() throws NoSuchElementException;
    public E removeCurr(Node <E> curr) throws NoSuchElementException;
    public int size();
    public boolean Contains(E item);
    public void Print();
    public boolean isEmpty();
    public Node<E> getHead();
    public E getFirst() throws NoSuchElementException;
    public E getLast() throws NoSuchElementException;
}
