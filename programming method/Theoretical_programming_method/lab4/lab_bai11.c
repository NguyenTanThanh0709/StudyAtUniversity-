#include<stdio.h>
#include<stdbool.h>

void enterArray(int a[100], int n){
    int i;
    for( i = 0; i < n; i++){
        printf("a[%d] = ", i);
        scanf("%d", &a[i]);
    }
}

void printArray(int a[100], int n){
    printf("array is :\n");
    int i;
    int j;
    for( i = 0; i < n; i++){
        printf("a[%d] = %d\n", i, a[i]);
    }
}


void kiem_tra(int a[], int b[], int n, int *m){
    *m = 0;
    b[0] = a[0];
    (*m)++;
    int i;
    int j;
    for( i = 1; i < n; i++){
        bool kiemtra = true;
        for( j = i - 1; j >= 0; j--){
            if(a[i] == a[j]){
                kiemtra = false;
                break;
            }
        }
        if(kiemtra){
            b[*m] = a[i];
            (*m)++;
        }
    }
}   

void XuLy(int a[], int b[], int n, int *m){
    int i,j;
    printf("enter a number of array:");
    scanf("%d", &n);
    printf("enter an array:\n");
    kiem_tra(a,b,n,&*m);
    for( i = 0; i < *m; i++){
        int dem = 0;
        for( j = 0; j < n; j++){
            if(b[i] == a[j]){
                dem++;
            }
        }
        printf("%d xuat hien %d lan\n", b[i], dem);
    }
}

int main(){
    int n;
    int a[100];
    int b[100], m;

    enterArray(a,n);
    printArray(a,n);
    XuLy(a,b,n,&m);
    
}