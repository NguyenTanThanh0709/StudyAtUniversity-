#include<stdio.h>
#include<string.h>

void XoaPhanTu(char str[], int vitri){
    int i;
    int n = strlen(str);
    for(i = vitri; i < n; i++){
        str[i] = str[i+1];
    }
}

void Xoa(char str[], int posi, int n){
    int count = 0;
    while(count < posi){
        count++;
        XoaPhanTu(str,n);
    }
}

int main(){

    int n;
    int posi;
    char str[100];

    printf("nhap vao chuoi : ");
    fflush(stdin);
    fgets(str,99,stdin);

    printf("nhap vao so phan tu : ");
    scanf("%d", &posi);

    printf("nhap vao vi tri : ");
    scanf("%d", &n);

    Xoa(str,posi,n);

    printf("\n\n\t\t%s",str);

    return 0;
}