#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/ipc.h>
#include<sys/types.h>
#include <sys/msg.h>
#include <string.h>
#include <semaphore.h> 
#include <unistd.h> 
#define BUFFER_SIZE 100
// Cau truc data de luu du lieu lay tu file
typedef struct data {
	int value[BUFFER_SIZE]; //cac gia tri cua file
	int length;	// do lon cua mang value
	char filename[BUFFER_SIZE]; // Ten file truyen vao
	long mesg_type; 	//loai message
} data;

//Cau truc mesg_buffer dung thuc hien gui tin nhan den chu dau gia cho option 2
struct mesg_buffer {
	long mesg_type; 	//loai message
	char won[BUFFER_SIZE];	//Luu tru ten cua nguoi thang cuoc dau gia
	int money;	//Luu so tien dau gia cuoi cung
} message;

char name[]="NULL"; //Bien dung chung, de dat ten cua nguoi dau gia qua tung giai doan
int result=0; //Bien dung chung, de dat so tien dau gia qua tung giai doan
sem_t sem; //Bien dung chung, semaphore dung de quan ly truy cap bien dung chung
int flag=0; //Bien dung chung, dung de phat tin hieu khi co 1 luong chay het du lieu
//Ham xuly dung de nap cac du lieu o file vao bien thuoc cau truc data
void xuly(void Dulieu)
{
	data d=(data)Dulieu;
	FILE *fp;
	fp=fopen(d->filename,"r");
	if(fp==NULL)
	{
		printf("Khong mo duoc file\n");
		exit(1);
	}
	int i=0;
	while(!feof(fp))
	{
		fscanf(fp,"%d",&d->value[i]);
		i++;
	}
	d->length=i;
	fclose(fp);
	return NULL;
	
}
//Ham daugia dung de thiet lap dau gia giua cac tieu trinh, moi tieu trinh se chi den 1 file du lieu.
void daugia(void Dulieu)
{
	
	
	

}
int main(int argc, char *argv[])
{


    int i,j;
	pthread_t thread[2];
	data d[2];
	//Khoi tao cac bien dung chung
	sem_init(&sem,0,1);
	//Khoi tao cac thread
	for(i=0;i<2;i++)
	{
		pthread_create(&thread[i],NULL,xuly,&d[i]);
	}
	//Cho cac thread chay
	for(i=0;i<2;i++)
	{
		pthread_join(thread[i],NULL);
	}
	//Khoi tao cac thread
	for(i=0;i<2;i++)
	{
		pthread_create(&thread[i],NULL,daugia,&d[i]);
	}
	//Cho cac thread chay
	for(i=0;i<2;i++)
	{
		pthread_join(thread[i],NULL);
	}



	// Tao semaphore
	sem_init(&sem,0,1);
	//Tao message queue
	int msgid;
	msgid=msgget(ftok(".",'a'),IPC_CREAT|0666);
	if(msgid==-1)
	{
		printf("Khong tao duoc message queue\n");
		exit(1);
	}
	//Tao cac thread dung de daugia
	pthread_t thread_daugia[d->length];
	for(i=0;i<d->length;i++)
	{
		d[i].mesg_type=i;
		pthread_create(&thread_daugia[i],NULL,daugia,d[i]);
	}







	
	return 0;
}

	// Doi so argv la ten cua cac file de truyen du lieu


	//Dua du lieu vao de xu ly
	
	//xuat thong tin sau khi file duoc doc vao du lieu	
	
	//Option1: Tao ra message de gui thong tin vua xy ly duoc sang cho ToChuc
	
	
	//Option 2: Thuc hien dau gia giua cac tieu trinh, moi tieu trinh doc 1 file
	
	//Gui ket qua ve chu dau gia	

	// int i,j;
	// pthread_t thread[2];
	// data d[2];
	// //Khoi tao cac bien dung chung
	// sem_init(&sem,0,1);
	// //Khoi tao cac thread
	// for(i=0;i<2;i++)
	// {
	// 	pthread_create(&thread[i],NULL,xuly,&d[i]);
	// }
	// //Cho cac thread chay
	// for(i=0;i<2;i++)
	// {
	// 	pthread_join(thread[i],NULL);
	// }
	// //Khoi tao cac thread
	// for(i=0;i<2;i++)
	// {
	// 	pthread_create(&thread[i],NULL,daugia,&d[i]);
	// }
	// //Cho cac thread chay
	// for(i=0;i<2;i++)
	// {
	// 	pthread_join(thread[i],NULL);
	// }



		// //Tao semaphore
	// sem_init(&sem,0,1);
	// //Tao message queue
	// int msgid;
	// msgid=msgget(ftok(".",'a'),IPC_CREAT|0666);
	// if(msgid==-1)
	// {
	// 	printf("Khong tao duoc message queue\n");
	// 	exit(1);
	// }
	// //Tao cac thread dung de daugia
	// pthread_t thread_daugia[d->length];
	// for(i=0;i<d->length;i++)
	// {
	// 	d[i].mesg_type=i;
	// 	pthread_create(&thread_daugia[i],NULL,daugia,d[i]);
	// }

	// //Tinh ket qua dau gia