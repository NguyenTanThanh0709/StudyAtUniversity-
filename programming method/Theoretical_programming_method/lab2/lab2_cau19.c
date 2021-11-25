#include<stdio.h>

int factorial(int n){
    if(n == 1){
        return 1;
    }

    return n * factorial(n-1);
}

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     printf("factorial: %d", factorial(n));

}