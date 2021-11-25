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

void TransposeMatric(int a[][50], int m, int n, int b[][50]){
    int i, j;
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            b[j][i] = a[i][j];
        }
    }
}

int main(){
     int a[50][50], m, n;
     int b[50][50];
     
     printf("enter a number row of array :");
     scanf("%d", &m);
     printf("enter a number colums of array :");
     scanf("%d", &n);
     enterArray(a,m,n);
     displayArray(a,m, n);

     TransposeMatric(a,m,n,b);
     printf("\nmatric transpose:\n");
     displayArray(b,n,m);

     
     return -1;
}