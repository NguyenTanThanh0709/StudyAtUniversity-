#include<stdio.h>

int cau1(int n){
    int i, sum = 0;
    for( i = 1; i <= n; ++i){
        if(i % 2 ==0){
           sum += i;
         }
     }
     return sum;
}

int cau2(int n){
    int i, sum = 0;
    for(i = 2; i <= n; ++i){
        if(i % 2 != 0){
           sum += i;
         }
     }
     return sum;
}

void cau3(int n){
    int i, table;
    for(i=1; i<=10; i++)
    {
        table = n*i;
        printf("%d * %2d = %2d\n",n, i, table);
    }
    
}

int cau4(int n){
    int i, sum =0;
    for( i = 1; i <= n; ++i){
           sum += i;
     }
     return sum;
}

 int main(){
     int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     printf("cau 1 : %d\n", cau1(n));
     printf("cau2 :sum odd = %d", cau2(n));
     printf("\nTable of %d is:\n", n);
     cau3(n);

     printf("cau4:sum  = %d", cau4(n));

    
     return 0;
 }