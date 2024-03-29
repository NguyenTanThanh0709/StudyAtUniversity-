
public class Node <E>{
    private E data;
    private Node <E> next;

    public Node(){}

    public Node(E data){
        this.data = data;
    }
    
    public Node(E data, Node <E> next){
        this.data = data;
        this.next = next;
    }

    public E getData(){
        return this.data;
    }

    public Node <E> getNext(){
        return this.next;
    }

    public void setNext(Node <E> curr){
        this.next = curr;
    }
}