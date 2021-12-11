#include<stdio.h>
#include<string.h>
#include<stdbool.h>

void CheckWord(char str[], char s[]){
    int i, j;
    int  length1 = strlen(str);
    int length2 = strlen(s);

    if(length1 >= length2) {
		for(i=0;i<=length1;i++) {
			bool check = true;
			for(j=0;j<length2;j++) {
				if(str[i+j] != s[j]) {
					check = false;
					break;
				}
			}
			if(check) {
				printf("\nVi tri tim thay = %d", i);
			}
		}
	} else {
		
		printf("\nChuoi nhap vao ko hop le!!!");
	}

}

int main(){
    char str[100];
    char s[100];
    printf("nhap vao chuoi :  ");
    fgets(str,99,stdin);


    printf("\n nhap vao ki tu : ");
    scanf("%s",s);

    CheckWord(str,s);

    return  0;
}