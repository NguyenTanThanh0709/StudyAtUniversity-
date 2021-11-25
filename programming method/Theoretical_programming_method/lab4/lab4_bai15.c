#include<stdio.h>

void enterArray(int a[100], int &n){
    printf("enter a number of array:");
    scanf("%d", &n);
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

void xap_xep_tang_dan(int a[], int n){
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            if(a[i] > a[j]){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        }
    }
}


int main(){
    int a[100], n;
    
    printf("array 1 is:\n");
    enterArray(a,n);
    printArray(a,n);
    xap_xep_tang_dan(a,n);
    printf("mang da xap xep is\n");
    printArray(a,n);
    
    
}