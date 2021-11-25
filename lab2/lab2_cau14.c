#include<stdio.h>

void checkPErFECT(int n){
    int temp = n;
    int sum = 0;
    for(int i = 1; i < n; i++){
        if(n % i == 0){
            sum += i;
        }
    }
    if(sum == temp){
        printf("is perfect number");
    } else{
        printf("not perfect");
    }
}

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));
    
    checkPErFECT(n);


}