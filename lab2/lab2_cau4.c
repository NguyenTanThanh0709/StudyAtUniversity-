#include<stdio.h>

int main(){
    int n, sum = 0;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     for(int i = 1; i <= n; ++i){
           sum += i;
     }
     printf("sum  = %d", sum);
     return 0;
}