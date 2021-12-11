#include<stdio.h>
#include<string.h>

void NoiChuoi(char str[], char str1[]){
    char Noi[100];
    int h = 0,i,j;
    int n = strlen(str);
    int m = strlen(str1);
    for(i = 0; i < n-1; i++){
        Noi[h++] = str[i];
    }

    for(j = 0; j < m-1; j++){
        Noi[h++] = str1[j];
    }
    Noi[h] = '\0';

    printf("\n\n\t\t%s", Noi);
}

int main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    char str1[100];
    printf("nhap vao chuoi :  ");
    fgets(str1,99,stdin);

    NoiChuoi(str,str1);
    


    return 0;
}