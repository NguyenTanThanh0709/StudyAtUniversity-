#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdbool.h>



void enterRANDOM(int Arr[],int n){	
    int i, min=-10; // thay ??i ch? này
	int max=10;// thay ??i ch? này
	for (i=0; i<n; i++)	
		Arr[i]=(rand()%(max-min+1))+min; // stdlib.h
}
void disPlay(int a[], int n){
	int i;
	for (i = 0; i < n; i ++)
		printf("a[%d] = %d\n",i,a[i]);
    
    printf("\n");
}

bool SoNTo(int n){
    int i;
    if(n < 2){
        return false;
    }
    for(i = 2; i < n; i++){
        if(n % i == 0){
            return false;
        }
    }
    return true;
}

int cau2(int a[], int n){
    int i;
    for(i = n-1; i >= 0; i--){
        if(SoNTo(a[i]) && a[i] != 1){
            return a[i];
            break;
        }
    }
    return 0;
}

int cau3(int a[], int n){
    int i, sum = 0;
    for(i = 2; i < n; i++){
        if(i % 2 == 0 && a[i] % 2 == 0 ){
            sum += a[i];
        }
    }
    return sum;
}

int cau4(int a[], int n){
    int i, max = a[0];
    for(i = 0; i < n; i++){
        if(a[i] > max){
            max = a[i];
        }
    }
    return max;
}

void tach_mang_SNT(int a[], int n,int c[], int *v){
    int i;
    for(i = 0; i < n; i++){
        if(SoNTo(a[i]) == false){
            c[*v] = a[i];
            (*v)++;
        }
    }
}

int cau6(int a[], int n){
    int i;
    int sum = 0;
    for(i = 2; i < n; i++){
        if(SoNTo(i) == true){
            sum += a[i];
        }
    }
    return sum;
}

int cau7(int a[], int n){
    int i;
    for(i = n-1; i >= 0; i--){
        if(a[i] < 0){
            return a[i];
            break;
        }
    }
    return 0;
}

int cau8(int a[], int n, int x){
    int i;
    int dem = 0;
    for(i = 0; i < n; i++){
        if(a[i] < x){
            dem++;
        }
    }
    return dem;
}

