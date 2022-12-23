public class IntLinkedList {
    private Node head;

    public IntLinkedList(){}

    public void addFirst(int data){
        head = new Node(data,head);
    }

    public boolean addLast(int data){
        if(head == null){
            addFirst(data);
        }

        Node current = head;

        while(current != null){
            if(current.getData() == data){
                return false;
            }
            current = current.getNext();
        }

        Node temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(new Node(data,null));
        return true;
    }

    public boolean removeAt(int index){
        if(head == null || index < 1){
            return false;
        }

        Node current = this.head;
        Node pre = null;
        if(index == 1){
            head = head.getNext();
            return true;
        }
        int count = 1;
        while(current != null){

            if(count == index){
                pre.setNext(current.getNext());
                return true;
            }
            pre = current;
            current = current.getNext();
            count++;
        }
        
        return false;

    }

    public void print(){
        print(head);
    }

    public void print(Node Head){
        if(Head == null){
            return;
        }
        System.out.print(Head.getData() + " ");
        print(Head.getNext());
    }

    public static void main(String args[]){
        IntLinkedList list = new IntLinkedList();
        list.addFirst(0);
        list.addFirst(4);
        list.addFirst(1);
        list.addLast(2);
        list.addLast(5);
        System.out.println(list.removeAt(6));
        list.print();
    }

}
