#include<stdio.h>
#include<string.h>


void checkWord(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < n -1; i++){
        if(str[i] != ' '){
            printf("vi tri la %d",i+1);
            return;
        }
        if(str[i] == ' '){
        printf("\n vi tri dau tu tu la %d",i);
        return;
    }
    }
    printf("\n chuoi co 1 tu");
}

void main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    checkWord(str);

}