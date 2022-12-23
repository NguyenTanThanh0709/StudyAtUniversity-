
public class test {
    public static void main(String[] args) {
        int[] array = {1,5,2,9,31,7,3,13,52,1,4,1,3,5,6};

        HeapSort.heapSort(array,array.length);
        HeapSort.print(array, array.length);
    }
}
