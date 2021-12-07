import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        int cout = 0;
        while(n>0){
            cout++;
            n /= 10;
        }
        System.out.println("coud digit number is " + cout);
    }
}


