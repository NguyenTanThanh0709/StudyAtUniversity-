#include<stdio.h>
#include<stdbool.h>
#include<math.h>

bool cau11(int n){
    int temp = n;
     int palin = 0;
     while(n>0){
         palin = palin*10 + n%10;
         n /= 10;
     }
     if(palin == temp){
         return true;
     } else{
         return false;
     }
}

bool checkPRIME(int n){
    int i;
    for( i = 2; i <= n/2; i++){
        if(n % i == 0){
            return false;
        } else{
            return true;
        }
    }
}


bool checkAMSTRONG(int n){
    int temp = n;
    int temp1 = n;
    int result = 0, count = 0, reman;
    while(n>0){
        count++;
        n /= 10;
    }

    while(temp>0){
        reman = temp % 10;
        result += pow(reman,count);
        temp /= 10;
        
    }
    if(result == temp1){
        return true;

    } else{
        return false;
    }
}

bool checkPErFECT(int n){
    int temp = n;
    int sum = 0;
    int i;
    for(i = 1; i < n; i++){
        if(n % i == 0){
            sum += i;
        }
    }
    if(sum == temp){
        return true;
    } else{
        return false;
    }
}


int main(){
    int n;
    int chon;

    printf("nhap cau ban muon lam?");
    scanf("%d", &chon);
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));



     switch(chon){
         case 11:
    
     printf("cau11\n");
     if(cau11(n)){
         printf("yes!\n");
     } else{
         printf("not!\n");
     }
     break;
    case 12:
    printf("cau12:\n");
    if(checkPRIME(n)){
         printf("is prime number\n");
     } else{
         printf("not prime number\n");
     }
     break;

     case 13:

     printf("cau13:\n");
     if(checkAMSTRONG(n)){
        printf("is amtrong");

    } else{
        printf("not amstrong");
    }
    break;
    case 14:

    printf("\ncau14:\n");
    if(checkPErFECT(n)){
        printf("is perfect number");
    } else{
        printf("not perfect");
    }
    break;

    default: printf("loi!");


    }
}