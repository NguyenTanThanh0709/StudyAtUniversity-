

public class Main {
    public static void main(String[] args) {
        MaxHeap mh =new MaxHeap(40);
        // mh.insertElement(5);
        // mh.insertElement(6);
        // mh.insertElement(7);
        // mh.insertElement(3);
        // mh.insertElement(9);
        // mh.print();
        // int[] arr = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
    //     int[] arr = {9,8,7,2,10,6,11,7};

    //     for(int i = 0; i < arr.length; i++){
    //         mh.insertElement(arr[i]);
    //     }
    //     mh.print();
    // System.out.println(mh.getElement(mh.indexLastParent()));
    int[] arr = {3,1,6,5,44,2,4,100};
    mh.heapSort(arr, arr.length);
    int x = 0;
    }
}
