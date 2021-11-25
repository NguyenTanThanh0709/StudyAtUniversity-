#include<stdio.h>

int main(){
    int n, sum = 0;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     int temp;
     while(n>0){
         temp = n%10;
         n /= 10;
         sum += temp;
     }
     printf("sum digits number is %d", sum);
     return 0;
}