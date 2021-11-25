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

int minofArray(int a[100], int n){
    int min = a[0];
    for(int i = 1; i < n; i++){
        if(min > a[i]){
            min = a[i];
        }
    }
    return min;
}

int main(){
    int n;
    int a[100];
    printf("enter a number of array:");
    scanf("%d", &n);
    enterArray(a,n);
    printArray(a,n);
    printf("min of array is %d", minofArray(a,n));
}
