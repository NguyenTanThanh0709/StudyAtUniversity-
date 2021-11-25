#include<stdio.h>
#include<stdbool.h>
bool checkPRIME(int n){
    for(int i = 2; i <= n/2; i++){
        if(n % i == 0){
            return false;
        } else{
            return true;
        }
    }
}

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

      printf("PPRRIIMMEE: ");
    for(int i = 1; i < n; i++){
        if(checkPRIME(i)){
            printf("%d  ", i);
        }
    }
}