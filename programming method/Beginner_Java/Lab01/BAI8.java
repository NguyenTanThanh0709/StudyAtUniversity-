import java.util.Scanner;

public class BAI8 {
    public static void main(String[] args){
        int n;
        int caua = 0, caub = 1, cauc = 0, caud = 0, caue = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <=n ; i++){
            caua += i;
        }
        for(int i = 1; i <= n; i++){
            caub *= i;
        }
        for(int i = 0; i <= n; i++){
            cauc += Math.pow(2,i);
        }
        for(int i = 1; i <= n; i++){
            caud += 1.0 / 2*i;
        }

        for(int i = 1; i <= n; i++){
            caue += Math.pow(i,2);
        }


        System.out.println(caua);
        System.out.println(caub);
        System.out.println(cauc);
        System.out.println(caud);
        System.out.println(caue);
        
    }
}
