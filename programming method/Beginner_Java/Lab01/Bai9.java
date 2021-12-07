import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int lastdigit = n % 10;
        int firstdigit;
        System.out.println("last digit : " + lastdigit);

        while(n > 10){
            n /= 10;
        }
        firstdigit = n;
        System.out.println("first digit : " + firstdigit);
    }
}
