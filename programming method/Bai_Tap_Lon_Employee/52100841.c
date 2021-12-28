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

struct Project{
    int ID_pro;
    char namePro[70];
    int week;
};
typedef struct Project PJ;

void fileWrong(char *fileloi){
    FILE *check;
    check = fopen(fileloi,"w");

    if(check == NULL){
        exit(-1);
    }

    fprintf(check,"%s", "wrong syntax");
    fclose(check);
}

void InProject(PJ pj){
    printf("%d,%s,%d\n",pj.ID_pro,pj.namePro,pj.week);
}

void InEmployee(NV nv){
    printf("%d,%s,%s,%s,%s,%d,%s",nv.ID,nv.firstName,nv.lastName,nv.gender,nv.dateOfBirth,nv.department,nv.country);
}

void InProgress(PG pg){
    printf("%d,%d,%.2f\n",pg.ID_NV,pg.ID_project,pg.progress);
}

void InListEmployee(NV nv[],int n){
    int i;
    for(i = 0; i < n; i++){
        InEmployee(nv[i]);
    }
}

void InlistProgress(PG pg[], int n){
    int i;
    for(i = 0; i < n; i++){
        InProgress(pg[i]);
    }
}

void InlistProject(PJ pj[], int n){
    int i;
    for(i = 0; i < n; i++){
        InProject(pj[i]);
    }
}

void docfile1Project(char *input, PJ DS[]){
    FILE *fileProject;
    fileProject = fopen(input,"r");
    int i = 0;

    if(fileProject == NULL ){
        printf("\nerror\n");
        exit(-1);
    }

    char line[10000];
    int cot = 0, hang = 0;

    while(fgets(line,10000,fileProject) != NULL){
        cot = 0;
        hang++;

        if(hang == 1){
            continue;
        }

        char *value = strtok(line,",");

        while(value){
                if (cot == 0) {
                    DS[i].ID_pro = atoi(value);
                    value = strtok(NULL, ",");
                    cot++;
                }
                
                if (cot == 1) {
                    strcpy(DS[i].namePro,value);
                    value = strtok(NULL, ",");
                    cot++;
                }
  
                
                if (cot == 2) {
                    DS[i].week = atoi(value);
                    value = strtok(NULL, ",");
                    cot++;
                }

        }
        i++;
    }
    fclose(fileProject);

}

