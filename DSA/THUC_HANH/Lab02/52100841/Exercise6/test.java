

public class test {
    public static void main(String[] args) {
        ImplementQueueWithStack<Integer> myQueue = new ImplementQueueWithStack<>();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        System.out.println(myQueue.deQueue());
        myQueue.enQueue(6);
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
    }
}
