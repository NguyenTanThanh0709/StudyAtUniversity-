#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>

typedef struct{
	char ID[10];
	char fn[20];
	char ln[20];
	char gender[10];
	char DoB[20];
	char Dep[10];
	char Country[20];
}EPL;

typedef struct{
	char emp[10];
	char projectid[10];
	char progressid[10];
}PRG;

void countdep(EPL a[],char *dep){
	int i;
	int count=0;
	char file[1024];
	int countrow=0;
	FILE *fin=fopen("Employee.csv","r");
	while (fgets(file,1024,fin)){
		countrow++;
	}
	FILE *fout=fopen("result.csv","w");
	for (i=0;i<countrow;i++){	
		if (strcmp(a[i].Dep,dep)==0){
			count++;
		}
	}
	fprintf(fout,"%d",count);
	fclose(fin);
	fclose(fout);
	
}

void listmale(EPL a[],char *dep){
	int i;
	char file[1024];
	int countrow=0;
	FILE *fin=fopen("Employee.csv","r");
	while (fgets(file,1024,fin)){
		countrow++;
	}
	FILE *fout=fopen("result.csv","w");
	if (dep[0]>='a' && dep[0]<='z'){
		dep[0]=dep[0]-32;
	}
	for (i=0;i<countrow;i++){
		if (strcmp(dep,a[i].gender)==0){
		fprintf(fout,"%s,",a[i].ID);
		fprintf(fout,"%s,",a[i].fn);
		fprintf(fout,"%s,",a[i].ln);
		fprintf(fout,"%s,",a[i].gender);
		fprintf(fout,"%s,",a[i].DoB);
		fprintf(fout,"%s,",a[i].Dep);
		fprintf(fout,"%s\n",a[i].Country);	
		}	
	}
	fclose(fin);
	fclose(fout);
}

void listfemale(EPL a[],char *dep){
	int i;
	char file[512];
	int countrow=0;
	FILE *fin=fopen("Employee.csv","r");
	while (fgets(file,1024,fin)){
		countrow++;
	}
	FILE *fout=fopen("result.csv","w");
	if (dep[0]>='a' && dep[0]<='z'){
		dep[0]=dep[0]-32;
	}
	for (i=0;i<countrow;i++){
		if (strcmp(dep,a[i].gender)==0){
		fprintf(fout,"%s,",a[i].ID);
		fprintf(fout,"%s,",a[i].fn);
		fprintf(fout,"%s,",a[i].ln);
		fprintf(fout,"%s,",a[i].gender);
		fprintf(fout,"%s,",a[i].DoB);
		fprintf(fout,"%s,",a[i].Dep);
		fprintf(fout,"%s\n",a[i].Country);	
		}	
	}
	fclose(fin);
	fclose(fout);
}

void report(PRG b[],char *dep){
	int i,j;
	char file[512];
	int countrow1=0;
	FILE *fin=fopen("Progress.csv","r");
	while (fgets(file,1024,fin)){
		countrow1++;
	}
	FILE *fout=fopen("result.csv","w");
	for (i=0;i<countrow1;i++){
		if ((atof(b[i].progressid)== atof(dep))){
			int k=0;
			for (j=0;j<i;j++){
				if (strcmp(b[i].emp,b[j].emp)==0 && atof(dep)==atof(b[j].progressid)){
					k++;
				}
			}
			if (k==0){
				fprintf(fout,"%s\n",b[i].emp);
			}
		}
	}
	fclose(fin);
	fclose(fout);
}

