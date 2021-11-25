#include<stdio.h>

void enterArray(int a[100], int n){
    printf("enter an array:\n");
    int i;
    for( i = 0; i < n; i++){
        printf("a[%d] = ", i);
        scanf("%d", &a[i]);
    }
}

void printArray(int a[100], int n){
    printf("array is :\n");
    int i;
    for( i = 0; i < n; i++){
        printf("a[%d] = %d\n", i, a[i]);
    }
}

 void reverseArray(int a[100], int n){
     int i;
     for( i = 0; i < n/2; i++){
         int temp = a[i];
         a[i] = a[n - 1 - i];
         a[n - 1 -i] = temp;
     }
 }

int main(){
    int n;
    int a[100];
    printf("enter a number of array:");
    scanf("%d", &n);
    enterArray(a,n);
    printArray(a,n);

    reverseArray(a,n);
    printArray(a,n);
    
    return 0;
}