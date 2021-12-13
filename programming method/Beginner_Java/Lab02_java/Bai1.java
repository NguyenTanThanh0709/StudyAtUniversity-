import javax.swing.text.html.StyleSheet;

public class Bai1{
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,7};
        System.out.println(MaxArray(Array));
        System.out.println(MinArray(Array));
        System.out.println(sumEven(Array));
        System.out.println("so nguyen co bao nhieu so: "+countPrime(Array));
        CheckNumberInArray(Array,4);
        square(Array);
        divisebleNumber(Array,2);
    }
    
    public static int MaxArray(int[] array){
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static int MinArray(int[] array){
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;

    }

    public static int sumEven(int[] Array){
        int sum = 0;
        for(int i = 0; i < Array.length; i++){
            if(Array[i] % 2 == 0){
                sum += Array[i];
            }
        }
        return sum;
    }

    public static boolean checkPrime(int n){
        if(n < 2){
            return false;
        }
        if(n == 2){
            return true;
        }
        for(int i = 2; i < n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static int countPrime(int[] Array){
        int count = 0;
        for(int i = 0; i < Array.length; i++){
            if(checkPrime(Array[i])){
                count++;
            }
        }
        return count;
    }


    public static int CheckNumberInArray(int[] array, int n){
        for(int i = 0; i < array.length; i++){
            if(n == array[i]){
                System.out.println("tim thay! tai vi tri: "+i);
                return 1;
            }
        }
        return -1;
    }

    public static void square(int[] Array){
        for(int i = 0; i < Array.length; i++){
            Array[i] = Array[i] * Array[i];
        }
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i]+ " ");
        }
    }

    public static void divisebleNumber(int[] Array, int n){
        for(int i = 0; i <Array.length; i++){
            if(Array[i] % n == 0){
                System.out.print(Array[i]+" ");
            }
        }
    }
    
}
