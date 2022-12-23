import java.util.logging.Handler;

public class Execise_8{

    public void addSoterLinkedList(int value, Node head){
        head = addSoterLinkedList(head, value);
    }

    private Node addSoterLinkedList(Node head, int value){
        if(head  == null || value <= head.value){
            return new  Node(value, head);
        }
        
        head.next = addSoterLinkedList(head.next, value);
        return head;
    }

    public int countEvenLinkedList(Node head){
        int count = 0;
        return countEvenLinkedList(head,count);
    }

    private int countEvenLinkedList(Node head, int count){
        if(head == null){
            return count;
        }

        if(head.value % 2 == 0){
            count++;
        }
        return countEvenLinkedList(head.next, count);
    }

    public int sumEvenLinkedList(Node head){
        int sum = 0;
        return sumEvenLinkedList(head,sum);
    }

    private int sumEvenLinkedList(Node head, int sum){
        if(head == null){
            return 0;
        }

        return head.value + sumEvenLinkedList(head.next, sum);
    }
}