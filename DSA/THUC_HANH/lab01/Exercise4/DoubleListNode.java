import java.util.NoSuchElementException;

public class DoubleListNode<E> implements ListNodeInterface<E>{
    Node <E> head;
    int countElement;

    public DoubleListNode(){
        head = null;
        countElement = 0;
    }

    public Node <E> getPre(int index){
        Node <E> temp = head;
        int count = 1;
        while(temp != null){
            if(count == index){
                break;
            }
            temp = temp.getNext();
            count++;
        }
        return temp.getPre();
    }

    public Node <E> getNext(int index){
        Node <E> temp = head;
        int count = 1;
        while(temp != null){
            if(count == index){
                break;
            }
            temp = temp.getNext();
            count++;
        }
        return temp.getNext();
    }

    @Override
    public void addFirst(E item) {
        // TODO Auto-generated method stub
        if(head == null){
            head = new Node<>(item);
            head.setNext(null);
            head.setPre(null);
            return;
        }

        Node <E> temp = new Node<>(item);
        temp.setNext(head);
        temp.setPre(null);

        head.setPre(temp);
        head = temp;
        countElement++;
    }

    @Override
    public void addAfter(Node<E> curr, E item) throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException("cant remove");
        }

        Node <E> temp = new Node<>(item);
        Node<E> preCurr = curr.getNext();
        temp.setNext(preCurr);
        if(preCurr != null){
            preCurr.setPre(temp);
        }
        temp.setPre(curr);
        curr.setNext(temp);
        countElement++;
    }

    @Override
    public void addLast(E item) {
        // TODO Auto-generated method stub
        if(head == null){
            addFirst(item);
            return;
        }

        Node<E> curr = head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }

        Node <E> temp = new Node<>(item);
        curr.setNext(temp);
        temp.setNext(null);
        temp.setPre(curr);
        countElement++;
        
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException("cant remove");
        }
        E data = head.getData();
        head = head.getNext();
        head.setPre(null);
        countElement--;
        return data;
    }
    // Fix Curr.equals ...
    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException("cant remove");
        }
        Node<E> NodeDelete = curr.getNext();
        if(NodeDelete == null){
            throw new NoSuchElementException("cant remove");
        }
        E data = NodeDelete.getData();
        Node <E> nextNodeDelete = NodeDelete.getNext();
        curr.setNext(nextNodeDelete);
        if(nextNodeDelete != null){
            nextNodeDelete.setPre(curr);
        }
        countElement--;
        return data;
        
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        // TODO Auto-generated method stub
        if(head == null){
            throw new NoSuchElementException("cant remove");
        }
        Node <E> curr = head;

        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        E data = curr.getData();
        Node<E> preLast = curr.getPre();
        preLast.setNext(curr.getNext());        
        countElement--;
        return data;
    }

    @Override
    public E removeCurr(Node<E> curr) throws NoSuchElementException {
        if(head == null || curr == null){
            throw new NoSuchElementException("cant remove");
        }

        if(curr.getData().equals(getFirst())){
            return removeFirst();
        }else if(curr.getData().equals(getLast())){
            return removeLast();
        }
        E data = curr.getData();

        Node <E> preCurr = curr.getPre();
        Node <E> nextCurr = curr.getNext();

        preCurr.setNext(nextCurr);
        if(nextCurr != null){
            nextCurr.setPre(preCurr);
        }
        countElement--;
        return data;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return countElement;
    }

    @Override
    public boolean Contains(E item) {
        Node <E> curr = head;
        while(curr != null){
            if(curr.getData().equals(item)){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public void Print() {
        Node <E> curr = head;
        System.out.println();
        System.out.print("List Node: ");
        while(curr != null){
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return countElement == 0;
    }

    @Override
    public Node<E> getHead() {
        // TODO Auto-generated method stub
        return head;
    }

    /* (non-Javadoc)
     * @see ListNodeInterface#getFirst()
     */
    @Override
    public E getFirst() throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException("cant remove");
        }

        return head.getData();
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException("cant remove");
        }
        Node <E> curr = head;
        while(curr.getNext() != null){
            curr =curr.getNext();
        }
        return curr.getData();
    }
    
}