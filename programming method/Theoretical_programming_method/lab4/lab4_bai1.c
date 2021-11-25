#include<stdio.h>

int factorial(int n){
    if(n == 1){
        return 1;
    }
    return n * factorial(n-1);
}

float cauA(int n){
    float sum = 0.0;
    int i;
    for( i = 1; i <= n; i++){
        sum += i/2;
    }
    return sum;
}

int cauB(int n){
    int sum = 0;
    int i;
    for( i = 1; i <= n; i++){
        sum += 2*i + 1;
    }
    return sum;
}

int cauC(int n){
    int sum = 0;
    int i;
    for( i = 1; i <= n; i++){
        sum += (factorial(i) + 1);
    }
    return sum;
}

int cauD(int n){
    int sum = 0;
    int i;
    for(i = 1; i <= n; i++){
        sum += (factorial(i));
    }
    return sum;
    
}

float cauE(int n){
    int i;
    float sum = 0.0;
    for( i = 0; i <= n; i++){
        sum += (2*i)/3;
    }
    return sum;
}

int main(){
    int n;
    printf("enter a number:");
    scanf("%d", &n);
    printf("cau a: %f\n", cauA(n));
    printf("cau b: %d\n", cauB(n));
    printf("cau c: %d\n", cauC(n));
    printf("cau d: %d\n", cauD(n));
    printf("cau e: %f\n", cauE(n));

    return 0;
}