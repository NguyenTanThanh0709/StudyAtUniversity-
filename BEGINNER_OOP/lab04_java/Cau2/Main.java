
public class Main {
    public static void main(String[] args) {

        Rectangle Re1 = new Rectangle(9, 4);

        System.out.println(Re1.getLength());
        System.out.println(Re1.getWidth());

        Re1.setLenght(8);
        System.out.println(Re1.getLength());

        System.out.println(Re1.toString());
    }
}
