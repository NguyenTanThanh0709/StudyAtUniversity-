#include<stdio.h>

void fac_n(int n){
    int i, sum = 1;
    for(i = 1; i <= n; i++){
        sum = sum * i;
    }
    printf("fac = %d", sum);
}