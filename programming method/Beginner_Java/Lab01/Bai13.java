import java.util.Scanner;

public class Bai13 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        int reverse = 0;
        while(n>0){
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        System.out.println("reverse is " + reverse);
    }
}


