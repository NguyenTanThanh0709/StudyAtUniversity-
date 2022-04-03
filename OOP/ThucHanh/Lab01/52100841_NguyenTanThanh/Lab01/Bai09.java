import java.util.Scanner;

public class Bai09 {
         public static void main(String[] args){
           int n;
             try (var sc = new Scanner(System.in)) {
                 n = sc.nextInt();
           }
         System.out.println(hailstone(n));
     }
         public static String hailstone(int n){
             String s = "";
             while(n != 1){
                 if(n % 2 == 0){
                     n = n / 2;
                     System.out.println("even, n/2");
                     s += n + " ";
                 }
                 else{
                    System.out.println("ood, n*3+1");
                     n = n * 3 + 1;
                     s += n + " ";
                 }
             }
             return s;
         }
     }