void sortasc(EPL a[],char *dep){ 
	int i,j;
	EPL temp;
	char file[512];
	int countrow=0;
	FILE *fin=fopen("Employee.csv","r");
	while (fgets(file,1024,fin)){
		countrow++;
	}
	printf("%d",countrow);
	FILE *fout=fopen("result.csv","w");
	for (i=0;i<countrow-1;i++){ 
		for (j=i+1;j<countrow;j++){
			if (strcmp(a[i].ln,a[j].ln)>0){
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			else if  (strcmp(a[i].ln,a[j].ln)==0){
				if (strcmp(a[i].fn,a[j].fn)>0){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	for (i=1;i<countrow;i++){
		fprintf(fout,"%s,",a[i].ID);
		fprintf(fout,"%s,",a[i].fn);
		fprintf(fout,"%s,",a[i].ln);
		fprintf(fout,"%s,",a[i].gender);
		fprintf(fout,"%s,",a[i].DoB);
		fprintf(fout,"%s,",a[i].Dep);
		fprintf(fout,"%s",a[i].Country);
	}
	fclose(fin);
	fclose(fout);
}

void sortdesc(EPL a[],char *dep){ 
	int i,j;
	EPL temp;
	char file[1024];
	int countrow=0;
	FILE *fin=fopen("Employee.csv","r");
	while (fgets(file,1024,fin)){
		countrow++;
	}
	FILE *fout=fopen("result.csv","w");
	for (i=0;i<countrow-1;i++){ 
		for (j=0;j<countrow-i-1;j++){
			if (strcmp(a[j].ln,a[j+1].ln)<0){
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
			else if  (strcmp(a[j].ln,a[j+1].ln)==0){
				if (strcmp(a[j].fn,a[j+1].fn)>0){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	for (i=0;i<countrow-1;i++){
		fprintf(fout,"%s,",a[i].ID);
		fprintf(fout,"%s,",a[i].fn);
		fprintf(fout,"%s,",a[i].ln);
		fprintf(fout,"%s,",a[i].gender);
		fprintf(fout,"%s,",a[i].DoB);
		fprintf(fout,"%s,",a[i].Dep);
		fprintf(fout,"%s",a[i].Country);
	}
	fclose(fin);
	fclose(fout);
}

void average(PRG b[],char *dep){
	int i;
	int count=0;
	float tb=0.0,s=0.0;
	char file[512];
	int countrow1=0;
	FILE *fin=fopen("Progress.csv","r");
	while (fgets(file,100,fin)){
		countrow1++;
	}
	FILE *fout=fopen("result.csv","w");
	for (i=0;i<countrow1;i++){
		if (strcmp(b[i].projectid,dep)==0 ){
			s=s+atof(b[i].progressid);
			count++;
		}	
	}
		if (count==0){
			s=0;
		}
		
		else {
			tb=s/count;
		}
		fprintf(fout,"%.3f\n",tb);
	fclose(fin);
	fclose(fout);
}

void country(EPL a[],char *dep){
	int i;
	char file[1024];
	int countrow=0;
	FILE *fin=fopen("Employee.csv","r");
	while (fgets(file,1024,fin)){
		countrow++;
	}
	FILE *fout=fopen("result.csv","w");
	if (dep[0]>='a' && dep[0]<='z'){
		dep[0]=dep[0]-32;
	}
	for (i=0;i<countrow;i++){
		a[i].Country[strlen	(a[i].Country)-1]='\0';
		if (strcmp(dep,a[i].Country)==0){
		fprintf(fout,"%s,",a[i].ID);
		fprintf(fout,"%s,",a[i].fn);
		fprintf(fout,"%s,",a[i].ln);
		fprintf(fout,"%s,",a[i].gender);
		fprintf(fout,"%s,",a[i].DoB);
		fprintf(fout,"%s,",a[i].Dep);
		fprintf(fout,"%s\n",a[i].Country);
		}
	}
	fclose(fin);
	fclose(fout);
}

void deleten(char a[]){
	int i,d,len=strlen(a);
	for (i=0;i<len;i++){
		if (a[i]=='\n' )
		{
			for (d=i;d<len;d++)
			{	
				a[d]=a[d+1];
			}
		}
		a[len-1]='\0';
	}
}

int main(){
	FILE *fin=fopen("Employee.csv","r");
	FILE *fin1=fopen("Progress.csv","r");
	EPL a[3000];
	PRG b[4000];
	char *e;
	char *dep;
	

//	if (!fin){
//		printf("Error file!");
//		return 0;
//	}
	
	char file[512];
	int countrow=0;
	int countfield=0;
	int i=0;

	while (fgets(file,1024,fin)){
		countfield=0;
		countrow++;
		if (countrow==1){
			continue;
		}
		char *field=strtok(file,",");
		while(field){
			if (countfield==0){
				strcpy(a[i].ID,field);
			}
			if (countfield==1){
				strcpy(a[i].fn,field);
			}
			if (countfield==2){
				strcpy(a[i].ln,field);
			}
			if (countfield==3){
				strcpy(a[i].gender,field);
			}
			if (countfield==4){
				strcpy(a[i].DoB,field);
			}
			if (countfield==5){
				strcpy(a[i].Dep,field);
			}
			if (countfield==6){
				strcpy(a[i].Country,field);
				deleten(a[i].Country); 
			}
			field= strtok(NULL,",");
			countfield++;
			}
		i++; 
	}
	
	fclose(fin);
	
	char file1[1024];
	int countrow1=0;
	int countfield1=0;
	i=0;
	while (fgets(file1,1024,fin1)){
		countfield1=0;
		countrow1++;
		if (countrow1==1){
			continue;
		}
		char *field1=strtok(file1,",");
		while(field1){
			if (countfield1==0){
				strcpy(b[i].emp,field1);
			}
			if (countfield1==1){
				strcpy(b[i].projectid,field1);
			}
			if (countfield1==2){
				strcpy(b[i].progressid,field1);
			}
			field1= strtok(NULL,",");
			countfield1++;
		}
		i++;
	}
	
	fclose(fin1);
	
	char c[29];    
    fgets (c, sizeof(c), stdin);
	int space=0;
	
	for (i=0;i<strlen(c);i++){
		if (c[i]==' '){ 
			space++;
		}
		if (c[i]>='A' && c[i]<='Z'){
			c[i]+=32;
		}
	}
	
	if (space==1  && c[0]!=' '){
		e=strtok(c," ");
    	dep=strtok(NULL," ");
		deleten(dep);
		if(strcmp(e,"count")==0){
			float n=atof(dep);
			if (n<0){
				FILE *fout1=fopen("check.txt","w");
				fprintf(fout1,"wrong syntax");
				fclose(fout1);
			}
			else {
			countdep(a,dep);		
		}
		}
	
		if(strcmp(e,"list")==0){ 
			if(strcmp(dep,"male")==0){
				listmale(a,dep);
			}
			else if (strcmp(dep,"female")==0){
				listfemale(a,dep);
			}
			else {
				FILE *fout1=fopen("check.txt","w");
				fprintf(fout1,"wrong syntax");
				fclose(fout1);
			}	
		}
		
		if (strcmp(e,"report")==0){
			for (i=0;i<=strlen(dep);i++){
				if (dep[i] >= 'a'  && dep[i] <= 'z' || dep[i] >= 'A' && dep[i] <= 'Z' ) {
					FILE *fout1=fopen("check.txt","w");
					fprintf(fout1,"wrong syntax");
					fclose(fout1);
				}
			}	
				float n=atof(dep);
				if (n>=0 && n<=1 ){
					report(b,dep);
				}
				
			else {
				FILE *fout1=fopen("check.txt","w");
				fprintf(fout1,"wrong syntax");
				fclose(fout1);
			}
		}		
	
		if (strcmp(e,"average")==0){
			float n=atof(dep);
			if (n<0){
				FILE *fout1=fopen("check.txt","w");
				fprintf(fout1,"wrong syntax");
				fclose(fout1);
			}
			else {
			average(b,dep);		
		}
		}
	
		if (strcmp(e,"sort")==0){
			if (strcmp(dep,"asc")==0){
				sortasc(a,dep);
			}
			else if(strcmp(dep,"desc")==0){
				sortdesc(a,dep);
			}
			else {
				FILE *fout1=fopen("check.txt","w");
				fprintf(fout1,"wrong syntax");
				fclose(fout1);
			}
		}

		if (strcmp(e,"country")==0){	
			country(a,dep);	
		}

	}
	else { 
		FILE *fout1=fopen("check.txt","w");
		fprintf(fout1,"wrong syntax");
		fclose(fout1);
	}

	return 0;
}
