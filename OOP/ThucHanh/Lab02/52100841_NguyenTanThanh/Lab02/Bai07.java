public class Bai07 {
    public static void main(String[] args) {
        int[] Array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        square(Array);
        printArray(Array);

    }

    public static void square(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
    }

    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
