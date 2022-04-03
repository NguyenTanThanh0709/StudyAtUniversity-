public class Bai09 {
    public static void main(String[] args) {
        int[] Array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] Aray1 = divisibleNumbers(Array, 2);
        printArray(Aray1);
    }

    public static int[] divisibleNumbers(int arr[], int k){
        int[] result = new int[arr.length];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % k == 0){
                result[count] = arr[i];
                count++;
            }
        }
        return result;
    }

    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
