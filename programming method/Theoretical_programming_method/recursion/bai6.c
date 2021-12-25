#include<stdio.h>
#include<time.h>

void taomangkhongdequy(int A[],int n)
{    int i, min=-10;
    int max=10;
    for (i=0; i<n; i++)    
        A[i]=(rand()%(max-min+1))+min;
}

void XuatMang_KHONG_DEQUY(int A[], int n){
    int i;
    for(i = 0; i < n; i++){
        printf("%d ", A[i]);
    }
}

int DemLe_KHONGDEQUY(int A[], int n){
    int i, count = 0;
    for(i = 0; i < n; i++){
        if(A[i]%2 != 0){
            count++;
        }
    }
    return count;
}

int TonglonX_KHONGDEQUY(int A[], int n, int x){
    int i,  sum =0;
    for(i =0; i <n; i++){
        if(A[i]>x){
            sum += A[i];
        }
    }
    return sum;
}

float TongTB_KHONGDEQUY(int A[], int n){
    int i,  sum =0;
    for(i =0; i <n; i++){  
            sum += A[i];
    }
    return (float)sum/n;
}

void nhapMang(int A[], int n, int i){
    int min=1;
    int max=10;

    if(i == n) 
        return;

    A[i]=(rand()%(max-min+1))+min;
    nhapMang(A, n, i + 1);
}

void xuatMang(int A[], int n, int i ){
    if(i == n)
        return;
 
    printf("%5d", A[i]);
    xuatMang(A, n, i + 1);
}

int demle(int A[], int n, int i){
    if(i == n){
        return -1;
    }else{
        if(A[i] % 2 != 0){
            return 1 + demle(A,n,i+1);
        }else{
            return demle(A,n,i+1);
        }
    }
}

int demlonhonx(int A[], int n, int x, int i){
    if(i == n){
        return 0;
    }else{
        if(A[i] > x ){
            return A[i] + demlonhonx(A,n,x,i+1);
        }else{
            return demlonhonx(A,n,x,i+1);
        }
    }
}

int SUMTB(int A[], int n, int i){
    if(i == n){
        return 0;
    }else{
        return A[i] + SUMTB(A,n,i+1);
    }
}


int main(){
    int A[20];
    int n;
    srand((unsigned int) time (NULL));
    printf("nhap vao so luong mang : ");
    scanf("%d", &n);
    int x;
    printf("nhap vao x lam cau :");
    scanf("%d", &x);

    printf("\t\t KHONG DE QUY:\n");
    /*
    taomangkhongdequy(A,n);
    XuatMang_KHONG_DEQUY(A,n);
    printf("\ndem %d", DemLe_KHONGDEQUY(A,n));
    printf("\nsum lon hon x %d", TonglonX_KHONGDEQUY(A,n,x));
    printf("\nsumTB %f", TongTB_KHONGDEQUY(A,n));*/

    printf("\n su dung de quy : \n");
    nhapMang(A,n,0);
    xuatMang(A,n,0);
    printf("\ndem %d", demle(A,n,0));
    printf("\nsum lon hon x %d", demlonhonx(A,n,x,0));
    printf("\nsumTB %f", SUMTB(A,n,0)/n);


    return 0;
}