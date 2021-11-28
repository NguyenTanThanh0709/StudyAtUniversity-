// ATM RUT TIEN
#include<stdio.h>

void Rut_tien(int *sodubandau){
    int ruttien;
    do{
        printf("\n muon rut bao nhieu (tien rut < 2.000.000): ");
        scanf("%d", &ruttien);
    }while(ruttien > 2000000);

    printf("\n da rut thanh cong %d dong!\n",ruttien);
    *sodubandau -= ruttien;
    printf("\n\n so du con lai khi rut la : %d",*sodubandau);
}

void Chuyen_Tien(int *sodubandau){
    int chuyentien;
    printf("\n ban muon chuyen bao nhieu tien : ");
    scanf("%d", &chuyentien);

    printf("\n da chuyen tien thanh cong!\n");
    *sodubandau += chuyentien;

    printf("\n so du sau khi chuyen la %d dong\n",*sodubandau);
}

int main(){
    int sodubandau = 10000000;
    int chon;

    do{
        printf("\n\n\t\t ---------MENU--------\n");
        printf("1. rut tien\n");
        printf("2. kiem tra so du\n");
        printf("3. chuyen tien\n");
        printf("0. khong choi nua\n");
        printf("\n\n\t\t muon lam gi:");
        scanf("%d", &chon);

        switch(chon){
            case 1: Rut_tien(&sodubandau);
                break;
            case 2: 
                printf("\n\n so du la : %d",sodubandau);
                break;
            case 3:
                Chuyen_Tien(&sodubandau);
                break;
        }


    }while(chon != 0);

    return 0;
}