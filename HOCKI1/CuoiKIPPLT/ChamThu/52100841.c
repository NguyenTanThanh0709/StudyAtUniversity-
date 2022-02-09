#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define SOLUONG 4000

struct Employee{
    int ID;
    char firstName[50];
    char lastName[50];
    char gender[50];
    char dateOfBirth[50];
    int department;
    char country[50];
};
typedef struct Employee NV;

struct Progress{
    int ID_NV;
    int ID_project;
    float progress;
};
typedef struct Progress PG;

void fileWrong(char *fileloi){
    FILE *check;
    check = fopen(fileloi,"w");

    fprintf(check,"%s", "wrong syntax");
    fclose(check);
}

int docFile1Progress(char *input, PG DS[]){
    FILE *fileProgress;
    fileProgress = fopen(input,"r");
    int i = 0;

    char line[1000];
    int cot = 0, hang = 0;

    while(fgets(line,1000,fileProgress) != NULL){
        cot = 0;
        hang++;

        if(hang == 1){
            continue;
        }

        char *value = strtok(line,",");

        while(value){
                if (cot == 0) {
                    DS[i].ID_NV = atoi(value);
                    value = strtok(NULL, ",");
                    cot++;
                }
                
                if (cot == 1) {
                    DS[i].ID_project = atoi(value);
                    value = strtok(NULL, ",");
                    cot++;
                }
  
                if (cot == 2) {
                    DS[i].progress = atof(value);
                    value = strtok(NULL, ",");
                    cot++;
                }

        }
        i++;
    }
    
    fclose(fileProgress);
    return hang-1;
}

int docFile1NV(char *input, NV DS[]){
    FILE *fileEmployee;
    fileEmployee = fopen(input,"r");
    int i = 0;

    char line[1000];
    int cot = 0, hang = 0;

    while(fgets(line,1000,fileEmployee) != NULL){
        cot = 0;
        hang++;

        if(hang == 1){
            continue;
        }

        char *value = strtok(line,",");

        while(value){
                if (cot == 0) {
                    DS[i].ID = atoi(value);
                    value = strtok(NULL, ",");
                    cot++;
                }
                
                if (cot == 1) {
                    strcpy(DS[i].firstName,value);
                    value = strtok(NULL, ",");
                    cot++;
                }
  
                if (cot == 2) {
                    strcpy(DS[i].lastName,value);
                    value = strtok(NULL, ",");
                    cot++;
                }

                if (cot == 3) {
                    strcpy(DS[i].gender,value);
                    value = strtok(NULL, ",");
                    cot++;
                }

                if (cot == 4) {
                    strcpy(DS[i].dateOfBirth,value);
                    value = strtok(NULL, ",");
                    cot++;
                }

                if (cot == 5) {
                    DS[i].department = atoi(value);
                    value = strtok(NULL, ",");
                    cot++;
                }

                if (cot == 6) {
                    strcpy(DS[i].country,value);
                    value = strtok(NULL, ",");
                    cot++;
                }
        }
        i++;
    }
    

    fclose(fileEmployee);
    
    return hang-1;
}

void my_strlwr(char x[]){
    int i;
    int n = strlen(x);
	for(i=0; i<n; i++){
		if(x[i]>=65 && x[i]<=90){
			x[i] = x[i]+32;
		}
	}
}

void countDepartment(char *output, NV nv[], int depart, int SLDEP){
    FILE *Fout;
    Fout = fopen(output,"w");

    int i;
    int count = 0;
    for(i = 0; i < SLDEP; i++){
        if(depart == nv[i].department){
            count++;
        }
    }

    fprintf(Fout,"%d",count);
    fclose(Fout);
}

void listGender(char *output, NV nv[], char *gender){
    FILE *Fout;
    Fout = fopen(output,"w");

    int i;
    for(i = 0; i <SOLUONG; i++){
        if(strcmp(gender,nv[i].gender) == 0){
            fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[i].ID,nv[i].firstName,nv[i].lastName,nv[i].gender,nv[i].dateOfBirth,nv[i].department,nv[i].country);
        }
    }

    fclose(Fout);

}

