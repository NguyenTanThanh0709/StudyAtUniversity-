#include<stdio.h>

int main()
{
    int num, i, table;
    printf("Enter the number: ");
    scanf("%d", &num);
    printf("\nTable of %d is:\n", num);
    for(i=1; i<=10; i++)
    {
        table = num*i;
        printf("%d * %2d = %2d\n", num, i, table);
    }
    
    return 0;
}