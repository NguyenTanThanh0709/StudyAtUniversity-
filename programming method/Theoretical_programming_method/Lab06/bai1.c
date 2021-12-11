#include<stdio.h>
#include<stdbool.h>

bool checkPrime(int n, int i){
    if(i == 1){
        return true;
    }else{
        if(n %  i == 0){
            return false;
        }else{
            checkPrime(n, i-1);
        }
    }
}

int main(){
    int n;
    printf("nhap vao n : ");
    scanf("%d", &n);

    if(checkPrime(n,n-1)){
        printf("\n is prime number");
    }else{
        printf("\n not prime number");
    }

    return 0;
}