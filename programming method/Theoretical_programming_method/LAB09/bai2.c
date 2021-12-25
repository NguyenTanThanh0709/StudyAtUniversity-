#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int coutdigit(char str[]){
	int count = 0;
	int i = 0;
	int j;
	for(j = 0; j < strlen(str); j++){
		if(str[j] == '\n'){
			str[j] = '\0';
		}
	}
	while(str[i] != '\0'){
		count++;
		i++;
	}
	return count;
}

void ReadFile(char * intput02, char *output02){
	FILE *Fin, *Fout;
	Fin = fopen(intput02,"r");
	Fout = fopen(output02,"w");
	char str[20];
	

	while(!feof(Fin)){
	fgets(str,19,Fin);

	int count;
	count = coutdigit(str);

	fprintf(Fout,"cout = %d\n", count);

	}
	fclose(Fin);
	fclose(Fout);
}

int main(){

	char * name1 = "input02.txt";
	char * name2 = "output02.txt";

	ReadFile(name1, name2);

	return 0;
}