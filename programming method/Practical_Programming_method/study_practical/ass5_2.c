#include<stdio.h>
#include<stdbool.h>

void enterARRAY(int a[][20], int m, int n){
    int i,j;
    printf("\n\n\t\t Nhap Mang :\n");
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            printf("a[%d][%d] = ",i,j);
            scanf("%d", &a[i][j]);
        }
    }

}

void disPlayARRAY(int a[][20], int m, int n){
    int i,j;
    printf("\n\n\t\t xuat Mang :\n");
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            printf("%d\t", a[i][j]);
        }
        printf("\n");
    }

}

int dem_PhanTu_X(int a[][20], int m, int n, int x){
    int i, j;
    int dem = 0;
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            if(a[i][j]<x){
                dem++;
            }
        }
    }
    return dem++;
}

bool is_soNt(int n){
    if(n < 2){
        return false;
    }
    if(n == 2){
        return true;
    }
    int i;
    for(i = 2; i < n; i++){
        if(n % i == 0){
            return false;
        }
    }
    return true;
}

void LietKet(int a[][20], int m, int n){
    int i, j;
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            if(is_soNt(a[i][j])){
                printf("%d\t", a[i][j]);
            }
        }
    }
}

int Max_is(int a[][20], int m, int n){
    int i, j;
    int max = a[0][0];
    for(i = 0; i < m; i++){
        for(j = 1; j < n; j++){
            if(max < a[i][j]){
                max = a[i][j];
            }
        }
    }
    return max;
}

bool kiemtrasoAM(int a[][20], int m, int n){
    int i,j;
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            if(a[i][j] < 0){
                return true;
            }
        }
    }
    return false;
}

void Tong_soDong(int a[][20], int m, int n){
    int i,j;
    for(i = 0; i < m; i++){
        int sum = 0;
        for(j = 0; j < n; j++){
            sum += a[i][j];
        }
        printf("sum dong %d = %d\n",i,sum);
    }
}

int Dong_LOn_Nhat(int a[][20], int m, int n, int b[]){
    int i,j;
    for(i = 0; i < m; i++){
        int sum = 0;
        for(j = 0; j < n; j++){
            sum += a[i][j];
        }
        b[i] = sum;
    }
    int max = b[0];
    int k;
    int h = 0;
    for(k = 1; k < m; k++){
        if(max < b[k]){
            max = b[k];
            h = k;    
        }
    }
    return h;
}

int main(){
    int a[20][20], m,n,x;
    int b[20];
    do{
    printf("nhap vao hang: ");
    scanf("%d", &m);
    printf("nhap vao n: ");
    scanf("%d", &n);
    }while( m < 0 || n < 0);
    enterARRAY(a,m,n);
    disPlayARRAY(a,m,n);

    int chon;
    printf("muon lam cau nao: ");
    scanf("%d", &chon);
    
    switch(chon){
        case 1:
            printf("nhap vao x :");
            scanf("%d", &x);
            printf("cau 1: co %d gia tri < hon %d",dem_PhanTu_X(a,m,n,x),x);
            break;
        case 2:
            printf("\ncau 4 :\n");
            LietKet(a,m,n);
        case 3:
            printf("\n cau 3: max la %d", Max_is(a,m,n));
            break;
        case 4:
            if(kiemtrasoAM(a,m,n)){
                printf("\n mang co so am!\n");
            } else{
                printf("\n mang khong co so am!\n");
            }
            break;
        case 5:
            printf("\n cau 5: \n");
            Tong_soDong(a,m,n);
            break;
        case 6 :
            printf("\ncau 6 : dong co max la %d", Dong_LOn_Nhat(a,m,n,b));
            break;
    }

    return 0;
}