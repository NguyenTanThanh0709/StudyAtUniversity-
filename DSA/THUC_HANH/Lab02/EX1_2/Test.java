package EX1_2;


import Stack.MyStack;
import Fraction.Fraction;
import Queue.MyQueue;

public class Test {
    public static void main(String[] args) {
        MyStack<Fraction> list = new MyStack<>();
        list.push(new Fraction(1, 1));
        list.push(new Fraction(1, 2));
        list.push(new Fraction(1, 3));
        list.push(new Fraction(1, 4));
        list.print();
        list.pop();
        list.print();
        System.out.println(list.contains(new Fraction(1, 1)));

        MyQueue<Fraction> list1 = new MyQueue<>();
        list1.enQueue(new Fraction(1, 1));
        list1.enQueue(new Fraction(1, 2));
        list1.enQueue(new Fraction(1, 3));
        list1.enQueue(new Fraction(1, 4));
        list1.print();
        list1.deQueue();
        list1.print();
        System.out.println(list1.containss(new Fraction(1, 1)));
    }
}
