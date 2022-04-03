

public class Bai10 {
    public static void main(String[] args) {
        int[] Array = new int[]{1,2,3,4,5,4,5,5,6,6,1,2,4,4,9};
        System.out.println(findTheThirdLargestElement(Array));
        
    }


    public static void sortArray(int[] Arr){
        int lenght = Arr.length;
        for(int i = 0; i < lenght; i++){
            for(int j = i + 1; j < lenght; j++){
                if(Arr[i] < Arr[j]){
                    int temp = Arr[i];
                    Arr[i] = Arr[j];
                    Arr[j] = temp;
                }
            }
        }
    }

    public static int[] tachPhanTuTrungNhau(int[] arr){
        boolean check;
        int lenght = arr.length;
        int[] result = new int[lenght];
        int h = 0;
        for(int i = 0; i < lenght; i++){
            check = true;
            for(int j = 0; j < lenght; j++){
                if(arr[i] == arr[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                result[h++] = arr[i];
            }
        }
        return result;
    }

    public static int findTheThirdLargestElement(int[] arr){
        int[] arr1 = tachPhanTuTrungNhau(arr);
        int lenght = arr1.length;
        
        sortArray(arr1);
        int count = 0;
        for(int i = 0; i < lenght; i ++){
            for(int j = 0; j < lenght; j++){
                if(arr1[i] < arr1[j]){
                    count++;
                }
            }

            if(count == 2){
                return arr1[i];
            }
        }
        return -1;
    }

    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
