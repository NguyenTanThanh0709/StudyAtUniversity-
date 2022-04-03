import java.util.Scanner;

public class Bai14{
    public static void main(String[] args) {
        try (var sc = new Scanner(System.in)) {
            int choice;
            do{
            System.out.println("1.coca\n2.pepsi\n3.sprite\n4.7u \n 0.exit");
            System.out.print("your choice: ");
            
            choice = sc.nextInt();
            System.out.println("enter your money: ");
            double money = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("coca is 2$");
                    System.out.println("tinh tien: " + (money - 2));
                    break;
                case 2:
                    System.out.println("pesi 3$ ");
                    System.out.println("tinh tien: " + (money - 3));
                    break;
                case 3:
                    System.out.println("sprite is 4$");
                    System.out.println("tinh tien: " + (money - 4));
                    break;
                case 4:
                    System.out.println("7u is 5$ ");
                    System.out.println("tinh tien: " + (money - 5));
                    break;
                case 0:
                    System.out.println("exit");
                    return;
                default:
                    System.out.println("invalid choice");
            }

            }while(choice != 0);
        }
    }
}