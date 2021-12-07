import java.util.Scanner;

public class Bai7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //int test = 1;
        char test  = ' ';
        if( test >= 'z' ||  test <= 'z' || test >= 'A'  || test <= 'Z' || test >= 0 || test <= 9){
            System.out.println("test is alphanumeric ");
        } else{
            System.out.print("not is alphanumeric");
        }
    }
}