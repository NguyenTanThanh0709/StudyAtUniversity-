package Stack;

import java.util.NoSuchElementException;

public class MyStack <E> implements StackInterface <E> {
    private Node <E> top;
    private int numNode;

    public MyStack(){
        numNode = 0;
        top = null;
    }

    @Override
    public void push(E item) {
        // TODO Auto-generated method stub
        Node <E> itemNode = new Node<E>(item);
        if(top == null){
            top = itemNode;

        }else{
            itemNode.setNext(top);
            top = itemNode;
            
        }
        numNode++;
    }

    @Override
    public E pop() throws NoSuchElementException{
        if(top == null){
            throw new NoSuchElementException("cant pop empty stack");
        }   
        E value = top.getData();
        top = top.getNext();
        numNode--;
        return value;
    }

    @Override
    public int size() {
        
        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Node <E> curr = top;
        while(curr != null){
            if(curr.getData().equals(item)){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        Node <E> curr = top;
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
        return numNode == 0;
    }

    @Override
    public E getPeek() {
        // TODO Auto-generated method stub
        if(top == null){
            throw new NoSuchElementException("cant pop empty stack");
        }  
        return top.getData();
    }
    
}
