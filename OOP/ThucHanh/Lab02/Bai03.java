public class Bai03 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,1,2,4,9};
        System.out.println(sumEven(Array));
    }

    public static int sumEven(int[] array) {
        int sum = 0;
        int lenght = array.length;
        for(int i = 0; i < lenght; i++){
            if(array[i] % 2 == 0){
                sum += array[i];
            }
        }
        return sum;
    }
}
