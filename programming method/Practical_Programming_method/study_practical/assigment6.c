#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdbool.h>

void input(int a[][10], int n)
{
	int i,j, min=0, max=9;
	for(i=0; i<n; i++)
	{
		for(j=0; j<n; j++)
		{
			a[i][j]=(rand()%(max-min+1))+min;	
		}
	}
}

void output(int a[][10], int n){
    int i,j;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            printf("%d\t",a[i][j]);
        }
        printf("\n");
    }
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

int dem_snt_cheophu(int a[][10], int n){
    int i,j;
    int dem = 0;
    for(i = 0; i < n; i++){
        if(is_soNt(a[i][n-1-i])){
            dem++;
        }
    }
    
    return dem;
}

void tamgiac_cheochinh(int a[][10], int n){
    int i,j;
    for(i = 0; i < n; i++){
        for(j = 0; j <= i; j++){
            
            printf("%d\t",a[i][j]);
            
        }
    }
}

int Phantu_lonnhat(int a[][10], int n){
    int i,j,h, max = a[0][0];

    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if(max < a[i][j]){
                max = a[i][j];
            }
        }
    }
    return max;
}

int max_cheophu(int a[][10], int n){
    int i,k=0;
    int b[10]; 
    for(i = 0; i < n; i++){
        if(a[i][n-1-i] % 2 == 0)
        b[k] = a[i][n-1-i];
        k++;
    }
    int h;
    int max = b[0];
    for(h = 1; h < k -1; k ++){
        if(max < b[h]){
            max = b[h];
        }
    }
    return max;
}

void max_tungdong(int a[][10], int n){
    int i,j;
    for(i = 0; i < n; i++){
        int max = a[i][0];
        for(j = 0; j < n ;j++){
            if(max < a[i][j]){
                max = a[i][j];
            }
        }
        printf("max dong %d la %d\n", i, max);
    }
}

int sum_omauxanh(int a[][10], int n){
    int i,j, sum = 0;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if((i+j) == 0 || (i+j) % 2 == 0){
                sum += a[i][j];
            }
        }
    }
    return sum;
}

int tong_phantu_tamgiactren(int a[][10], int n){
    int i,j, sum = 0;
    for(i = 0; i < n; i++){
        for(j = i+1; j < n; j++){
            sum += a[i][j];
        }
    }
    return sum;
}

int tong_phantu_tamgiacduoiphu(int a[][10], int n){
    int i,j, k = 0, sum = 0;
    for(i = n -1; i >= 1; i--){
        for(j = 1 + k; j < n; j++ ){
            sum += a[i][j];
        }
        k++;
    }
    return sum;
}

int timdong_cox(int a[][10], int n, int x){
    int i,j;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if(x == a[i][j]){
                return i;
            }
        }
    }
    return -1;
}

void Vitri_lonnhat(int a[][10], int n){
    int i,j,h, max = a[0][0];
    int dong=0, cot=0;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if(max < a[i][j]){
                max = a[i][j];
                dong = i;
                cot = j;
                
            }
        }
    }
    printf("max dau tien o vi tri: \ncot : %d\n dong : %d",cot,dong);
}

void nhan_2matran(int a[][10], int b[][10],int n, int c[][10]){
    int i,j,k;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            for(k = 0; k < n; k++){
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
}

int dem_solanxh_x(int a[][10], int n, int x){
    int i,j;
    int dem = 0;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if(a[i][j] == x){
                dem++;
            }
        }
    }
    return dem;
}

int phantuxh_nhieunhat(int a[][10], int n){
    int i,j, temp1;
    int temp = dem_solanxh_x(a,n,a[0][0]);
    int i1,j1;

    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            temp1 = dem_solanxh_x(a,n,a[i][j]);
            if(temp < temp1){
                temp = temp1;
                i1 = i;
                j1 = j;
            }
        }
    }
    return a[i1][j1];
}

int main(){
    int n,a[10][10];
    printf("nhap vao ma tran vuong : ");
    scanf("%d", &n);
    srand(time(NULL));

    int x;

    int b[10][10], c[10][10];

    input(a,n);
    output(a,n);

    int chon;
    printf("ban muon lam cau nao :");
    scanf("%d", &chon);

    switch(chon){
        case 1 : 
            printf("\n cau 1: so nguyen to tren cheo phu la %d\n", dem_snt_cheophu(a,n));
            break;
        case 2 :
            printf("\n cau 2: \n");
            tamgiac_cheochinh(a,n);
            break;
        case 3:
            printf("\ncau 3: max is : %d \n", Phantu_lonnhat(a,n));
            break;
        case 4:
            printf("\n cau 4: max chan cheo phu : %d", max_cheophu(a,n));
            break;
        case 5:
            printf("cau 5\n");
            max_tungdong(a,n);
            break;
        case 6:
            printf("\n cau 6 : sum cua o xanh la %d", sum_omauxanh(a,n));
            break;
        case 7:
            printf("\n cau 7: sum tam giac tren la %d\n", tong_phantu_tamgiactren(a,n));
            break;
        case 8:
            printf("\n cau 8: sum cheo phu duoi la %d\n",tong_phantu_tamgiacduoiphu(a,n));
            break;
        case 9:
            printf("nhap vao x: ");
            scanf("%d", &x);
            printf("\n dong  %d xuat hien %d dau tien \n", timdong_cox(a,n,x),x);
            break;
        case 10:
            printf("\ncau 10\n");
            Vitri_lonnhat(a,n);
            break;
        case 12: 
            input(b,n);
            printf("\n\n\t\tma tran da nhan la :\n");
            nhan_2matran(a,b,n,c);
            output(c,n);
            break;
        case 11:
            printf("\n cau 11: %d xuat hien nhieu nhat\n",phantuxh_nhieunhat(a,n));
            break;
    }

    

    return 0;
}
