public class Bai04 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,6,1,2,4,9};
        System.out.println(countSpecificElement(Array, 1));
    }

    public static int countSpecificElement(int[] array, int element) {
        int count = 0;
        int lenght = array.length;
        for(int i = 0; i < lenght; i++){
            if(array[i] == element){
                count++;
            }
        }
        return count;
    }
}