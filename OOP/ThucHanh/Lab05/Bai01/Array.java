
import java.util.Scanner;

public class Array {
    

    public static int maxEven(int[] a){
        int max = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0 && a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    public static int minOdd(int[] a){
        int min = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0 && a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static int sumMEMO(int[] a){
        int maxEven = maxEven(a);
        int minOdd = minOdd(a);

        return  maxEven + minOdd;
    }

    public static int sumEven(int[] a){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                sum += a[i];
            }
        }
        return sum;
    }

    public static int productOdd(int[] a){
        int product = 1;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){
                product *= a[i];
            }
        }
        return product;
    }

    public static int idxFirstEven(int[] a){
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                return i;
            }
        }
        return -1;
    }

    public static int idxLastOdd(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            if(a[i] % 2 != 0){
                return i;
            }
        }
        return -1;
    }

    public static int[] input(int n){
        int[] a = new int[n];
        try (Scanner sc = new Scanner(System.in)) {
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = input(5);
        System.out.println(maxEven(a));
        System.out.println(minOdd(a));
        System.out.println(sumMEMO(a));
        System.out.println(sumEven(a));
        System.out.println(productOdd(a));
        System.out.println(idxFirstEven(a));
        System.out.println(idxLastOdd(a));
    }

}