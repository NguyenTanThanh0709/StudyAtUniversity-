#include<stdio.h>

void DiemTrungBinh(float qt1, float qt2, float ghk, float chk){
    float diem;
    diem = (qt1*10 + qt2*20 + ghk*20 + chk*50)/100;

    if(diem < 5.0){
        printf("\nhoc lai di con!\n");
    } else if(diem < 6.5){
        printf("\nTRUNG BINH\n");
    } else if(diem < 8.0){
        printf("\n kha \n");
    } else if(diem <9.0){
        printf("gioi");
    }else{
        printf("xuat con me no xac");
    }
}

int Tien_GiuXe(int gio){
    int tien = 0;
    int tien1;
    int sogioconlai;
    int sogio24;

    if(gio <= 2){
        tien = 20000;
    }else if( gio <= 10){
        tien = 20000 + 15000*(gio-2);
    } else if(gio <= 23){
        tien = 20000 + 8*15000 + (gio-10)*10000;
    }else{
        if(gio == 24){
            return 200000;
        }
        sogio24 = gio / 24;
        sogioconlai = gio - 24*sogio24;

            if(sogioconlai <= 2){
            tien = 20000+ sogio24*200000;
        }else if( sogioconlai <= 10){
            tien = 20000 + 15000*(sogioconlai-2)+ sogio24*200000;
        } else if(sogioconlai <= 23){
            tien = 20000 + 8*15000 + (sogioconlai-10)*10000 + sogio24*200000;
        }
    }
    return tien;
}

int main(){
    float qt1,  qt2, ghk,  chk;
    int chon;
    int gio;
    printf("muon lam cau nao ???? ");
    scanf("%d", &chon);

    switch(chon){
        case 12:
            printf("nhap vao lan luot tung diem : \n");
            scanf("%f%f%f%f",&qt1,  &qt2, &ghk,  &chk);
            printf("\n cau 12 : \n");
            DiemTrungBinh(qt1,  qt2, ghk,  chk);
            break;
        case 13:
            printf("nhap vao gio:");
            scanf("%d", &gio);
            printf("\n cau 13:tien gui la %d\n",Tien_GiuXe(gio));
            break;
    }


    return 0;
}