#include<stdio.h>

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     int temp = n;
     int palin = 0;
     while(n>0){
         palin = palin*10 + n%10;
         n /= 10;
     }
     if(palin == temp){
         printf("is palindrome");
     } else{
         printf("not palindrome");
     }
}