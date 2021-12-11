#include<stdio.h>

int Mu_2(int n){
    if(n == 1){
        return 2;
    }else{
        return 2*Mu_2(n-1);
    }
}

int main(){
    int n;
    printf("nhap vao n : ");
    scanf("%d", &n);

    printf("\n 2^%d = %d", n, Mu_2(n));

    return 0;
}