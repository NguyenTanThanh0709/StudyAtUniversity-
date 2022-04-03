import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args){
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        var reverse = 0;
        while(n>0){
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        System.out.println("reverse is " + reverse);
    }
}
