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
    int i,j;
    printf("array is:\n");
    for( i = 0; i < m; i++){
        for( j = 0; j < n; j++){
            printf("%d\t", a[i][j]);
           
        }
         printf("\n");
    }
}

void tich(int a[50][50], int b[50][50], int c[50][50], int m, int n, int p) {
	int i, j, k;
	for(i = 0; i < m; i++) {
		for(j = 0; j < p; j++) {
            for(k = 0; k < n; k++){
                c[i][j] += a[i][k] * b[k][j];
            }
		}
	}
}

 int main(){
     int a[50][50], b[50][50], m, n,p;
     int c[50][50];
    printf("enter a number row of array :");
     scanf("%d", &m);
     printf("enter a number colums of array :");
     scanf("%d", &n);
    printf("nhap vao p:");
    scanf("%d", &p);

     enterArray(a,m,n);
     displayArray(a,m, n);

     enterArray(b,n,p);
     displayArray(b,n,p);

    tich(a,b,c,m,n,p);
    displayArray(c,m,n);

 }