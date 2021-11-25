#include<stdio.h>
#include<math.h>

int main(){
    int number;
    int numberOFswap;
    int digits = 0;
    do{
        printf("enter a number > 0 : ");
        scanf("%d", &number);
    } while(!(number>0));
    int number1 = number;

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
    printf("\n %d", numberOFswap);

return 0;

}