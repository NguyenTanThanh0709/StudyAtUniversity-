#include<stdio.h>

int main(){
    int n, daonguoc;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     while(n>0){
         daonguoc = daonguoc*10 + n%10;
         n /= 10;
     }
     printf("number reverse of number is %d", daonguoc);
     return 0;
}