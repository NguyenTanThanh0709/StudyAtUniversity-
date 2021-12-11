#include<stdio.h>
#include<string.h>

void doi_thanh_chuthuong(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < n-1; i++){
        if(str[i] >= 'A' && str[i] <= 'Z'){
            str[i] += 32;
        }
    }
}

void ChuyenKytu_DauHoa(char str[]){
    int i;
    int n = strlen(str);
    if(str[0] != ' '){
        str[0] -= 32;
    }
    for(i = 0; i < n; i++){
        if(str[i-1] == ' ' && str[i] != ' '){
            str[i] -= 32;
        }
    }
    
}

int main(){
    char str[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);

    doi_thanh_chuthuong(str);
    ChuyenKytu_DauHoa(str);

    printf("\n %s",str);

    return  0;
}