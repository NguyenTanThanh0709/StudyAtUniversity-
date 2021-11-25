#include<stdio.h>

void enterArray(int a[100], int n){
    
    printf("enter an array:\n");
    int i;
    for( i = 0; i < n; i++){
        printf("a[%d] = ", i);
        scanf("%d", &a[i]);
    }
}

void printArray(int a[100], int n){
    printf("array is :\n");
    int i;
    for( i = 0; i < n; i++){
        printf("a[%d] = %d\n", i, a[i]);
    }
}

void Xu_ly(int a[], int n, int b[], int *m, int c[], int *e ){
    int i;
    for( i = 0; i < n; i++){
        if(a[i] % 2 == 0){
            b[*m] = a[i];
            *m++;
        } else{
            c[*e] = a[i];
            *e++;
        }
    }
}
int main(){
    int a[100], n;
    int b[50], m=0;
    int c[50], e=0;
    printf("enter a number of array:");
    scanf("%d", &n);
    printf("array 1 is:\n");
    enterArray(a,n);
    printArray(a,n);
    Xu_ly(a,n,b,&m,c,&e);
    printf("array even is :\n");
    printArray(b,m);
    printf("array odd is: \n");
    printArray(c,e);
    
    
}