
public class HeapSort {

    public static void heapify(int[] array,int size, int index){
        if(size == 0){
            return;
        }

        int currentIndex = index;
        int leftIndex = index *2 +1;
        int RightIndex = index *2 +2;

        if(leftIndex < size && array[leftIndex] > array[currentIndex]){
            currentIndex = leftIndex;
        }

        if(RightIndex < size && array[RightIndex] > array[currentIndex]){
            currentIndex = RightIndex;
        }

        if(currentIndex != index){
            int temp = array[currentIndex];
            array[currentIndex] = array[index];
            array[index] = temp;
            heapify(array, size, currentIndex);
        }
        
    }

    public static void heapSort(int[] array, int size){
        if(size == 0){return;}

        for(int i = size/2; i >= 0; i--){
            heapify(array, size, i);
        }

        for(int i = size-1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, i, 0);
        }


    }

    public static void print(int[] arr, int len){
        for(int i = 0; i < len; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
