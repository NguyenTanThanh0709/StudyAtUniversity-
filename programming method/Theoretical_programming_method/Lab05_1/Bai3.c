#include<stdio.h>
#include<string.h>



int main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    printf("\n %s",str);

    int i;
    int n = strlen(str);
    for(i = 0; i < n; i++){
        if(str[i] != ' '){
            printf("%c",str[i]);
        }else{
            printf("\n");
        }
    }

    return  0;
}