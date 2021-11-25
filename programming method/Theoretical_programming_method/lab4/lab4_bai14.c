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

void tim_kiem(int a[], int n, int tiemkiem){
    for(int i = 0; i < n; i++){
        if(tiemkiem == a[i]){
            printf(" %d xuat hien tai vi tri %d\n",tiemkiem, i);
        }
    }
}

int main(){
    int a[100], n;
    int timkiem;
    
    printf("array 1 is:\n");
    enterArray(a,n);
    printArray(a,n);
    printf("ban muon tim so nao : ");
    scanf("%d", &timkiem);
    tim_kiem(a,n,timkiem);


}