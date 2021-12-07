import java.util.Scanner;

public class BAI6 {
    public static void main(String[] args){
        int number;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        if(number % 2 == 0){
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }
}
