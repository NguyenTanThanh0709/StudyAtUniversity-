#include<stdio.h>


void enterArray(int A[], int n){
    int i;
    for(i = 0; i < n; i++){
        printf("a[%d] = ", i);
        scanf("%d", &A[i]);
    }
}

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



int main(){
    
    int n,  A[20];

       
    printf("nhap vao n : ");
    scanf("%d", &n);
    enterArray(A,n);
    disPlay(A,n);

    printf("\ntang dan\n");
    sortArray(A,n);
    disPlay(A,n);

    

    return 0;
}