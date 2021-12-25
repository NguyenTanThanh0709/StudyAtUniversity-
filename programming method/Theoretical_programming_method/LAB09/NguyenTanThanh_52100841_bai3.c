#include<stdio.h>
#include<stdlib.h>

int MaxMatric(int a[][20], int n){
    int i,j;
    int max = a[0][0];
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if( max < a[i][j]){
                max = a[i][j];
            }
        }
    }
    return max;
}

int MinMatric(int a[][20], int n){
    int i,j;
    int max = a[0][0];
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if( max > a[i][j]){
                max = a[i][j];
            }
        }
    }
    return max;
}

int  DongcoPhanTuLonNhat(int a[][20], int n){
    int i,j;
    int b[100];
    int h = 0;
    for(i = 0; i < n; i++){
        int sum = 0;
        for(j = 0; j < n; j++){
            sum += a[i][j];
        }
        b[h++] = sum;
    }
    int k;
    int max = b[0];
    int temp;
    for(k = 0; k < h; k++){
        if( max < b[k]){
            max = b[k];
            temp = k;
        }
    }
    return temp;
}

void ReadFile(char *input, char *output,int a[][20], int n){
    FILE *Fin = fopen(input,"r");
    FILE *Fout = fopen(output,"w");

    fscanf(Fin,"%d", &n);
    int i,j;
    for(i = 0;i < n; i++){
        for(j = 0; j < n; j++){
            fscanf(Fin,"%d", &a[i][j]);
        }
    }

    fprintf(Fout, "\nmax is %d\n", MaxMatric(a,n));
    fprintf(Fout, "\nmin is %d\n", MinMatric(a,n));
    fprintf(Fout, "\ndong max  %d\n", DongcoPhanTuLonNhat(a,n));

    fclose(Fin);
    fclose(Fout);
}

int main(){
    int a[20][20];
    int n;
    
    char *name1 = "matran.txt";
    char *name2 = "xuatmatran.txt";

    ReadFile(name1,name2,a,n);

    return 0;
}