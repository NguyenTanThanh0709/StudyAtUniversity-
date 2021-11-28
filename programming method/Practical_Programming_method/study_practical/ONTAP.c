#include<stdio.h>
#include<math.h>

float cau1(int m, int h){
    int tien = 0;
    if(h <= 40){
        tien = h * m;
    }else if( h <= 45){
        tien = 40 * m + m * 1.8 *(h-40); 
    }else if(h <= 50){
        tien = 40*m + m*1.8*5 + (h-45)*m*2.5;
    } else{
        tien = 40*m + 5*1.8*m + 5*2.5*m +m*2.6*(h-50);
    }
    return tien;
}

int cau2(int d){
    int tien = 0;
    if(d <= 1){
        tien = d*18000;
    }else if(d <= 10){
        tien = 1*1800 + (d-1) * 8000;
    }else if(d <= 30){
        tien = 1 * 18000 + 9*8000 + (d-10)*6000;
    }else{
        tien = 1 * 18000 + 9*8000 + 20*6000 + (d-30)*4000;
    }
    return tien;
}

void cau3(float x0, float y0, float xa, float ya, float r){
    float dodai;
    dodai = (float)sqrt((float)pow(xa-x0,2)+(float)pow(ya-y0,2));

    if(dodai > r){
        printf("\nnam ngoai duong tron");
    }else{
        printf("\nnam trong duong tron");
    }
}

void cau8(int tien){
    int soto500, soto100, soto50, soto20, soto10;
    
    if(tien >= 500000){
        soto500 = tien / 500000;
        printf("\n%d so to 500.000\n",soto500);
    tien = (tien - soto500*500000);
    }

    if(tien >= 100000){
        soto100 = tien / 100000;
        printf("%d to 100.000\n", soto100);
        tien = (tien - soto100*100000);
    }

    if(tien >=50000){
        soto50 = tien / 50000;
        printf("%d to 50.000\n",soto50);
        tien = tien - soto50*50000;
    }

    if(tien >=20000){
        soto20 = tien / 20000;
        printf("%d to 20.000\n",soto20);
        tien = tien - soto20*20000;
    }

    if(tien >=10000){
        soto10 = tien / 10000;
        printf("%d to 10.000\n",soto10);
        
    }
    
}

void cau9(int mskh){
    int xephang1 = mskh / 1000;
    int xephang = xephang1 % 10;
    
    if(xephang <= 2){
        printf("\n khach hang hang dong\n");
    }else if( xephang <= 5){
        printf("\n khach hang hang bac\n");
    }else if(xephang <= 7){
        printf("\n khach hang hang vang\n");
    }else{
        printf("\n khach hang hang bach kiem\n");
    }
}

void cau10(int tienmua, int loai){
    int soluong;
    switch(loai){
        case 1:
            if(tienmua < 9000){
                printf("\nthieu tien!\n");
                break;
            }else{
                printf("\n Tra Xanh C2\n");
                printf("nhap vao so luong : ");
                scanf("%d", &soluong);
                if(9000*soluong > tienmua){
                    printf("\n thieu tien!\n");
                    break;
                }else{
                    printf("\n%d chai\n",soluong);
                    printf("tien du : %d",(tienmua-9000*soluong));
                }
                
            }
            break;
        case 2:
            if(tienmua < 11000){
                printf("\nthieu tien!\n");
                break;
            }else{
                printf("\n Tra Xanh Sting\n");
                printf("nhap vao so luong : ");
                scanf("%d", &soluong);
                if(11000*soluong > tienmua){
                    printf("\n thieu tien!\n");
                    break;
                }else{
                    printf("\n%d chai\n",soluong);
                    printf("tien du : %d",(tienmua-11000*soluong));
                }
                
            }
            break;

    }
}

int main(){
    int m,h;
    int d;
    float x0,y0,r,xa,ya;
    int tien;
    int mskh;
    int tien1, loai;

    int chon;
    printf("chon cau lam : ");
    scanf("%d", &chon);

    switch(chon){
        case 1: 
            printf("nhap vao so gio lam : ");
            scanf("%d", &h);
            printf("nhap vao so tien : ");
            scanf("%d", &m);
            printf("\n tien nhan dc la : %f \n", cau1(m,h));
            break;
        case 2:
            printf("nhap vao chieu dai duong di (km) : ");
            scanf("%d", &d);
            printf("\n tien la %d ", cau2(d));
            break;
        case 3: 
            printf("nhap vao toa do tam O : \n");
            scanf("%f%f", &x0,&y0);
            printf("nhap vao toa do  A : \n");
            scanf("%f%f", &xa,&ya);
            printf("nhap vao ban kinh R: ");
            scanf("%f", &r);
            cau3(x0,y0,xa,ya,r);
            break;
        case 8:
                printf("nhap vao tien cau doi (chia het 10000!): ");
                scanf("%d", &tien);
                if(tien % 10000 != 0){
                    printf("nhap du lieu sai !");
                    return 0;
                }
                cau8(tien);
                break;
        case 9:
            printf("nhap vao ma so khach hang: ");
            scanf("%d", &mskh);
            if(mskh > 99999 || mskh < 10000){
                printf("nhap sai!");
                return 0;
            }
            cau9(mskh);
            break;
        case 10: 
            printf("nhap vao loai muon mua : ");
            scanf("%d", &loai);
            printf("nhap so tien : ");
            scanf("%d", &tien1);
            cau10(tien1,loai);
            break;

    }

    return 0;
}