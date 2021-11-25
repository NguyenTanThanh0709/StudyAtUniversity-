#include<stdio.h>
#include<stdbool.h>

void enterArray(int a[][50], int m, int n){
     
     int i,j;
     for( i = 0; i < m; i++){
         for( j = 0; j < n; j++){
             printf("a[%d][%d]=",i,j);
             scanf("%d", &a[i][j]);
         }
     }
 }

void displayArray(int a[][50], int m, int n){
    printf("array is:\n");
    int i,j;
    for( i = 0; i < m; i++){
        for( j = 0; j < n; j++){
            printf("%d\t", a[i][j]);
           
        }
         printf("\n");
    }
}

bool checkArrayEQUAL(int a[][50], int b[][50], int m, int n){
    int i, j;
    for( i = 0; i < m; i++){
        for( j = 0; j < n; j++){
            if(a[i][j] != b[i][j]){
                return false;
            }
        }
    }
    return true;
}

int main(){
     int a[50][50], b[50][50], m, n;
     int c[50][50];
     printf("enter a number row of array :");
     scanf("%d", &m);
     printf("enter a number colums of array :");
     scanf("%d", &n);
     enterArray(a,m,n);
     displayArray(a,m, n);

     enterArray(b,m,n);
     displayArray(b,m,n);

     if(checkArrayEQUAL(a,b,m,n)){
         printf("two matrices equal!");
     } else{
         printf("two matrices not equal! ");
     }
}