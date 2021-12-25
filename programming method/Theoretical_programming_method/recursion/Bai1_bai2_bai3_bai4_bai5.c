#include<stdio.h>
#include<math.h>
#include<stdbool.h>

int LuyThua(int x, int y){
    if(y == 1){
        return x;
    }else{
        return x * LuyThua(x,y-1);
    }
}


int factorial(int n){
    if( n == 1){
        return n;
    }else{
        return n*(factorial(n-1));
    }
}

int Cau3(int n){
    if(n == 0){
        return 1;
    }else{
        return 2*n+1 * Cau3(n-1);
    }
}

int Cau4(int n){
    if(n == 0){
        return 1;
    }else{
        return 2*n+1 + Cau4(n-1);
    }
}

int cau5(int n){
    if( n == 1){
        return 1;
    }else{
        return n*pow(-1,n+1) + cau5(n-1);
    }
}

int cau6(int n){
    if(n == 1){
        return 1;
    }else{
        return factorial(n) + cau6(n-1);
    }
}

int cau7(int n){
    if(n == 1){
        return 1;
    }else{
        return pow(n,2) + cau7(n-1);
    }
}


bool Cau8(int n){
    if(n < 0.1){
        return true;
    }else {
        int m = n%10;
        if(m % 2 == 0){
        return false;
        }
        return Cau8(n/10);
    }
    
    
}

int main(){
    int n;
    printf("nhap n : ");
    scanf("%d", &n);

    printf("cau 1 : %d",LuyThua(2,3));
    
    printf("cau 2 : %d ", factorial(n));
    printf("cau 3 : %d ", Cau3(n));
    printf("cau 4 : %d ", Cau4(n));
    printf("cau 5 : %d ", cau5(n));
    printf("cau 6 : %d ", cau6(n));
    printf("cau 7 : %d ", cau7(n));

    if(Cau8(111111)){
        printf("yes");
    }else{
        printf("no");
    }

    
    return 0;
}