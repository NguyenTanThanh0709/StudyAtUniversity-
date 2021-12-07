import java.util.Scanner;

public class BAI4 {
    public static void main(String[] args){
       int year;
        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();

        if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
            System.out.println(year + " la nam nhuan!");
        }else{
            System.out.println(year + " not nam nhuan!");
        }
    }
}
