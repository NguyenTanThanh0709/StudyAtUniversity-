public class test {
    public static void main(String[] args) {
        Priority list = new Priority(1001);

        list.enqueue("21", 3);
        list.enqueue("22", 2);
        list.enqueue("211`", 6);
        list.enqueue("21`2", 1);
        System.out.println(list.dequeue().toString() + "sai");
        // list.enqueue("21", 5);
        // list.enqueue("21", 5);
        list.print();
    }
}
