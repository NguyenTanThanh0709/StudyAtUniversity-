#include<stdio.h>

void sum_n(int n){
    int i, sum = 0;
    for(i = 0; i <= n; i++){
        sum += i;
    }
    printf("sum = %d", sum);
}