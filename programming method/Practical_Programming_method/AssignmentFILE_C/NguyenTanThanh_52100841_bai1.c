#include<stdio.h>
#include<stdlib.h>

int sumArray(char *input01,char *output01, int a[], int n){
    FILE *Fin, *Fout;
    Fin = fopen(input01, "r");
    Fout = fopen(output01, "w");
    if( Fin == NULL){
        return -1;
    }
    
    int i;
    int sum = 0;
    for(i = 0; i < n; i++){
        fscanf(Fin, "%d", &a[i]);
    }
    int j;
    for(j = 0; j < n; j++){
        sum += a[j];
    }
    fprintf(Fout,"sum = %d", sum);
    fclose(Fin);
    fclose(Fout);

    return 0;
    
}

int main(){
    int n;
    int a[20];
    char  *input01 = "input01.txt";
    char  *output01 = "output01.txt";
    sumArray(input01, output01, a, 20);

    return 0;

}