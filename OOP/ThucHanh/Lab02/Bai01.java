public class Bai01 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,1,2,4,9};
        int Max = findMax(Array);
        System.out.println(Max);
    }
    public static int findMax(int arr[]){
        int Max = arr[0];
        int lenght = arr.length;
        for(int i = 1; i < lenght; i++){
            if(arr[i] > Max){
                Max = arr[i];
            }
        }
        return Max;
    }
}
