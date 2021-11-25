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

void xu_ly(int a[], int b[], int n, int m, int c[], int &soluong){
    
    for(int i = 0; i < n; i++){
        c[soluong] = a[i];
        soluong++;
    }

    for(int i = 0; i < m; i++){
        c[soluong] = b[i];
        soluong++;
    }

}

int main(){
    int n,m;
    int a[100];
    int b[100];
    int c[200], soluong = 0;
    printf("array 1 is:\n");
    enterArray(a,n);
    printArray(a,n);
    printf("array 2 is :\n");
     enterArray(b,m);
    printArray(b,m);
    printf("array da tron is :");
    xu_ly(a,b,n,m,c,soluong);
    printArray(c,soluong);
    
    
}