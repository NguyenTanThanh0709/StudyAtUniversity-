#include<stdio.h>

int main(){
    int n, cout = 0;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     int temp;
     while(n>0){
         temp = n%10;
         n /= 10;
         cout++;
     }
     printf("cout ditgits of number  %d", cout);
     return 0;
}