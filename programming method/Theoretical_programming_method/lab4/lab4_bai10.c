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


void kiem_tra(int a[], int b[], int n, int &m){
    m = 0;
    b[0] = a[0];
    m++;
    for(int i = 1; i < n; i++){
        bool kiemtra = true;
        for(int j = i - 1; j >= 0; j--){
            if(a[i] == a[j]){
                kiemtra = false;
                break;
            }
        }
        if(kiemtra){
            b[m] = a[i];
            m++;
        }
    }
}   



int main(){
    int n;
    int a[100];
    int b[100], m;

    enterArray(a,n);
    printArray(a,n);
    kiem_tra(a,b,n,m);
    printf("ham da xoa phan tu trung lap:\n");
    printArray(b,m);
}