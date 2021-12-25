#include<stdio.h>
#include<stdbool.h>

void disPlay(int A[], int n){
    int i;
    for(i = 0; i < n ;i++){
        printf("%d  ", A[i]);
    }
}

void sortArray(int A[], int n){
    int i, j;
    for(i = 0; i < n-1; i++){
        for(j = i+1; j < n; j++){
            if(A[i]>A[j]){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
    }
}


void binarySearch(int A[], int n, int x){
    int b[10], h = 0;
    int kiemtra;
    sortArray(A,n);
    int left = 0, right = n-1, mid;
    while(left <= right){
        mid = (left+right)/2;
        if(A[mid] == x){
             kiemtra = 1;
            b[h++] = mid;
        }
        if(x > A[mid]){
            left = mid +1;
        }else{
            right = mid -1;
        }
    }
    if(kiemtra == 1){
        printf("\nbinary search\n");
        disPlay(b,h);
    }else{
        printf("\n khong xuat hien ");
    }

}



int main(){

    int arr[] = {3, 5, 9, 12, 23, 45, 56, 58, 63, 65, 78, 89, 90};
    int n = sizeof(arr)/sizeof(arr[0]);
    
    binarySearch(arr,n,5);

    return 0;
}