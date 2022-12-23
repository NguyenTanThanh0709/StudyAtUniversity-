



public class main {

    public static void main(String[] args) {
        
        ListNode list = new ListNode();
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(1);
        list.addFirst(3);

        list.Print();
        System.out.println(list.countEvenItem());
        System.out.println(list.countPrimeItem());
        list.addItemBeforeItemEven(6);
        list.Print();

        list.reverseList();
        list.Print();

        list.sortASC();
        list.Print();
        
    }
}
