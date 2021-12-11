#include<stdio.h>
#include<math.h>

int Factorial(int n){
    if( n == 1){
        return 1;
    }else{
        return n*Factorial(n-1);
    }
}

int cauA(int n){
    if(n == 0){
        return;
    }else{
        return 2*n+1 + cauA(n-1);
    }
}

int cauB(int n){
    if(n == 0){
        return;
    }else{
        return n/2 + cauB(n-1);
    }
}

int cauC(int n){
    if(n == 1){
        return;
    }else{
        return Factorial(n) + cauC(n-1);
    }
}

int cauD(int n){
    if(n == 1){
        return 1;
    }else{
        return sqrt(n) + cauD(n-1);
    }
}

int cauE(int n){
    if(n == 1){
        return 1;
    }else{
        return Factorial(n) * cauC(n-1);
    }
}

int main(){
    int n;
    printf("nhap vao n : ");
    scanf("%d", &n);

    printf("\n cau a : %d", cauA(n));
    printf("\n cau b : %d", cauB(n));
    printf("\n cau c : %d", cauC(n));
    printf("\n cau d : %d", cauD(n));
    printf("\n cau e : %d", cauE(n));

    return 0;
}