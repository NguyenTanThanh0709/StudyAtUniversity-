#include<stdio.h>
#include<string.h>
#define MAX 100

int sequential_search(int str[], int length, int k){  
    int i;
	for(i = 0; i < length; i++)
	{
	    if(str[i] == k)
		{
		    return i;
		}
	}
    return -1;
}

void selection_sort(int str[], int length){
    int i, j, temp, min;
	for(i = 0; i<length-1; i++)
	{
		min = i;
	    for(j = i+1; j<length; j++)
		{
		    if(str[j]<str[min])
			{
				min = j;
			}
		}
		if(min != i){
			temp = str[min];
			str[min] = str[i];
			str[i] = temp;
		}
	}
} 

int binary_search(int str[], int length, int k){
    int mid, left = 0, right = length-1;
	mid = (left + right)/2;
	do{
	    if(k == str[mid]){
	        return mid;
	    }
	    else if(k > str[mid]){
		    right = mid-1;
	    }
	    else{ 
		    left = mid + 1;
	    }
	}
	while(left<=right);
	return -1;
}

int main(){
	int str[MAX];
	int i;
	FILE *Fin;
	int length = MAX;
	Fin = fopen("chuoi.txt", "r");

	if(Fin!=NULL)
	{
	    fgets(str, MAX, Fin);
	}

	fclose(Fin);

	int key;
    int choose;
	do{
		printf("\n\n\t\tMENU:");
		printf("\n1. Search theo kiểu sequential search");
		printf("\n2. Search theo kiểu binary search");
		printf("\n3. Thoat");

		printf("\nChoose one of these search program: ");
		scanf("%d", &choose);
		switch(choose){
			case 1: 
				printf("Enter the key: ");
				scanf("%d",&key);

				if(sequential_search(str,length,key) == -1){
					printf("Khong tim thay");
				}
				else{
					printf("Key tai vi tri: %d",sequential_search(str,length,key));
				}
				break;
				
			case 2:
				printf("Enter the key: ");
				scanf("%d",&key);

				selection_sort(str,length);

				printf("Chuoi sai khi sap xep:");
				for(i = 0; i < length; i++){
					printf("%d",str[i]);
				}
				if(binary_search(str,length,key) == -1){
					printf("Khong tim thay");
				}
				else{
					printf("Key tai vi tri: %d", binary_search(str,length,key));
				}
				break;

			case 3:
			    return 0;
		}
	}while(choose!=0);

	return 0;
}