void xap_xep_tang_dan(int a[], int n){
    int i;
    int j;
    for(i = 0; i < n-1; i++){
        for(j = i+1; j < n; j++){
            if(a[i] > a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

void Xoa_phan_tu_cuoi(int a[], int n){
    int i;
    for(i = 0; i < n-1; i++){
        printf("a[%d] = %d \n",i, a[i] );
    }
}

void cau11(int a[], int n){
    int i;
    int dem = 0;
    for(i = 0; i < n; i++){
        if(a[i] < 0){
            dem++;
        }
    }
    printf("cau 11: \n");
    if(dem >= 2){
        printf("mang co ton tai hon 2 gia tri am!\n");
    } else{
        printf("not\n");
    }
}

void liet_ke_cau12(int a[], int n){
    int i;
    for(i = 0; i < n; i++){
        if(SoNTo(i) && i != 1){
            printf("a[%d] = %d, ",i,a[i]);
        }
    }
    printf("\n");
}

int cau13(int a[], int n){
    int i = 0, sum = 0;
    while (i<n){
        if(a[i] % 2 == 0 && a[i] > 0){
            int j;
            for(j = 1; j < a[i]; j++){
                if(a[i] % j == 0){
                    sum += j;
                }
            }
        }
       i++;
    }
    
    return sum;
}

void cau14(int a[], int n, int x){
    int i;
    printf("cau 14: \n");
    for(i = 0; i < n; i++){
        if(a[i] < x){
            printf("a[%d] = %d,  ",i,a[i]);
        }
    }
    printf("\n");
}

void cau15(int a[], int n, int x, int c[], int *v ){
    int i;
    printf(" \n");
    for(i = 0; i < n; i++){
        if(a[i] < x){
            c[*v] = a[i];
            (*v)++;
        }
    }
    printf("\n");
}

void cau16(int a[], int n){
    
    if(a[n-2] < 0){
        printf("**CAU 16: a[%d] = %d la phan tu am ke cuoi!\n", n-2, a[n-2]);
    } else{
        printf("**CAU 16: not co!\n");
    }
}

void Them_Phan_Tu(int a[], int *n, int x, int vt)
{
    int i;
    
	for( i = *n - 1; i >= vt; i--)
	{
		a[i + 1] = a[i];
	}
    a[vt] = x;
	(*n)++; 
}


void cau17(int a[], int *n, int x){
   int i;
   for(i = 0; i<*n; i++){
       if(SoNTo(a[i])){
           Them_Phan_Tu(a, &*n, x, i + 1);
       }
   }
}


void cau21(int a[], int n, int b[], int *soluong){
    int i;
    for(i = 0; i < n; i++){
        b[*soluong] = a[i];
        (*soluong)++;
    }
}


void main(){
    int x;
    int v = 0;
    int c[100];
    int n, a[100];
    int x1;
    int v1 = 0;
    int c1[50];
    int y,x2;
    int b[100], soluong = 0;
    srand((unsigned int) time (NULL));
    do{
        printf("enter number  0 < n <= 10:");
        scanf("%d", &n);
    }while(!(n>0 && n <= 10));

    enterRANDOM(a,n);
    disPlay(a,n);

    int chon;
    printf("chon cau ban muon lam : ");
    scanf("%d", &chon);

    switch(chon){
        case 2:
            if(cau2(a,n) == 0){
            printf("khong co so nguyen to!");
        } else{
            printf("CAU 2: so nto cuoi cung la %d\n", cau2(a,n));
        }
            break;
        case 3: 
            printf("CAU 3 : %d\n", cau3(a,n));
            break;
        case 4:
            printf("CAU 4: max is %d\n", cau4(a,n));
            break;
        case 5: 
            tach_mang_SNT(a,n,c,&v);
            printf("CAU 5 mang da xoa so nguyen to la:\n");
            disPlay(c,v);
            break;
        case 6:
            printf("cau 6: tong phan tu tai vi tri snt : %d\n", cau6(a,n));
            break;
        case 7:
                    if( cau7(a,n) == 0){
                printf("CAU 7: khong co so am!\n");
            } else{
                printf("CAU 7: am cuoi mang la %d\n ", cau7(a,n));
            }
            break;
        case 8:
                printf("nhap vao x:");
                scanf("%d", &x);
                printf("CAU 8: %d gia tri < %d \n",cau8(a,n,x), x);
                break;
        case 9:
                xap_xep_tang_dan(a,n);
                printf("CAU 9: mang da xap xep tang dan :\n");
                disPlay(a,n);
                break;
        case 10:
                printf("cau 10: xoa phan tu cuoi: \n");
                Xoa_phan_tu_cuoi(a,n);
                break;
        case 11:
                cau11(a,n);
                break;
        case 12:
                printf("cau 12:\n");
                liet_ke_cau12(a,n);
                break;
        case 13: printf("cau 13: sum = %d \n", cau13(a,n));
                break;
        case 14: printf("nhap vao x1 :");
                scanf("%d", &x1);
                cau14(a,n,x1);
            break;
        case 15: cau15(a,n,x1,c1,&v1);
                xap_xep_tang_dan(c1,v1);
                printf("cau15: xap xep cac ham nho hon %d tang dan\n", x1);
                disPlay(c1,v1);
                break;
        case 16: cau16(a,n); break;
        case 17: 
                    printf("cau 17: \n");
                printf("nhap vao number:");
                scanf("%d", &x2);
                cau17(a,&n,x2);
                disPlay(a,n);
                break;
        case 21: cau21(a, n, b, &soluong);
                    printf("cau 21 khi mang da copy qua mang b:\n");
                    disPlay(b,soluong);
                    break;

        default:
            printf("nhap so khong hop le!");
        break;
    }

    // cau 18 lap lai cau 15 ^^
    // cau 19 giong cau 6 ^^ 
    // cau 20 giong cau 16 ^^
    // cau 22 lap lai cac cau kia ^^
    // cau 23 lap lai cac cau kia ^^
    // cau 24 lap lai cac cau kia ^^
    
}
