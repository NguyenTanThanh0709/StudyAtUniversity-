#include<stdio.h>

int digitsNumber(int n,int cout){
    if(n == 0){
        return cout;
    }else{
        digitsNumber(n/10,cout+1);
    }
}

int main(){

    int n;
    printf("nhap vao n : ");
    scanf("%d", &n);

    printf("\n digits number is %d", digitsNumber(n,0));

    return 0;
}