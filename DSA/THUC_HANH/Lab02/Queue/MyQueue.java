package Queue;

public class MyQueue <E> implements QueueInterface <E> {
    private Node<E> front, rear;
    private int numNode;
    public MyQueue(){
        front = rear = null;
        numNode = 0;
    }
    @Override
    public void enQueue(E item) {
        // TODO Auto-generated method stub
        Node<E> temp = new Node<>(item);
        if(front == null && rear == null){
            front = rear = temp;
        }

        rear.setNext(temp);
        rear = temp;
        numNode++;
    }

    @Override
    public E deQueue() {
        if(front == null){
            return null;
        }
        E data = front.getData();
        front = front.getNext();
        if(front ==null){
            rear = null;
        }
        numNode--;
        return data;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return numNode;
    }

    @Override
    public boolean containss(E item) {
        // TODO Auto-generated method stub
        Node <E> curr = front;
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
        Node <E> curr = front;
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
        return numNode ==0;
    }

    @Override
    public E getFront() {
        // TODO Auto-generated method stub
        return front.getData();
    }
    
}
