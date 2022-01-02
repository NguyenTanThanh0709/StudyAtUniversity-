public class Main {
    public static void main(String[] args) {
        Fraction fr1 = new Fraction(12,4);

        System.out.println(fr1.Add());
        System.out.println(fr1.Sub());
        fr1.setDeno(100);
        System.out.println(fr1.Mul());
        System.out.println(fr1.Div());

        

        System.out.println(fr1.toString());
    }
}
