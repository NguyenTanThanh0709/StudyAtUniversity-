public class Node <E>{
    private E data;
    private Node <E> next;
    private Node <E> pre;

    public Node(E data){
        this.data = data;
    }

    public Node(Node <E> pre, E data, Node <E> next){
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

    public Node(){}

    public E getData(){
        return this.data;
    }

    public  Node <E> getNext(){
        return this.next;
    }

    public  Node <E> getPre(){
        return this.pre;
    }

    public void setNext(Node <E> next){
        this.next = next;
    }

    public void setPre(Node <E> pre){
        this.pre = pre;
    }

    
}
