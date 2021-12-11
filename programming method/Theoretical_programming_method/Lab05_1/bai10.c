#include<stdio.h>
#include<string.h>

void Chen(char str[], char str1[], int n){
    int i,j;
    int n1 = strlen(str);
    int n2 = strlen(str1);
    char temp[100];
    int h = 0;
    for(i  = n; i < n1; i++){
        temp[h++] = str[i];
    }
    
    char temp1[100];
    int k = 0;
    for(j = 0; j < n; j++){
        temp1[k++] = str[j];
    }
    
    int l;
    for(l = 0; l < n2; l++){
        temp1[k++] = str1[l];
    }
    
    strcat(temp1, temp);
    printf("%s",temp1);
    
}

int main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    char str1[100];
    printf("nhap vao chuoi :  ");
    fgets(str1,99,stdin);
    
    int n;
    printf("nhap vao vi tri chen : ");
    scanf("%d", &n);

    Chen(str,str1,n);

    return 0;
}