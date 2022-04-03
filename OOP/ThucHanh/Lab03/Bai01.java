public class Bai01{
    public static void main(String[] args) {
        int[] arr = {1,7,5,6,2,9,8,-1,1,2,2};
        deleteElement(arr, 3);
        System.out.println();
        insertElement(arr,100,3);
        System.out.println();
        duplicateValue(arr);
        System.out.println();
        removeDuplicate(arr);
        
    }

    public static void printArray(int[] arr, int length){
        for(int i = 0; i < length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    
    public static boolean deleteElement(int[] arr, int k){
       int length = arr.length;
       boolean check = false;
       for(int i = 0; i < length; i++){
              if(arr[i] == k){
                check = true;
                for(int j = i; j < length - 1; j++){
                     arr[j] = arr[j + 1];
                }
                i--;
                length--;
              }
       }

       printArray(arr, length);

       return check;
    }

    public static void insertElement(int[] arr, int k, int index){
        int length = arr.length-1;
 
        for(int i = length ; i > index; i--){
             arr[i] = arr[i-1];
        }
 
        arr[index] = k;
        
        printArray(arr, length + 1);
            
        }

        public static void duplicateValue(int[] arr){
            int length = arr.length;
            int[] arr2 = new int[length];
            
            int h = 0;

            for(int i = 0; i <length; i++){
                for(int j = i+1; j <length; j++){
                    if(arr[i] == arr[j]){
                        arr2[h] = arr[j];
                        h++;
                    }
                }

            }

            printArray(arr2,h);
            
        }

        public static void removeDuplicate(int[] arr){
            int length = arr.length;

            int[] arr3 = new int[length];
            int h = 0;
            arr3[h++] = arr[0]; 
            boolean check;

            for(int i = 1; i <length; i++){
                check = true;
                for(int j = i-1; j >= 0; j--){
                    if(arr[i] == arr[j]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    arr3[h] = arr[i];
                    h++;
                }
            }
            printArray(arr3,h);
        }
    
}
    
