import java.util.Scanner;

public class Bai13 {
    public static void main(String[] args){
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        int temp = n;
        int reverse = 0;
        while(n>0){
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        if(reverse == temp){
            System.out.println("is Palindrome");
        }else{
            System.out.println("is not Palindrome");
        }
    }
}