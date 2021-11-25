#include<stdio.h>
#include<stdbool.h>

bool checkPRIME(int n);

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));
     if(checkPRIME(n)){
         printf("is prime number");
     } else{
         printf("not prime number");
     }
}

bool checkPRIME(int n){
    for(int i = 2; i <= n/2; i++){
        if(n % i == 0){
            return false;
        } else{
            return true;
        }
    }
}