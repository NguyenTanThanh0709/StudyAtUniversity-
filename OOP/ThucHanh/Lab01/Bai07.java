import java.util.Scanner;
public class Bai07{
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap ki tu: ");
            char c = sc.next().charAt(0);
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
            	System.out.println("Ki tu la ki tu alpha numeric");
            }
            else{
            	System.out.println("Ki tu khong phai alpha numeric");
            }
        }
	}
}