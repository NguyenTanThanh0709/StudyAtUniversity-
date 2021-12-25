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



void bubbleSort(int A[], int n)
{
    int i, j;
	int min, temp; 
    for(i = 0; i < n-1; i++){
        min = i;
        for(j = i+1; j < n; j++){
            if(A[min] > A[j]){
                min = j;
            }
        }
        if( min != i){
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
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
    bubbleSort(A,n);
    disPlay(A,n);

    

    return 0;
}