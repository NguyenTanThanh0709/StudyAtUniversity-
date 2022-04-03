#include <stdio.h>
int main (void)
{
	int a[100];
	int n,i,j;
	printf("Input the number of Arr: ");
	scanf("%d",&n);
	
	for (i=0; i<n; i++)
	{
		printf("Input element %d ",i+1);
		scanf("%d",&a[i]);
	}
	int t;
	//Selection sort : Thuat toan sap xep
	for (i=0; i<n-1; i++)
	{
		for (j=i+1; j<n; j++)
		{
			if (a[i]>a[j])
			{
				t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
	}
	printf("Array after manage: ");
	for (i=0; i<n; i++)
	{
		printf("%d\t",a[i]);
	}
}
