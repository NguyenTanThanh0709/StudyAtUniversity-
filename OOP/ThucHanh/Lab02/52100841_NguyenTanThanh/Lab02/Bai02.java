public class Bai02 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,1,2,4,9};
        int Min = findMin(Array);
        System.out.println(Min);
    }

    private static int findMin(int[] array) {
        int Min = array[0];
        int lenght = array.length;
        for(int i = 1; i < lenght; i++){
            if(array[i] < Min){
                Min = array[i];
            }
        }
        return Min;
    }
}
