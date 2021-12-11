#include<stdio.h>

int Mu(int x, int n){
    if(n == 1){
        return x;
    }else{
        return x*Mu(x,n-1);
    }
}

int main(){
    int n,x;

    printf("\n x^n \n");

    printf("nhap x : ");
    scanf("%d", &x);
    printf("nhap n : ");
    scanf("%d", &n);

    printf("\n %d^%d = %d\n",x,n,Mu(x,n));

    return 0;
}