void reportN(char *output, PG pg[],float n, int SL){
    FILE *Fout;
    Fout = fopen(output,"w");
   
    int i;
    int temp[SL], j = 0;
    int CHECK = 0;
    for(i = 0; i < SL; i++){
        if(pg[i].progress == n){
            CHECK = 1;
            temp[j++] = pg[i].ID_NV;
        }
    }

    int h,k, kiemTra;
    int ketqua[SL], l = 0;
    ketqua[l++] = temp[0];

    for(h = 1; h < j; h++){
        kiemTra = 1;
        for(k = h-1; k >= 0; k--){
            if(temp[k] == temp[h]){
                kiemTra = 0;
                break;
            }
        }
        if(kiemTra == 1){
            ketqua[l++] = temp[h];
        }
    }

    int e;
    if(CHECK == 1){
        for(e = 0; e < l; e++){
            fprintf(Fout,"%d\n",ketqua[e]);
        }
    }

    fclose(Fout);
}

void countryName(char *output, NV nv[], char *country, int soLuongCountry){
    FILE *Fout;
    Fout = fopen(output,"w");
   
    int i;
    for(i = 0; i < soLuongCountry; i++){
        if(strcmp(country,nv[i].country) == 0){
            fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[i].ID,nv[i].firstName,nv[i].lastName,nv[i].gender,nv[i].dateOfBirth,nv[i].department,nv[i].country);
        }
    }

    fclose(Fout);
}

void sortAscending(char *output, NV nv[], NV nvC[], int soLuongNV){
    FILE *Fout;
    Fout = fopen(output,"w");
  
    int i,j;
    NV temp;
    
    for(i = 0; i < soLuongNV-1; i++){
        for(j = 0; j < soLuongNV-i-1; j++){
            my_strlwr(nv[j].lastName);
            my_strlwr(nv[j+1].lastName);
            if( strcmp(nv[j+1].lastName,nv[j].lastName) < 0){
                temp = nv[j];
                nv[j] = nv[j+1];
                nv[j+1] = temp;
            }else if(strcmp(nv[j+1].lastName,nv[j].lastName) == 0){
                my_strlwr(nv[j].firstName);
                my_strlwr(nv[j+1].firstName);
                if( strcmp(nv[j+1].firstName,nv[j].firstName) < 0){
                    temp = nv[j];
                    nv[j] = nv[j+1];
                    nv[j+1] = temp;
                }
            }
        }
    }

    int l,k;
    for(l = 0; l < soLuongNV; l++){
        for(k = 0; k < soLuongNV;k++){
            if(nv[l].ID == nvC[k].ID){
                fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nvC[k].ID,nvC[k].firstName,nvC[k].lastName,nvC[k].gender,nvC[k].dateOfBirth,nvC[k].department,nvC[k].country);
                break;
            }
        }
    }

    fclose(Fout);
}

void sortDescending(char *output, NV nv[], NV nvC[], int SLNV){
    FILE *Fout;
    Fout = fopen(output,"w");

    int i,j;
    NV temp;
    for(i = 0; i < SLNV-1; i++){
        
        for(j = 0; j < SLNV-i-1; j++){
            my_strlwr(nv[j].lastName);
            my_strlwr(nv[j+1].lastName);
            if( strcmp(nv[j+1].lastName,nv[j].lastName) > 0){
                temp = nv[j];
                nv[j] = nv[j+1];
                nv[j+1] = temp;
            }else if(strcmp(nv[j+1].lastName,nv[j].lastName) == 0){
                my_strlwr(nv[j].firstName);
                my_strlwr(nv[j+1].firstName);
                if( strcmp(nv[j+1].firstName,nv[j].firstName) < 0){
                    temp = nv[j];
                    nv[j] = nv[j+1];
                    nv[j+1] = temp;
                }
        
            }
        }
    }

    int l,k;
    for(l = 0; l < SLNV; l++){
        for(k = 0; k < SLNV;k++){
            if(nv[l].ID == nvC[k].ID){
                fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nvC[k].ID,nvC[k].firstName,nvC[k].lastName,nvC[k].gender,nvC[k].dateOfBirth,nvC[k].department,nvC[k].country);
                break;
            }
        }
    }

    fclose(Fout);
}

