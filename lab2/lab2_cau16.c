#include <stdio.h>
#include <math.h>
#include <stdbool.h>

bool checkArmstrong(int  n)
{
int m,bien,bien1;
int s=0;
int count=0;
bien=n;
bien1=n;
while (n>0)
    {
        count++;
        n=n/10;
    }
while (bien>0)
    {
	    m=bien%10;
	    s=s+pow(m,count);
	    bien=bien/10;
    }
if (bien1==s) 
	printf("La so Armstrong");
else
	printf("Khong la so Armstrong");
}

	int main()
	{
	    int n,i;
	    do{
	        printf("Nhap vao 1 so:");
	        scanf("%d",&n);
	    }
	        while (!(n>0));
	        printf("So Armstrong:");
	        
	    for (i=1;i<n;i++)
	    {
	    if(checkArmstrong(i))
	    {
	    printf ("%d",i);
	    }
	    }
	}
