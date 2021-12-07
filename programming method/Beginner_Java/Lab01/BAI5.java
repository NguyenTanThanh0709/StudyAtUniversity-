import java.util.Scanner;

public class BAI5 {
    public static void main(String[] args){
        int number1, number2, number3;
        Scanner sc = new Scanner(System.in);
        number1 = sc.nextInt();
        number2 = sc.nextInt();
        number3 = sc.nextInt();
        int max;
        max = (number1 > number2) ? number1 : number2;
        max = (max > number3) ? max : number3;
        System.out.println("max is " + max);
    }
}
