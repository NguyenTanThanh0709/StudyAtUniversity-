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

int coutnumberduplicate(int a[100], int n){
    int cout = 0;
    int i,j;
    for( i = 0; i < n; i++){
        for( j = i + 1; j < n; j++){
            if(a[i] == a[j] ){
                cout ++;
            }
        }
    }
    return cout;
}

int main(){
    int n;
    int a[100];
    printf("enter a number of array:");
    scanf("%d", &n);
    enterArray(a,n);
    printArray(a,n);
    printf("is %d", coutnumberduplicate(a,n));
}