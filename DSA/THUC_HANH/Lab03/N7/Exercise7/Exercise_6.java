public class Exercise_6{
    public static int findMin(int[] array){
        int min = array[0];
        return findMin(array, 0, min);
    }

    private static int findMin(int[] array,int i, int min){
        if(i == array.length){
            return min;
        }
        if(min >= array[i]){
            min = array[i];
        }
        return findMin(array,i+1, min);
    }

    public static int sumArray(int[] array, int len){
        int sum = 0;
        return sumArray(array,len,0,sum);
    }

    private static int sumArray(int[] array, int len, int i, int sum){
        if( i == len){
            return sum;
        }
        sum = array[i] + sumArray(array, len, i+1, sum);
        return sum;
    }

    public static int  countEvenInArray(int[] array, int len){
        int count = 0;
        return countEvenInArray(array, len, 0, count);
    }

    private static int countEvenInArray(int[] array, int len, int i, int count){
        if(i == len){
            return count;
        }
        if(array[i] % 2 == 0){
            count++;
        }
        return countEvenInArray(array, len, i+1, count);
    }

    public static void main(String[] args) {
        int[] myNum = {101, 2, 30, 2};
        System.out.println(countEvenInArray(myNum,4));
    }
}