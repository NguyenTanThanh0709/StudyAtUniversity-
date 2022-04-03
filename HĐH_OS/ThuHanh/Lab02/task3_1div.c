#include<stdio.h>
#include<stdlib.h>
#include<libstatic.h>

void main(int argc, char *argv[]){
    int i = atoi(argv[1]);
    int k = atoi(argv[2]);
    int m = atoi(argv[3]);

    sum_n(i);
    fac_n(k);
    div_n(m);
}