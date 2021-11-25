#include<stdio.h>

 int main(){
     int n, sum = 0;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

    for(int i = 2; i <= n; ++i){
        if(i % 2 != 0){
           sum += i;
         }
     }
     printf("sum odd = %d", sum);
     return 0;
 }