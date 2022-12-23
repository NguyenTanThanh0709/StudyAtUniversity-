
public class TestFraction {
    public static void main(String[] args) {
       MyListNode<Fraction> list = new MyListNode<>();
       list.addFirst(new Fraction(1,2)); 
       list.addFirst(new Fraction(1,2)); 
       list.addFirst(new Fraction(1,4));
       list.Print();
       System.out.println(list.Contains(new Fraction(1, 2))); 
    }
}
