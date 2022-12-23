public class Main {
    public static void main(String[] args) {
        DoubleListNode <Integer> list = new DoubleListNode<>();
        list.addFirst(0);

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
     
        System.out.println(list.getPre(3).getData());

        list.Print();

    }
}
