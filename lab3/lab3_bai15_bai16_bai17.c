#include<stdio.h>
#include<stdbool.h>
#include<math.h>

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
    int i;
    int j;
    int chon;
    printf("nhap cau ban muon lam:");
    scanf("%d", &chon);
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

    
    switch(chon){
        case 15:
                printf("PPRRIIMMEE: ");
                for( i = 1; i < n; i++){
                    if(checkPRIME(i)){
                        printf("%d  ", i);
                    }
                }
                break;
        case 16:
                printf("AmSTRONG: ");
                for( j = 1; j < n; j++){
                    if(checkAMSTRONG(j)){
                        printf("%d  ", j);
                    }
                }
                    break;
        case 17:
                    printf("perfect number: ");
                    int k;
                for( k = 1; k < n; k++){
                    if(checkPErFECT(k)){
                        printf("%d  ", k);
                    }
                }
                break;
        default: printf("error!");
    }
}