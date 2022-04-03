public class Bai05 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,1,2,4,9};
        System.out.println(countPrime(Array));
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
}
