#include<stdio.h>
#include<stdbool.h>


int searchSequential(int A[], int n, int key){
    int i;
    bool check = false;
    for(i = 0; i < n; i++){
        if(key == A[i]){
            check = true;
            return i;
        }
    }
    if(check == false){
        return -1;
    }
}



int main(){

    int arr[] = {3, 5, 9, 12, 23, 45, 56, 58, 63, 65, 78, 89, 90};
    int n = sizeof(arr)/sizeof(arr[0]);
    if(searchSequential(arr,n,3) == -1){
        printf("\n not find");
    }else{
        printf("\nkey is find arr[%d]",searchSequential(arr,n,3));
    }

    return 0;
}