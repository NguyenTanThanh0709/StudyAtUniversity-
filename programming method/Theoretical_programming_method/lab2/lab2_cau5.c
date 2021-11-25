#include<stdio.h>

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

    int temp;
    int temp1;
    temp = n % 10;
    printf("last didits number is %d", temp);
    do{
        temp1 =n%10;
        n /= 10;
    }while(n > 0);
    
    printf("\nfirst digits number is %d", temp1);
}