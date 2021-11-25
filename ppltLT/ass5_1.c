#include<stdio.h>
#include<stdbool.h>

void enterN(int *n){
    do{
        printf("enter n odd and n > 0:");
        scanf("%d", &*n);
        if( *n % 2 == 0 || *n < 0){
            printf("enrror, enter number again!");
        }
    }while(*n % 2 == 0 || *n < 0);
}

void enterArray(int a[], int n){
    int i;
    printf("\n\n\t\t enter ARRAY\n");
    for(i = 0; i < n; i++){
        printf("a[%d] = ", i);
        scanf("%d", &a[i]);
    }
}

void display(int a[], int n){
    int i;
    printf("\n\n\t\t display ARRAY\n");
    for(i = 0; i < n; i++){
        printf("a[%d] = %d\n",i,a[i]);
    }
}

bool Check_oddnumber(int a[], int n){
    int i;
    for(i  = 0; i < n; i++){
        if(a[i] % 2 != 0){
            return true;
        }
    }
    return false;
}

bool checkSUM(int a[], int n, int x){
    int i;
    for(i = 0; i < n; i++){
        if(a[i] == x){
            if(a[i] == a[i+1]+a[i+2]){
                return true;
            }
        }
    }
    return false;
}

void chen_phan_tu(int a[], int *n, int x, int vitri){
    int i;
    for( i = *n; i > vitri; i--){
        a[i] = a[i-1];
    }
    a[vitri] = x;
    (*n) = (*n) + 1;

}

void xap_xep_mang_tang(int a[], int n){
    int i, j;
    for(i = 0; i < n-1; i++){
        for(j =i+1; j < n; j++){
            if(a[i]>a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

void xap_xep_mang_giam(int a[], int n){
    int i, j;
    for(i = 0; i < n-1; i++){
        for(j =i+1; j < n; j++){
            if(a[i]<a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

void Xoa_phantu(int a[], int *n, int vitri){
    int i;
    for(i = vitri; i < *n-1; i++){
        a[i] = a[i+1];
    }
    (*n)--;
}

void Xoa_phantu_X(int a[], int *n, int x){
    int i;
    for(i = 0; i < *n; i++){
        if(a[i] >= x){
            Xoa_phantu(a,&*n,i);
            i--;
        }
    }
}

int main(){
    int n, a[20];
    int x;
    int choose;
    int x1, vitri, x2, vitri2, x3;
    enterN(&n);
    enterArray(a,n);
    display(a,n);
    printf("cau ban muon lam: ");
    scanf("%d", &choose);

    switch(choose){
        case 1:
            printf("\ncau 1: \n");
            if(Check_oddnumber(a,n)){
                printf("array have odd number!\n");
            }else{
                printf("not have ood!\n");
            }
            break;
        case 2:
            printf("\n cau 2 : \n");
            printf("enter x :");
            scanf("%d", &x);
            if(checkSUM(a,n,x)){
                printf("yes!\n");
            }else{
                printf("NOT!\n");
            }
            break;
        case 3 :
            printf("nhap vao phan tu muon them: ");
            scanf("%d", &x1);
            printf("vitri muon chen :");
            scanf("%d", &vitri);
            chen_phan_tu(a,&n,x1,vitri);
            display(a,n);
            break;
        case 4:
            xap_xep_mang_tang(a,n);
            display(a,n);
            break;
        case 5:
            printf("enter x2 muon chen: ");
            scanf("%d", &x2);
            printf("enter vitri2: ");
            scanf("%d", &vitri2);
            chen_phan_tu(a,&n,x2,vitri2);
            xap_xep_mang_giam(a,n);
            display(a,n);
            break;
        case 6:
            printf("enter x3 muon xoa: ");
            scanf("%d", &x3);
            Xoa_phantu_X(a,&n,x3);
            display(a,n);
    }
    

    return 0;
}