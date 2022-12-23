import java.util.NoSuchElementException;


public class MaxHeap{
    int[] maxHeap;
    int sizeMaxHeap;
    int maxSize;

    public MaxHeap(int maxSize){
        this.maxSize = maxSize+1;
        this.sizeMaxHeap = 0;
        maxHeap = new int[this.maxSize];
        maxHeap[0] = -1;
    }

    public int indexParent(int index){
        return index / 2;
    }

    public int indexLeft(int index){
        return 2*index;
    }

    public int indexRight(int index){
        return 2*index + 1;
    }

    public void insertElement(int data){
        if(this.maxSize == this.sizeMaxHeap){
            throw new NoSuchElementException("full size");
        }
        this.sizeMaxHeap++;
        this.maxHeap[this.sizeMaxHeap] = data;
        ShiftUp(this.sizeMaxHeap);
    }

    private void ShiftUp(int sizeMaxHeap) {
        while(sizeMaxHeap > 1 && this.maxHeap[sizeMaxHeap] > this.maxHeap[indexParent(sizeMaxHeap)]){
            swap(sizeMaxHeap, indexParent(sizeMaxHeap));
            sizeMaxHeap = indexParent(sizeMaxHeap);
        }
    }

    private void swap(int sizeMaxHeap2, int indexParent) {
        int temp = this.maxHeap[sizeMaxHeap2];
        this.maxHeap[sizeMaxHeap2] = this.maxHeap[indexParent];
        this.maxHeap[indexParent] = temp;
    }

    private void swap(int[] maxHeap ,int sizeMaxHeap2, int indexParent) {
        int temp = maxHeap[sizeMaxHeap2];
        maxHeap[sizeMaxHeap2] = maxHeap[indexParent];
        maxHeap[indexParent] = temp;
    }

    public int indexLastParent(){
        int index = -1;
        if(this.sizeMaxHeap == 0){
            return index;
        }
        index = this.sizeMaxHeap /2;
        return index;
    }

    public void heapify(int[] arr, int size, int index){
        if(size == 0){
            throw new NoSuchElementException("Null");
        }

        int currentIndex = index;
        int leftIndex = currentIndex *2+1;
        int RightIndex = currentIndex *2 + 2;
        if(leftIndex < size && arr[leftIndex] > arr[currentIndex]){
            currentIndex = leftIndex;
        }
        if(RightIndex < size && arr[RightIndex] > arr[currentIndex]){
            currentIndex = RightIndex;
        }

        if(currentIndex != index){
            swap(arr,currentIndex,index);
            heapify(arr, size, currentIndex);
        }
    }

    public void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print( arr[i] + " ");
        }
        System.out.println();
    }

    public int getElement(int index){
        return this.maxHeap[index];
    }

    public int extractMax(){
        if(this.sizeMaxHeap == 0){
            throw new NoSuchElementException("NULL");
        }
        int max = this.maxHeap[1];
        this.maxHeap[1] = this.maxHeap[sizeMaxHeap];
        this.maxHeap[sizeMaxHeap] = -1;
        this.sizeMaxHeap--;
        shiftDown(1);
        return max;

        
    }

    public void shiftDown(int index){
        while(index < this.sizeMaxHeap){
            if(this.maxHeap[index] < this.maxHeap[indexLeft(index)] && this.maxHeap[index] < this.maxHeap[indexRight(index)]){
                if(this.maxHeap[indexLeft(index)] > this.maxHeap[indexRight(index)]){
                    swap(index, indexLeft(index));
                    index = indexLeft(index);
                }else{
                    swap(index, indexRight(index));
                    index = indexRight(index);
                }
            }else if(this.maxHeap[index] < this.maxHeap[indexLeft(index)]){
                swap(index, indexLeft(index));
                index = indexLeft(index);
            }else if(this.maxHeap[index] < this.maxHeap[indexRight(index)]){
                swap(index, indexRight(index));
                index = indexRight(index);
            }else{
                break;
            }
        }
    }

    public void heapSort(int[] arr, int size){
        if(size == 0){
            throw new NoSuchElementException("null");
        }
        for(int i = ((size/2)-1); i >= 0; i--){
            heapify(arr, size, i);
        }

        for(int i = size-1; i >= 0; i--){
            swap(arr, i, 0);
            heapify(arr, size, 0);
        }

        print(arr);

    }

    public void print(){
        for(int i = 1; i <= this.sizeMaxHeap; i++){
            System.out.print( this.maxHeap[i] + " ");
        }
        System.out.println();
    }
}