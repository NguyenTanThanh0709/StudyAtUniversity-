#include<stdio.h>
#include<math.h>

void checkAMSTRONG(int n){
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
        printf("is amtrong");

    } else{
        printf("not amstrong");
    }
}


int main(){
    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));
    
    checkAMSTRONG(n);

}