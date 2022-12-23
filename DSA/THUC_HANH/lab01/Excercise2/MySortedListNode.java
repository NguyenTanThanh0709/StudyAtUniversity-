public class MySortedListNode extends MyListNode <Integer>{

    public  void addSorted(int item){
        if(head == null){
            head = new Node< Integer>(item,head);
            return;
        }
        Node<Integer> curr = head;
        Node<Integer> preCurr = null;
        while(curr != null){
            Node <Integer> temp = new Node<Integer>(item);
            if(item <= curr.getData()){
                temp.setNext(curr);
                head = temp;
                return;
            }

            if(item > curr.getData()){
                if(item <= curr.getNext().getData()){
                    temp.setNext(curr.getNext());
                    curr.setNext(temp);
                    return;
                }else{
                    preCurr = curr;
                    curr = curr.getNext();
                    if(curr.getNext() == null){
                        curr.setNext(temp);
                        return;
                    }
                }

            }
            
        }

        
    }

   

}