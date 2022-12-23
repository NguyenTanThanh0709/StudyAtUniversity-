


import java.util.NoSuchElementException;

public class ListNode implements IMethodEX3{
    
    Node head;
    int countElements;

    public ListNode(){
        countElements = 0;
    }
    public ListNode(Node head){
        countElements = 0;
        this.head = head;
    }


    
    @Override
    public int countEvenItem() {
        // TODO Auto-generated method stub
        int result = 0;
        Node  curr = head;
        while(curr != null){
            if(curr.data % 2 == 0){
                result++;
            }
            curr = curr.next;
        }
        return result;
    }

    public boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
       for(int i=2;i<=num/2;i++)
       {
           if((num%i)==0)
               return  false;
       }
       return true;
    }

    @Override
    public int countPrimeItem() {
        int result = 0;
        Node curr = head;
        while(curr != null){
            if(isPrime(curr.data)){
                result++;
            }
            curr = curr.next;
        }
        return result;
    }

    @Override
    public void addItemBeforeItemEven(int item) throws NoSuchElementException {
        // TODO Auto-generated method stub
        if(head == null) throw new NoSuchElementException("cant not add empty list");
        Node temp = new Node(item);
        Node curr = head;
        Node pre = null;
        if(head.data % 2 == 0){ 
            temp.next = head;
            head = temp;
        }else{
            
            while(curr != null){
                if(curr.data % 2 == 0){
                    break;
                }
                pre = curr;
                curr = curr.next;
            }
        }
        temp.next = curr;
        pre.next = temp;
    }

    @Override
    public int findMaxItem() {
        int result = -100;
        Node curr = head;
        while(curr != null){
            if(curr.data >= result){
                result = curr.data;
            }
            curr = curr.next;
        }
        return result;
    }

    @Override
    public void reverseList() {
        Node curr = head;
        while(curr != null && curr.next != null){
            Node nextCurr = curr.next;
            curr.next = nextCurr.next;
            nextCurr.next = head;
            head = nextCurr;
        }
        
    }

    @Override
    public void sortASC() {
     // USING TEMPORARY LIST
/*
 ArrayList<Integer> alist=new ArrayList<Integer>();
        Node temp=head;
        while(temp!=null)
        {
            alist.add(temp.data);
            temp=temp.next;
        }
        Collections.sort(alist);

        int i=0;
        temp = head;
        while(temp!=null)
        {
            temp.data=alist.get(i);
            i++;
            temp=temp.next;
        }

 */
        
        // boolean notDone = true;
        // while(notDone)
        // {
        //     notDone = false;
        //     Node cur = head;

        //     while(cur.nxt != null)
        //     {
        //         Node prev = cur;
        //         cur = cur.nxt;

        //         if(cur.val > cur.nxt.val)
        //         {
        //             prev.nxt = cur.nxt;
        //             Node temp = cur.nxt.nxt;
        //             cur.nxt.nxt = cur;
        //             cur.nxt = temp;
        //             notDone = true;
        //         }
        //     }
        // }

        
    }

    public Node mergeList(Node left, Node right){
        Node _head = new Node(0);
        Node temp = _head;
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        while(left != null && right != null){
            if(left.data <= right.data){
                temp.next = left;
                left =left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
        }

        if(left != null){
            temp.next = left;
        }
        if(right != null){
            temp.next = right;
        }
        return _head.next;
    }

    @Override
    public void Print() {
        Node  curr = head;
        System.out.println();
        System.out.print("List Node: ");
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    @Override
    public void addFirst(int item) {
        head = new Node(item , head);
        countElements++;
    }
    
}
