#include <stdio.h>
#include <stdlib.h>
int main(int argc, char * argv[])
{
	int i, s=0;
	if (argc==2 && atoi(argv[1])>0)
	{
		for (i=0; i<=atoi(argv[1]); i++)
		{
			s=s+i;
		}
		printf("S = %d\n",s);
	}
	else if (argc>2)
	{
		printf("Co qua nhieu doi so\n");
	}
	else
	{
		printf("Doi so khong phai la so nguyen duong\n");
	}
	return 0;
}