void averageX(char *output, PG pg[], int x, int soLuongPRO){
    FILE *Fout;
    Fout = fopen(output,"w");
   
    int i;
    int count = 0;
    float sum = 0.0;

    for(i = 0; i < soLuongPRO; i++){
        if(x == pg[i].ID_project){
            sum += pg[i].progress;
            count++;
        }
    }

    float result;
    if(count == 0){
        result = 0;
        fprintf(Fout,"%.0f",result);
    }else{
        result = (float)sum/count;
        fprintf(Fout,"%.3f",result);
    }
    
    fclose(Fout);
}

int countSpace(char str[]){
    int count = 0;
    int i, n = strlen(str);
    for(i = 0; i < n; i++){
        if(str[i] == ' '){
            count++;
        }
    }
    return count;
}

void deleteNewLine(char x[]){
	size_t len = strlen(x);
	if(x[len-1]=='\n'){
		x[len-1]='\0';
	}
}

void upToLower(char str[]){
    int n = strlen(str);
    if(str[0] >= 97 && str[0] <= 122){
        str[0] -= 32;
    }
}

int main(){
    char *inputEmployee = "Employee.csv";
    char *inputProgress = "Progress.csv";
    char *output = "result.csv";
    char *fileLoi = "check.txt";

    char count[] = "count ", list[] = "list", report[] = "report", average[] = "average";
    char sort[] = "sort", country[] = "country";
    char Female[] = "Female", Male[] = "Male", asc[] = "asc", desc[] = "desc";
    char cauLenh[30], dauTru[] = "-";
    char *token;
    
    fgets(cauLenh,30,stdin);
    my_strlwr(cauLenh);
    
    if(strstr(cauLenh,count) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");

            if(strstr(token,dauTru) != NULL){
                fileWrong(fileLoi);
                return 0;
            }

            int department = atoi(token);

            NV nv[SOLUONG];
            int SLDEP = docFile1NV(inputEmployee,nv);
            countDepartment(output,nv,department,SLDEP);
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,list) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){

            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            upToLower(token);

            if(strcmp(Female,token) == 0 || strcmp(Male,token) == 0){
                NV nv[SOLUONG];
                docFile1NV(inputEmployee,nv);
                listGender(output,nv,token);
            }else{
                fileWrong(fileLoi);
            }
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,report) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");

            if(strcmp(token,"0") != 0){
                float n = atof(token);
                if(n <= 0 || n > 1){
                    fileWrong(fileLoi);
                }else{
                    PG duAn[SOLUONG];
                    int HIHI = docFile1Progress(inputProgress,duAn);
                    reportN(output,duAn,n,HIHI);  
                }
            }else{
                float n = atof(token);
                PG duAn[SOLUONG];
                int SL = docFile1Progress(inputProgress,duAn);
                reportN(output,duAn,n,SL);  
            }
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,average) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            float x = atof(token);

            PG duAn[SOLUONG];
            int soLuongPRO = docFile1Progress(inputProgress,duAn);
            averageX(output,duAn,x,soLuongPRO);
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,sort) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");

            if(strcmp(token,asc) == 0){
                NV nv[2500];
                NV nvC[2500];
                
                int soLuongNV = docFile1NV(inputEmployee,nv);
                docFile1NV(inputEmployee,nvC);
                sortAscending(output,nv,nvC,soLuongNV);

            }else if(strcmp(token,desc) == 0){
                NV nv[2500];
                NV nvChinh[2500];
                int SLNV = docFile1NV(inputEmployee,nv);
                docFile1NV(inputEmployee,nvChinh);
                sortDescending(output, nv, nvChinh,SLNV);
                
            }else{
                fileWrong(fileLoi);
            }
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,country) != NULL){
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL,"");
            upToLower(token);
            NV nv[SOLUONG];
            int SOLUONGCOUNTRY = docFile1NV(inputEmployee,nv);
            countryName(output,nv,token,SOLUONGCOUNTRY);
        }else{
            fileWrong(fileLoi);
        }
    }else{
        fileWrong(fileLoi);
    }

    return 0;
}