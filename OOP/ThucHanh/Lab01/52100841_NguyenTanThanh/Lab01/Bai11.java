import java.util.Scanner;
public class Bai11 {
    public static void main(String[] args){
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        int sum = 0;
        while(n > 0){
            sum+=1;
            n /= 10;
        }
        System.out.println("count digit number is " + sum);
    }
}