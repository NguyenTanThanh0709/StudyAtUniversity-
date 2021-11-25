#include<stdio.h>
#include<string.h>
#include<stdbool.h>

int dem_kytu_trang(char str[]){
    int dem = 0;
    int i = 0;
    while(str[i] != '\0'){
        if(str[i] == ' '){
            dem++;
        }
        i++;
    }
    return dem;
}

void doi_thanh_chuthuong(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < n-1; i++){
        if(str[i] >= 'A' && str[i] <= 'Z'){
            str[i] += 32;
        }
    }
    printf("\nmang sau khi doi chu thuong : %s \n",str);
}

void doi_thanh_chuHoa(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < n-1; i++){
        if(str[i] >= 'a' && str[i] <= 'z'){
            str[i] -= 32;
        }
    }
    printf("\nmang sau khi doi chu Hoa: %s \n",str);
}

void Ham_DaoNguoc(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < (n)/2; i++){
        char temp = str[i];
            str[i] = str[n-1-i];
            str[n-1-i] = temp;
    }
}

bool Chuoi_DoiXung(char str[]){
    int i;
    int n = strlen(str);
    for(i = 0; i < (n-1)/2; i++){
        if(str[i] != str[n-1-1-i]){
            return false;
        }
    }
    return true;
}

int dem_tu_trongchuoi(char str[]){
    int dem = 0, i;
    int n = strlen(str);
    if(str[0] != ' '){
        dem++;
    }

    for(i = 0; i < n-1-1; i++){
        if(str[i] == ' ' && str[i+1] != ' '){
            dem++;
        }
    }
    return dem;
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
    printf("nhap vao 1 chuoi ky tu : ");
    fgets(str,99,stdin);
    printf("\n ky tu la : %s\n",str);

    int chon;
    printf("nhap cau ban muon lam : ");
    scanf("%d", &chon);

    switch(chon){
        case 1:
            printf("so khoang trang %d", dem_kytu_trang(str));
            break;
        case 2:
            doi_thanh_chuthuong(str);
            break;
        case 3:
            doi_thanh_chuHoa(str);
            break;
        case 4:
            Ham_DaoNguoc(str);
            printf("\n ham dao nguoc: %s \n", str);
            break;
        case 5:
            if(Chuoi_DoiXung(str)){
                printf("\ntrue\n");
            }else{
                printf("\nflase\n");
            }
            break;
        case 6:
            printf("\n so tu trong chuoi la %d \n", dem_tu_trongchuoi(str));
            break;
        case 7:
            ChuyenKytu_DauHoa(str);
            printf("\n ham da chuyen la: %s \n",str);
            break;

    }

    return 0;
}