void docFile1Progress(char *input, PG DS[]){
    FILE *fileProgress;
    fileProgress = fopen(input,"r");
    int i = 0;

    if(fileProgress == NULL ){
        printf("\nerror\n");
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
        printf("\nerror\n");
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

    int i, count = 0;
    for(i = 0; i < 201; i++){
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
            InEmployee(nv[i]);
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
    for(i = 0; i < 600; i++){
        if(pg[i].progress == n){
            InProgress(pg[i]);
            fprintf(Fout,"%d,%d,%.2f\n",pg[i].ID_NV,pg[i].ID_project,pg[i].progress);
        }
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
    for(i = 0; i < 201; i++){
        if(strcmp(country,nv[i].country) == 0){
            InEmployee(nv[i]);
            fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[i].ID,nv[i].firstName,nv[i].lastName,nv[i].gender,nv[i].dateOfBirth,nv[i].department,nv[i].country);

        }
    }

    
    fclose(Fout);
}

void sortAscending(char *output, char *fileloi, NV nv[]){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    
    if(Fout == NULL ){
        fileWrong(fileloi);
        exit(-1);
    }

    int i,j;
    NV temp;

    for(i = 0; i < 200-1; i++){
        for(j = i+1; j < 200; j++){
            if( strcmp(nv[j].lastName,nv[i].lastName) < 0){
                temp = nv[i];
                nv[i] = nv[j];
                nv[j] = temp;
            }else if(strcmp(nv[j].lastName,nv[i].lastName) == 0){
                if( strcmp(nv[j].firstName,nv[i].firstName) < 0){
                    temp = nv[i];
                    nv[i] = nv[j];
                    nv[j] = temp;
                }
                
            }
        }
    }

    InListEmployee(nv,200);
    int l;
    for(l = 0; l < 200; l++){
        fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[l].ID,nv[l].firstName,nv[l].lastName,nv[l].gender,nv[l].dateOfBirth,nv[l].department,nv[l].country);

    }

    
    fclose(Fout);
}

void sortDescending(char *output, char *fileloi, NV nv[]){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    
    if(Fout == NULL || fileloi == NULL){
        fileWrong(fileloi);
        exit(-1);
    }
    int i,j;
    NV temp;
    for(i = 0; i < 200-1; i++){
        for(j = i+1; j < 200; j++){
            if( strcmp(nv[j].lastName,nv[i].lastName) > 0){
                temp = nv[i];
                nv[i] = nv[j];
                nv[j] = temp;
            }else if(strcmp(nv[j].lastName,nv[i].lastName) == 0){
                if( strcmp(nv[j].firstName,nv[i].firstName) > 0){
                    temp = nv[i];
                    nv[i] = nv[j];
                    nv[j] = temp;
                }
                
            }
        }
    }

    InListEmployee(nv,200);
    int l;
    for(l = 0; l < 200; l++){
        fprintf(Fout,"%d,%s,%s,%s,%s,%d,%s",nv[l].ID,nv[l].firstName,nv[l].lastName,nv[l].gender,nv[l].dateOfBirth,nv[l].department,nv[l].country);
    }

    
    fclose(Fout);
}

void averageX(char *output, char *fileloi, PG pg[], int x){
    FILE *Fout;
    Fout = fopen(output,"w");
    
    
    if(Fout == NULL || fileloi == NULL){
        fileWrong(fileloi);
        exit(-1);
    }

    int i;
    int count = 0;
    float sum = 0.0;

    for(i = 0; i < 601; i++){
        if(x == pg[i].ID_project){
            sum += pg[i].progress;
            count++;
        }
    }

    float result;
    if(count == 0){
        result = 0;
    }else{
        result = (float)sum/count;
    }

    printf("%.3f",result);
    fprintf(Fout,"%.3f",result);
    
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

void upToLower(char str[]){
    int n = strlen(str);
    if(str[0] >= 97 && str[0] <= 122){
        str[0] -= 32;
    }
}

void deleteNewLine(char x[]){
	size_t len = strlen(x);
	if(x[len-1]=='\n'){
		x[len-1]='\0';
	}
}

int main(){
    char *inputEmployee = "Employee.csv";
    char *inputProgress = "Progress.csv";
    char *inputProject = "Project.csv";
    char *output = "result.csv";
    char *fileLoi = "check.txt";

    // kiểm tra từ khóa
    char count[] = "count ", list[] = "list", report[] = "report", average[] = "average";
    char sort[] = "sort", country[] = "country";

    // kiểm tra lỗi
    char space[] = "  ", Female[] = "Female", Male[] = "Male", asc[] = "asc", desc[] = "desc";

    
    char cauLenh[30];
    char *token;

    fgets(cauLenh,30,stdin);
    
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
            printf("wrong syntax");
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,list) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            upToLower(token);

            NV nv[200];
            docFile1NV(inputEmployee,nv);
            listGender(output,fileLoi,nv,token);
        }else{
            printf("wrong syntax");
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,report) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            float n = atof(token);
            
            if(n <= 0 || n > 1){
                printf("wrong syntax");
                fileWrong(fileLoi);
            }else{
                PG duAn[600];
                docFile1Progress(inputProgress,duAn);
                reportN(output,fileLoi,duAn,n);  
            }
        }else{
            printf("wrong syntax");
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,average) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");
            float x = atof(token);

            if(x == 0){
                printf("wrong syntax");
                fileWrong(fileLoi);
            }else{
                PG duAn[600];
                docFile1Progress(inputProgress,duAn);
                averageX(output,fileLoi,duAn,x);
            }
        }else{
            printf("wrong syntax");
            fileWrong(fileLoi);
        }
    }else if(strstr(cauLenh,sort) != NULL){
        deleteNewLine(cauLenh);
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL," ");

            if(strcmp(token,asc) == 0){
                NV nv[200];
                docFile1NV(inputEmployee,nv);
                sortAscending(output,fileLoi,nv);

            }else if(strcmp(token,desc) == 0){
                NV nv[200];
                docFile1NV(inputEmployee,nv);
                sortDescending(output,fileLoi,nv);
        
            }else{
                printf("wrong syntax");
                fileWrong(fileLoi);
            }
        }else{
            printf("wrong syntax");
            fileWrong(fileLoi);
        }

    }else if(strstr(cauLenh,country) != NULL){
        if(countSpace(cauLenh) == 1){
            token = strtok(cauLenh," ");
            token = strtok(NULL,"");

            // DEBUG ở chỗ count

            NV nv[200];
            docFile1NV(inputEmployee,nv);
            countryName(output,fileLoi,nv,token);
  
        }else{
            printf("wrong syntax");
            fileWrong(fileLoi);
        }
    }else{
        printf("wrong syntax");
        fileWrong(fileLoi);
    }


    // kiem tra file employee
    /*
    NV nv[200];
    docFile1NV(inputEmployee,nv);
    InListEmployee(nv,200);
    */

    // kiem tra find progress
    /*
    PG duAn[600];
    docFile1Progress(inputProgress,duAn);
    InlistProgress(duAn,600);
    */
    
    // kiem tra file project
   /*
   PJ proj[6];
   docfile1Project(inputProject,proj);
   InlistProject(proj,6);
   */
   
   // kiem tra  count department
   /*
    NV nv[600];
    docFile1NV(inputEmployee,nv);
    countDepartment(output,fileLoi,nv,12549);
    */

   // kiem tra list gender
   /*
   NV nv[600];
   docFile1NV(inputEmployee,nv);
   listGender(output,fileLoi,nv,"Male");
   */

    // kiem tra list ma du an progress
    /*
    PG duAn[600];
    docFile1Progress(inputProgress,duAn);
    reportN(output,fileLoi,duAn,0.9);
    */

   // kiem tra list country
   /*
   char country[20];
   fgets(country,20,stdin);
NV nv[200];
docFile1NV(inputEmployee,nv);
countryName(output,fileLoi,nv,country);
    */

    /*
    NV nv[200];
    docFile1NV(inputEmployee,nv);
    sortAscending(output,fileLoi,nv);
    */

   // kiem tra average X
    
    /*
    PG duAn[600];
    docFile1Progress(inputProgress,duAn);
    InlistProgress(duAn,600);
    averageX(output,fileLoi,duAn,1);
    */
    

    
    return 0;
}