
import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args){
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int remainder = n % m;
        System.out.println("phan du cua " + n +" chia " + m + " la " + remainder);
    }
}

