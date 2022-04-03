public class Bai04 {
    public static void main(String[] args) {
        System.out.println(remainder(5, 2));
        System.out.println(remainder(2, 5));
        System.out.println(remainder(5, 0));
        System.out.println(remainder(0, 5));
        System.out.println(remainder(5, 5));
    }

    public static double remainder(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        } else {
            return a % b;
        }
    }
}