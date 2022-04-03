public class Bai08 {
    public static void main(String[] args) {
        Integer[] Array = new Integer[]{1,2,3,4,5,6,1,2,4,9};
        System.out.println(findMax(Array));
    }

    public static Integer findMax(Integer []arr){
        Integer max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
