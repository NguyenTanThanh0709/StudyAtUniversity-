#include <stdio.h>
#include <stdlib.h>
int main( int argc, char * argv[])
{
	int i, dem=0;
	int n= atoi(argv[1]);
	if (argc==2 && n>0)
	{
		for (i=1; i<=n; i++)
		{
			if (n%i==0)
			{
				printf("%d\t",i);
			}
		}
		printf("\n%d = ",n);
		for (i=2; i<=n; i++)
		{
			while (n%i == 0)
			{
				n=n/i;
				dem=dem+1;
				printf("%d",i);
				if (n>1)
					printf("*");
			}
		}
	}
	else if (argc>2)
		printf("Co qua nhieu doi so");

	else 
		printf("Doi so khong phai so nguyen duong");
	return 0;
}

