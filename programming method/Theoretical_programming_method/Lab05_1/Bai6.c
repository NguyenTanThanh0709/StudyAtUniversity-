#include<stdio.h>
#include<string.h>
#include<stdbool.h>

bool Checkdigits(char str[], char c){
    int i;
    int n = strlen(str);
    for(i = 0; i < n-1; i++){
        if(c == str[i]){
            printf("\n vi tri first : %d",i);
            return true;
        }
    }
    return false;
}

int main(){
    char str[100];
    char c;
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);


    printf("\n nhap vao ki tu : ");
    scanf("%c",&c);

    if(Checkdigits(str,c)){
        printf("\n yes");
    }else{
        printf("\n no");
    }

    return  0;
}