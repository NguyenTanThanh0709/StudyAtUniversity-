#include<stdio.h>
#include<stdbool.h>

bool checkPErFECT(int n){
    int temp = n;
    int sum = 0;
    for(int i = 1; i < n; i++){
        if(n % i == 0){
            sum += i;
        }
    }
    if(sum == temp){
        return true;
    } else{
        return false;
    }
}



int main(){

    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

      printf("AmSTRONG: ");
    for(int i = 1; i < n; i++){
        if(checkPErFECT(i)){
            printf("%d  ", i);
        }
    }
}