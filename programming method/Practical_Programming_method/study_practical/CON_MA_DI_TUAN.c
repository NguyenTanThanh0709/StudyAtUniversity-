#include<stdio.h>
#include<stdbool.h>
#define M  8

int x[M] = {2,2,1,-1,-2,-2,-1,1}; // đi ngược chiều kim đồng hồ
int y[M] = {1,-1,-2,-2,-1,1,2,2}; 

// int x[M] = {-2,-1,1,2,2,1,-1,-  2}; // đi cùng chiều kim đồng hồ
// int y[M] = {1,2,2,1,-1,-2,-2,-1};

void taobanco(int board[][M]){
    int i,j;
    for(i = 0; i < M; i++){
        for(j = 0; j < M; j++){
            board[i][j] = 0;
        }
    }
}

void show(int board[][M]){
    int i,j;
    for(i = 0; i < M; i++){
        for(j = 0; j < M; j++){
            printf("%d\t",board[i][j]);
        }
        printf("\n\n");
    }
}

// Kiểm Tra bước đi tuần có hợp lệ, có nằm trong bàn cờ hay không
bool check(int i, int j){
    return (i >= 0 && i < M && j >= 0 && j < M);
}

// x1, y1 là vị trí đầu của con mã; step là bước đi
void TRY(int board[][M], int x1, int y1, int step){
    int l, inext, jnext;
    for(l = 0; l < M; l++){
        inext = x1 + x[l];
        jnext = y1 + y[l];
        if(check(inext,jnext) && board[inext][jnext] == 0){
            board[inext][jnext] = step + 1;
            if( step == M*M -1){
            
            }else{
                TRY(board,inext,jnext, step + 1);
                
            }
        }
    }
}

int main(){
    int board[M][M], kiemtra = 0;
    int x1 = 2;
    int y1 = 3;
    taobanco(board);
    board[x1][y1] = 1;
    TRY(board,x1,y1,1);
    printf("\n \t\t==============\n");
   show(board);

    return 0;
}