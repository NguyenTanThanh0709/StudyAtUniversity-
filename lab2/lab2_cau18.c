#include<stdio.h>

void toBINARY(int n){
    if(n == 0){
        return;
    }
    int r = n % 2;
    toBINARY(n/2);
    printf("%d",r);
}

int main(){

    int n;
     do{
         printf("enter a number > 0:");
        scanf("%d", &n);
     }while(!(n>0));

     toBINARY(n);

}