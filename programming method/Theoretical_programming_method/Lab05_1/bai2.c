#include<stdio.h>
#include<string.h>

void Ham_DaoNguoc(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < (n)/2; i++){
        char temp = str[i];
            str[i] = str[n-1-i];
            str[n-1-i] = temp;
    }
}

int main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    Ham_DaoNguoc(str);
    printf("\n %s",str);


    return 0;
}