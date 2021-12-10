#include<stdio.h>
#include<math.h>
#include<string.h>
#include<stdbool.h>
#include<stdlib.h>

float f_truong_hop_2(int d, int s, char *t);
/*
int Fibonaci(int n){
    if(n == 1 || n == 2){
        return 1;
    }
    return Fibonaci(n-1) + Fibonaci(n-2);
}

bool CheckFiBo(int n){
    int i;
    for(i = 0; i <= n; i++){
        if(Fibonaci(i) == n){
            return true;
        }
    }
    return false;
}*/

 int checkfibonacci(int n)
        {
            int a = 0;
            int b = 1;
            if (n==a || n==b) return true;
            int c = a+b;
            while(c<=n)
            {
                if(c == n) return true;
                a = b;
                b = c;
                c = a + b;
            }
            return false;
        }

bool CheckPrime(int n){
    if(n < 2){
        return false;
    }
    if( n == 2){
        return true;
    }
    int i;
    for(i = 2; i < n; i++){
        if(n % i == 0){
            return false;
        }
    }
    return true;
}


float P1(int hp){
    if(CheckPrime(hp)){
        return 1000;
    }else{
        return hp;
    }
}

int  P2(int hp, int s, int d){
    int  P2;
    int temp;
    if(CheckPrime(hp)){
        temp = hp+s;
        P2 = temp % 1000;
        return P2;
    }else{
        temp = hp+d;
        P2 = temp % 100;
        return P2;
    }
}

float f_truong_hop_1(int d, int s, char *t){
    float temp;
    temp = d + s;
    float f1;
    if(checkfibonacci(temp)){
        f1 = f_truong_hop_2(d,s,t);
        return f1;
    }else{
        return 0.0;
    }
}

float f_truong_hop_2(int d, int s, char *t){
    float g_s;
    int n;
    int s_s = s%6;
    if(s_s == 0){
        g_s = s/2.0;
    }else if(s_s == 1){
        g_s = 2*s;
    }else if(s_s == 2){
        g_s = pow(-(s%9),3)/5.0;
    }else if(s_s == 3){
        g_s = -pow((s%30),2)+3.0*s;
    }else if( s_s == 4){
        g_s = -s;
    }else if( s_s == 5){
         n = s%5 +5;
         g_s = n;
    }

    char flood[] = "Flood";
    char storm[] = "Storm";
    char rain[] = "Rain";
    char shower[] = "Shower";
    char drizzle[] = "Drizzle";
    char cloudy[] = "Cloudy";

    float p_t;
    if(strcmp(t,flood) == 0 &&s_s == 5 || strcmp(t,storm) == 0 && s_s == 4 || strcmp(t,rain)==0 && s_s == 0 || strcmp(t,shower) == 0 &&s_s == 1 || strcmp(t,drizzle) == 0 &&s_s == 2 || strcmp(t,cloudy) == 0 &&s_s == 3){
        p_t = 0;
    }
    if(strcmp(t,flood) == 0 &&s_s == 4 || strcmp(t,storm) == 0 && s_s == 0 || strcmp(t,rain)==0 && s_s == 1 || strcmp(t,shower) == 0 &&s_s == 2 || strcmp(t,drizzle) == 0 &&s_s == 3){
        p_t = -5.0/100;
    }

    if(strcmp(t,flood) == 0 &&s_s == 0 || strcmp(t,storm) == 0 && s_s == 1 || strcmp(t,rain)==0 && s_s == 2 || strcmp(t,shower) == 0 &&s_s == 3){
        p_t = -10.0/100;
    }

    if(strcmp(t,flood) == 0 &&s_s == 1 || strcmp(t,storm) == 0 && s_s == 2 || strcmp(t,rain)==0 && s_s == 3){
        p_t = -15.0/100;
    }

    if(strcmp(t,flood) == 0 &&s_s == 2 || strcmp(t,storm) == 0 && s_s == 3){
        p_t = -20.0/100;
    }

    if(strcmp(t,flood) == 0 &&s_s == 3){
        p_t = -25.0/100;
    }

    if(strcmp(t,flood) == 0 && s_s == 5 || strcmp(t,rain)==0 && s_s == 4 || strcmp(t,shower) == 0 &&s_s == 0 || strcmp(t,drizzle) == 0 &&s_s == 1 || strcmp(t,cloudy) == 0 &&s_s == 2){
        p_t = 5.0/100;
    }

    if( strcmp(t,rain)==0 && s_s == 5 || strcmp(t,shower) == 0 &&s_s == 4 || strcmp(t,drizzle) == 0 &&s_s == 0 || strcmp(t,cloudy) == 0 &&s_s == 1){
        p_t = 10.0/100  ;
    }

    if( strcmp(t,shower) == 0 &&s_s == 5 || strcmp(t,drizzle) == 0 &&s_s == 4 || strcmp(t,cloudy) == 0 &&s_s == 0){
        p_t = 15.0/100  ;
    }

    if(strcmp(t,drizzle) == 0 &&s_s == 5 || strcmp(t,cloudy) == 0 &&s_s == 4){
        p_t = 20.0/100  ;
    }

    if( strcmp(t,cloudy) == 0 &&s_s == 5){
        p_t = 25.0/100  ;
    }

    float f;
    f = (40.0-abs(d-500)/20.0 + g_s)*(1.0+p_t);
    return f;
}

