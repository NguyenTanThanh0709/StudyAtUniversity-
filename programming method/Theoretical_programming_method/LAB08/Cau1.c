#include<stdio.h>
#include<string.h>
#include<time.h>

struct Employee{
    int id;
    char name[20];
    char sex[20];
    int year;
    int phoneNumber;
    float salary;
};
typedef struct Employee NV;

void InTieuDe(){
    printf("%-10s %-20s %-10s%-20s %-20s %-20s\n","ID", "Name", "Sex", "year birth", "phone number", "salary");
}

void Enter_one_NV(NV *nv){
    printf("nhap vao id : ");
    scanf("%d",&nv->id);

    printf("ten nhan vien: ");
    fflush(stdin);
    gets(nv->name);

    printf("nhap vao gioi tinh: ");
    fflush(stdin);
    gets(nv->sex);

    printf("nhap vao nam sinh: ");
    scanf("%d", &nv->year);

    printf("phone number : ");
    scanf("%d",&nv->phoneNumber);

    printf("nhap vao luong : ");
    scanf("%f", &nv->salary);

}


void NhapListNV(NV nv[], int n){
    int i;
    for(i = 0; i < n; i++){
        printf("\t\tnhan vien thu %d\n", i+1);
        Enter_one_NV(&nv[i]);
    }
}

void In_1_NV(NV nv){
    printf("%-10d %-20s %-10s%-20d %-20d %-20f\n",nv.id, nv.name, nv.sex, nv.year, nv.phoneNumber, nv.salary);
}

void InlistNV(NV nv[], int n){
    int i;
    for(i = 0; i < n; i++){
        In_1_NV(nv[i]);
    }
}



void findEmployee(NV nv[], int n, int id){
    int i;
    for(i = 0; i < n; i++){
        if(id == nv[i].id){
            In_1_NV(nv[i]);
        }
    }
}



void countSex(NV nv[], int n){
    int count_nam = 0;
    int count_nu = 0;
    int i;
    char nam[] = "nam";
    char nu[] = "nu";
    for(i = 0; i < n; i++){
        if(strcmp(nam,nv[i].sex) == 0){
            count_nam++;
        }
        if(strcmp(nu,nv[i].sex) == 0){
            count_nu++;
        }
    }
    printf("\n nam: %d nguoi\n nu: %d nguoi\n",count_nam, count_nu);
}

void sortArray_birth(NV nv[], int n){
    int i,j;
    NV temp;
    for(i = 0; i < n-1; i++){
        for(j = i+1; j < n; j++){
            if(nv[i].year > nv[j].year){
                temp = nv[i];
                nv[i] = nv[j];
                nv[j] = temp;
            }
        }
    }
}

void sortArray_salary(NV nv[], int n){
    int i,j;
    NV temp;
    for(i = 0; i < n-1; i++){
        for(j = i+1; j < n; j++){
            if(nv[i].salary > nv[j].salary){
                temp = nv[i];
                nv[i] = nv[j];
                nv[j] = temp;
            }
        }
    }
}

void findEmployee_salary(NV nv[], int n){
    int i;
    int j;
    int max = -1;
    for(i = 0; i < n; i++){
        if( max < nv[i].salary){
            max = nv[i].salary;
            j = i;
        }
    }
    In_1_NV(nv[j]);
}

void findYoungest(NV nv[], int n){
    time_t s, val = 1;
    struct tm* current_time;
    
    s = time(NULL);
    
    current_time = localtime(&s);
    int YearLocal = current_time->tm_year + 1900;

    int i;
    int min = 1000000;
    int tuoi;
    int j;
    for(i = 0; i < n; i++){
        tuoi = YearLocal - nv[i].year;
        if(min > tuoi){
            min = tuoi;
            j = i;
        }
    }
    
    In_1_NV(nv[j]);
}

void delete_Employee_ID(NV nv[], int *n, int id){
    int i,j;
    for(i = 0; i < *n; i++){
        if(id == nv[i].id){
            for(j = i; j < *n; j++){
                nv[j] = nv[j+1]; 
            }
            *n = *n -1;
        }
    }
}

int main(){
    NV nv[10];
    int id;
    int n;
    printf("nhap vao so luong nhan vien : ");
    scanf("%d", &n);

    NhapListNV(nv,n);
    InTieuDe();
    InlistNV(nv,n);

    int choice;
    printf("chon cau muon lam :");
    scanf("%d",&choice);

    switch(choice){
        case 1:
            
            printf("\nnhap vao id cua nhan vien can tim: ");
            scanf("%d", &id);
            findEmployee(nv,n,id);
            break;
        case 2:
            countSex(nv,n);
            break;
        case 3:
            sortArray_birth(nv,n);
            InlistNV(nv,n);
            break;
        case 4: 
            sortArray_salary(nv,n);
            InlistNV(nv,n);
            break;
        case 5:
            findEmployee_salary(nv,n);
            break;
        case 6:
            findYoungest(nv,n);
            break;
        case 7:
            printf("nhap vao id nhan vien muon xoa : ");
            scanf("%d", &id);

            delete_Employee_ID(nv,&n,id);
            InlistNV(nv,n);
            break;
    }


    return 0;
}