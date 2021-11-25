#include<stdio.h>
#include<math.h>

void cau5(int n){

    int temp;
    int temp1;
    temp = n % 10;
    printf("last didits number is %d", temp);
    do{
        temp1 =n%10;
        n /= 10;
    }while(n > 0);
    
    printf("\nfirst digits number is %d", temp1);

}

int cau6(int n){
    int temp, sum =0;
     while(n>0){
         temp = n%10;
         n /= 10;
         sum += temp;
     }
     printf("sum digits number is %d", sum);
     return sum;
}

int cau7(int n){
    int temp, pr = 1;
     while(n>0){
         temp = n%10;
         n /= 10;
         pr *= temp;
     }
     return pr;
}

int cau8(int n){

    int temp;
    int cout = 0;
     while(n>0){
         temp = n%10;
         n /= 10;
         cout++;
     }

     return cout;
    
}

void cau9(int number){
        int digits = 0;
        int number1 = number;
        int numberOFswap;

        while(number>0){
            digits++;
            number /= 10;
        }
        int temp = number1 % (int) pow(10,digits-1);
        int last = number1 % 10;
        int first = number1 / pow(10,digits-1);
        //printf(" %d %d %d", first, last, digits);

            numberOFswap = last * ((int) pow(10,digits-1));
            numberOFswap += temp ;
            numberOFswap -= last;
            numberOFswap += first;
            printf("\n cau 9 %d\n", numberOFswap);


}

void cau10(int n){
    int daonguoc = 0;

    while(n>0){
         daonguoc = daonguoc*10 + n%10;
         n /= 10;
     }
     printf("\ncau 10: number reverse of number is %d\n", daonguoc);

}

int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     printf("cau5: \n");
     cau5(n);
    printf("\n cau6: %d\n", cau6(n));
    printf("cau7:product of digits number  %d", cau7(n));
     printf("\ncau8:cout ditgits of number  %d", cau8(n));
     cau9(n);
     cau10(n);
    
}
