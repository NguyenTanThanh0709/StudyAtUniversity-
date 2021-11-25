#include<stdio.h>

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

void tru(int a[50][50], int b[50][50], int c[50][50], int m, int n) {
	int i, j;
    printf("\ntong la :\n");
	for(i = 0; i < m; i++) {
		for(j = 0; j < n; j++) {
			c[i][j] = a[i][j] - b[i][j];
		}
	}
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

    tru(a,b,c,m,n);
    displayArray(c,m,n);

 }