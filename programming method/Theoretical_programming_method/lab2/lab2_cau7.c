#include<stdio.h>

int main(){
    int n, pr = 1;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     int temp;
     while(n>0){
         temp = n%10;
         n /= 10;
         pr *= temp;
     }
     printf("product of digits number  %d", pr);
     return 0;
}