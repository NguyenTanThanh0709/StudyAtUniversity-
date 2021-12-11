#include<stdio.h>
#include<string.h>

void DeleteSpace(char str[]){
    int i;
    for(i = 0; str[i] != '\0'; i++){
        if(str[i] == '\n'){
            str[i] = '\0';
        }
    }
}

int Lenght(char str[]){
    int count = 0;
    int i = 0;
    DeleteSpace(str);
    while(str[i] != '\0'){
        count++;
        i++;
    }
    return count;
}

int main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    printf("string lenght : %d",Lenght(str));

    return 0;
}