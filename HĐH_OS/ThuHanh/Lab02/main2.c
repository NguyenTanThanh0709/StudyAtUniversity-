#include<stdio.h>

void main(int argc, char const *argv[]){
    int n = atoi(argv[1]);
    int i;
    for(i = 1; i <= n; i++){
        if(n%i == 0){
            printf("%d  ", i);
        }
    }
}