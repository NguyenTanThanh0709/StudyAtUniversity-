public class Bai06 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,1,2,4,9};
        System.out.println(findElementFirst(Array, 2));
    }

    public static int findElementFirst(int[] Array, int k){
        int lenght = Array.length;
        for(int i = 0; i < lenght; i++){
            if(Array[i] == k){
                return i;
            }
        }
        return -1;
    }
}
