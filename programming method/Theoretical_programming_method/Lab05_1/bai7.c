#include<stdio.h>
#include<string.h>
#include<stdbool.h>

void Checkdigits(char str[], char c){
    int i;
    int mang[100];
    int h = 0;
    int n = strlen(str);
    for(i = 0; i < n-1; i++){
        if(c == str[i]){
            mang[h++] = i;
        }
    }
    int j;
    printf("%c xuat hien tai vi tri : ",c);
    for(j = 0; j < h; j++){
        printf("%d  ",mang[j]);
    }
}

int main(){
    char str[100];
    char c;
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);


    printf("\n nhap vao ki tu : ");
    scanf("%c",&c);

    Checkdigits(str,c);

    return  0;
}