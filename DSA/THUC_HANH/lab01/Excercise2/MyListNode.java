

import java.util.NoSuchElementException;

public class MyListNode <E> implements ListNodeInterface <E>{
    protected Node <E> head;
    private int numNode;

    public MyListNode(){
        numNode = 0;
    }

    @Override
    public void addFirst(E item) {
        if(head == null){
            head = new Node<E>(item , null);
        }else{
            Node <E> curr = new Node<E>(item, head);
            head = curr;
        }
        numNode++;
    }

    @Override
    public void addAfter(Node<E> curr, E item) throws NoSuchElementException {
        if(head == null){
            addFirst(item);
        }else{
             Node <E> pre = new Node<E>(item);
             pre.setNext(curr.getNext());
             curr.setNext(pre);

        }
        numNode++;
        
    }

    @Override
    public void addLast(E item) {
        if(head == null){
            addFirst(item);
        }
        Node <E> curr = head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        curr.setNext(new Node<E>(item));
        numNode++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if(head == null) throw new NoSuchElementException("Can't remove empty list!");
        Node <E> temp = head;
        head = head.getNext();
        numNode--;
        return temp.getData();
    }

    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if(curr == null || head == null) throw new NoSuchElementException("Can't remove empty list!");
        
        Node <E> temp = curr;
        if(temp.getNext().getNext() == null){
            
            return removeLast();
        }
        if(temp.getNext() != null){
            curr.setNext(curr.getNext().getNext());
            numNode--;
        }else{
            throw new NoSuchElementException("Can't remove");
        }
        return temp.getNext().getData();
    }


    @Override
    public E removeLast() throws NoSuchElementException {
        if(head == null) throw new NoSuchElementException("cant remove");
        if(numNode == 1){
            removeFirst();
        }
        Node <E> curr = head;
        Node <E> pre = null;
        
        while(curr.getNext() != null){
            pre = curr;
            curr = curr.getNext();
        }
        
        pre.setNext(curr.getNext());
        numNode--;
       return curr.getData();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return numNode;
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
        return  numNode == 0;
    }

    @Override
    public Node<E> getHead() {
        // TODO Auto-generated method stub
        return head;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        // TODO Auto-generated method stub
        if(head == null) throw new NoSuchElementException("cant get first element");

        return head.getData();
    }

    @Override
    public E removeCurr(Node<E> curr) throws NoSuchElementException {
        if(head == null) throw new NoSuchElementException("cant remove empty list");
        if(curr.getData().equals(head.getData())){
            numNode--;
            return removeFirst();
        }
        Node<E> tempHead = head;
        Node <E> pre = null;
        while(tempHead.getNext() != null && !tempHead.getData().equals(curr.getData())){
            pre = tempHead;
            tempHead = tempHead.getNext();
        }

        if(tempHead.getNext() == null){
            return removeLast();
        }else{
            pre.setNext(tempHead.getNext());
            
        }
        numNode--;
        return tempHead.getData();
    }
    
}