float f_truong_hop_3(int *hp, int d, int s, char *t){
    float xac_xuat_ran_can;
    int p1 = P1(*hp);
    int p2 = P2(*hp,s,d);
    xac_xuat_ran_can = (d + p1 + p2)/1000.0;
    float f;
    if(xac_xuat_ran_can > 0.8){
        return -10000;
    }

    if(xac_xuat_ran_can <= 0.8){
        if(xac_xuat_ran_can > 0.6 && xac_xuat_ran_can <= 0.8){
            *hp = *hp - 50;
        }else if(xac_xuat_ran_can > 0.4 && xac_xuat_ran_can <= 0.6){
            *hp = *hp - 30;
        }else if( xac_xuat_ran_can > 0.2 && xac_xuat_ran_can <= 0.4){
            *hp = *hp - 20;
        } else if(xac_xuat_ran_can > 0.0 && xac_xuat_ran_can <= 0.2){
            *hp = *hp;
        }
    }

    // int p1 = P1(hp);
    // int p2 = P2(hp,s,d);

    float p;

    f = f_truong_hop_2(d,s,t);

    return f;
    
}

float f_truong_hop_4(int d, int s){
    float f =  (float)(-d*s)/1000.0;

    return f;
}

float Xac_Xuat_AnTienSong(int p1, int p2, int f){

    float p;
    p = (float)(p1 + p2*f)/(1000.0+abs(p2*f));
    return p;
}




float  Song_Chet(int hp, int d, int s, char *t){
    int p1;
    int p2;
    float f;
    float p;
    if(d < 200){
        p1 = P1(hp);
        p2 = P2(hp,s,d);
        f = f_truong_hop_1(d,s,t);
        p = Xac_Xuat_AnTienSong(p1,p2,f);
    } else if( d>= 200 && d < 300){
        f = f_truong_hop_3(&hp,d,s,t);
        p1 = P1(hp);
        p2 = P2(hp,s,d);
        p = Xac_Xuat_AnTienSong(p1,p2,f); 
    } else if(d >= 200 && d <= 800){
        p1 = P1(hp);
        p2 = P2(hp,s,d);
        f = f_truong_hop_2(d,s,t);
        p = Xac_Xuat_AnTienSong(p1,p2,f);
}else if(d> 800){
    p1 = P1(hp);
    p2 = P2(hp,s,d);
    f = f_truong_hop_4(d,s);
    p = Xac_Xuat_AnTienSong(p1,p2,f);
}
return p;
}

void main(){
    /*
    int hp = 918;
    int d = 911;
    int s = 28;
    char *t = "Cloudy"; */
    /*
    float p = 0;
    p = Song_Chet(hp,d,s,t);
    if(p < 0){
        p = 0;
    }
    printf("\n P = %.3f",p); */

    int hp;
    int d;
    int s;
    char t[20];

    
    FILE *Fin = fopen("input.txt", "r");
    FILE *Fout = fopen("ouput.txt", "w");

    if(Fin == NULL){
        printf("\nerorr\n");
        exit(-1);
    }else{
        fscanf(Fin, "%d", &hp);
        fscanf(Fin, "%d", &d);
        fscanf(Fin, "%d", &s);

        fgets(t,19,Fin);
    }

    float p = 0;
    p = Song_Chet(hp,d,s,t);
    if(p < 0){
        p = 0;
    }

    if( Fout == NULL){
        printf("\nerorr\n");
        exit(-1);
    }else{
        fprintf(Fout,"%.3f",p);
    }

    fclose(Fin);
    fclose(Fout);

}