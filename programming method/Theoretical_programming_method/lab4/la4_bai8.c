#include<stdio.h>

void enterArray(int a[100], int n){
    printf("enter an array:\n");
    for(int i = 0; i < n; i++){
        printf("a[%d] = ", i);
        scanf("%d", &a[i]);
    }
}

void printArray(int a[100], int n){
    printf("array is :\n");
    for(int i = 0; i < n; i++){
        printf("a[%d] = %d\n", i, a[i]);
    }
}

void deleteElenment(int a[100], int n, int xoavitri){
    for(int i = xoavitri; i < n; i++){
        a[i] = a[i+1];
    }
    --n;
}

int main(){
    int n;
    int a[100];
    printf("enter a number of array:");
    scanf("%d", &n);
    enterArray(a,n);
    printArray(a,n);

    deleteElenment(a,n,1);
    printArray(a,n-1);
    
    return 0;
}