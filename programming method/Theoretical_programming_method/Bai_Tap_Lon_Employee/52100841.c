#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct Employee{
    int ID;
    char firstName[20];
    char lastName[20];
    char gender[20];
    char dateOfBirth[20];
    int department;
    char country[20];
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

    if(check == NULL){
        exit(-1);
    }

    fprintf(check,"%s", "wrong syntax");
    fclose(check);
}

void docFile1Progress(char *input, PG DS[]){
    FILE *fileProgress;
    fileProgress = fopen(input,"r");
    int i = 0;

    if(fileProgress == NULL ){
        exit(-1);
    }

    char line[10000];
    int cot = 0, hang = 0;

    while(fgets(line,10000,fileProgress) != NULL){
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
}

void docFile1NV(char *input, NV DS[]){
    FILE *fileEmployee;
    fileEmployee = fopen(input,"r");
    int i = 0;

    if(fileEmployee == NULL ){
        exit(-1);
    }

    char line[10000];
    int cot = 0, hang = 0;

    while(fgets(line,10000,fileEmployee) != NULL){
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
}

void countDepartment(char *output, char *fileloi, NV nv[], int depart){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL ){
        fileWrong(fileloi);
        exit(-1);
    }

    int i;
    int count = 0;
    for(i = 0; i < 200; i++){
        if(depart == nv[i].department){
            count++;
        }
    }

    fprintf(Fout,"%d",count);
    fclose(Fout);
}

void listGender(char *output, char *fileloi, NV nv[], char *gender){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL){
        fileWrong(fileloi);
        exit(-1);
    }

    int i;
    for(i = 0; i < 201; i++){
        if(strcmp(gender,nv[i].gender) == 0){
            fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[i].ID,nv[i].firstName,nv[i].lastName,nv[i].gender,nv[i].dateOfBirth,nv[i].department,nv[i].country);
        }
    }

    fclose(Fout);

}

void reportN(char *output, char *fileloi, PG pg[],float n){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL){
        fileWrong(fileloi);
        exit(-1);
    }

    int i;
    int temp[200], j = 0;
    for(i = 0; i < 600; i++){
        if(pg[i].progress == n){
            
            temp[j++] = pg[i].ID_NV;
        }
    }

    int h,k, kiemTra;
    int ketqua[200], l = 0;
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
    for(e = 0; e < l; e++){
        fprintf(Fout,"%d\n",ketqua[e]);
    }

    fclose(Fout);
}

void countryName(char *output, char *fileloi, NV nv[], char *country){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL ){
        fileWrong(fileloi);
        exit(-1);
    }

    int i;
    for(i = 0; i < 200; i++){
        if(strcmp(country,nv[i].country) == 0){
            fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[i].ID,nv[i].firstName,nv[i].lastName,nv[i].gender,nv[i].dateOfBirth,nv[i].department,nv[i].country);
        }
    }

    fclose(Fout);
}

void sortAscending(char *output, char *fileloi, NV nv[], NV nvC[]){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL ){
        fileWrong(fileloi);
        exit(-1);
    }

    int i,j;
    NV temp;

    for(i = 0; i < 200-1; i++){
        strlwr(nv[i].lastName);
        for(j = i+1; j < 200; j++){
            strlwr(nv[j].lastName);
            if( strcmp(nv[j].lastName,nv[i].lastName) < 0){
                temp = nv[i];
                nv[i] = nv[j];
                nv[j] = temp;
            }else if(strcmp(nv[j].lastName,nv[i].lastName) == 0){
                strlwr(nv[j].firstName);
                strlwr(nv[i].firstName);
                if( strcmp(nv[j].firstName,nv[i].firstName) < 0){
                    temp = nv[i];
                    nv[i] = nv[j];
                    nv[j] = temp;
                }
            }
        }
    }

    int l,k;
    for(l = 0; l < 200; l++){
        for(k = 0; k < 200;k++){
            if(nv[l].ID == nvC[k].ID){
                fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nvC[k].ID,nvC[k].firstName,nvC[k].lastName,nvC[k].gender,nvC[k].dateOfBirth,nvC[k].department,nvC[k].country);
                break;
            }
        }
    }

    fclose(Fout);
}

void sortDescending(char *output, char *fileloi, NV nv[], NV nvC[]){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL || fileloi == NULL){
        fileWrong(fileloi);
        exit(-1);
    }

    int i,j;
    NV temp;
    for(i = 0; i < 200-1; i++){
        strlwr(nv[i].lastName);
        for(j = i+1; j < 200; j++){
            strlwr(nv[j].lastName);
            if( strcmp(nv[j].lastName,nv[i].lastName) > 0){
                temp = nv[i];
                nv[i] = nv[j];
                nv[j] = temp;
            }else if(strcmp(nv[j].lastName,nv[i].lastName) == 0){
                strlwr(nv[j].firstName);
                strlwr(nv[i].firstName);
                if( strcmp(nv[j].firstName,nv[i].firstName) < 0){
                    temp = nv[i];
                    nv[i] = nv[j];
                    nv[j] = temp;
                }
        
            }
        }
    }

    int l,k;
    for(l = 0; l < 200; l++){
        for(k = 0; k < 200;k++){
            if(nv[l].ID == nvC[k].ID){
                fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nvC[k].ID,nvC[k].firstName,nvC[k].lastName,nvC[k].gender,nvC[k].dateOfBirth,nvC[k].department,nvC[k].country);
                break;
            }
        }
    }

    fclose(Fout);
}

void averageX(char *output, char *fileloi, PG pg[], int x){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    if(Fout == NULL){
        fileWrong(fileloi);
        exit(-1);
    }

    int i;
    int count = 0;
    float sum = 0.0;

    for(i = 0; i < 600; i++){
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
    char cauLenh[30];
    char *token;

    fgets(cauLenh,30,stdin);
    strlwr(cauLenh);
    
    if(strstr(cauLenh,count) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            int department = atoi(token);

            NV nv[200];
            docFile1NV(inputEmployee,nv);
            countDepartment(output,fileLoi,nv,department);
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,list) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){

            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            strlwr(token);
            upToLower(token);

            if(strcmp(Female,token) == 0 || strcmp(Male,token) == 0){
                NV nv[200];
                docFile1NV(inputEmployee,nv);
                listGender(output,fileLoi,nv,token);
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
                    PG duAn[600];
                    docFile1Progress(inputProgress,duAn);
                    reportN(output,fileLoi,duAn,n);  
                }
            }else{
                float n = atof(token);
                PG duAn[600];
                docFile1Progress(inputProgress,duAn);
                reportN(output,fileLoi,duAn,n);  
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

            PG duAn[600];
            docFile1Progress(inputProgress,duAn);
            averageX(output,fileLoi,duAn,x);
        }else{
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,sort) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");

            if(strcmp(token,asc) == 0){
                NV nv[200];
                NV nvC[200];
                docFile1NV(inputEmployee,nv);
                docFile1NV(inputEmployee,nvC);
                sortAscending(output,fileLoi,nv,nvC);

            }else if(strcmp(token,desc) == 0){
                NV nv[200];
                NV nvChinh[200];
                docFile1NV(inputEmployee,nv);
                docFile1NV(inputEmployee,nvChinh);
                sortDescending(output, fileLoi, nv, nvChinh);
                
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
            strlwr(token);
            upToLower(token);
            NV nv[200];
            docFile1NV(inputEmployee,nv);
            countryName(output,fileLoi,nv,token);
        }else{
            fileWrong(fileLoi);
        }
    }else{
        fileWrong(fileLoi);
    }

    return 0;
}