#include <stdio.h>
#define N 100

int num_of_possible_answer=0;

void already_passed(int (* chess)[N], int start_row,int start_column, int n)
{
	int i=0;
	int j;
	//시작 부분까지는 이미 지나감
	while(i<start_row)
	{
		for(j=0;j<n;j++)
			chess[i][j] = 1;

		i++;
	}
	for(j=0;j<start_column;j++)
		chess[i][j]= 1;
}

int is_chess_full(int (* chess)[N],int n)
{
	int i;
	int j;
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			if(chess[i][j] == 0)
				return 0;
		}

	return 1;
}

void checking_all_possible_route(int (*chess)[N], int start_row, int start_column, int n)
{

		if(start_column <0 || start_row <0 || start_row>=n ||  start_column >=n || chess[start_row][start_column] == 1)
			return;

		chess[start_row][start_column]=1;

		checking_all_possible_route(chess, start_row,start_column+1,n); // 오른쪽
		checking_all_possible_route(chess, start_row,start_column-1,n); // 왼쪽
		checking_all_possible_route(chess, start_row-1,start_column,n); // 위
		checking_all_possible_route(chess, start_row+1,start_column,n); // 아래
		checking_all_possible_route(chess, start_row-1,start_column+1,n); // 오른쪽 대각선 위
		checking_all_possible_route(chess, start_row-1,start_column-1,n); // 왼쪽 대각선 위
		checking_all_possible_route(chess, start_row+1,start_column-1,n); // 왼쪽 대각선 아래
		checking_all_possible_route(chess, start_row+1,start_column+1,n); // 오른쪽 대각선 아래
	   

}

void Nqueen(int (* chess)[N], int start_row,int start_column,int n)
{


	

	int i;
	int j;
	int n2=n;
	
	checking_all_possible_route(chess, start_row,start_column,n);
	n2--;
	for(i=0;i<n;i++)
	 for(j=0;j<n;j++)
	{
			if(chess[i][j] == 1)
				continue;
			else
			{
				n2--;
				checking_all_possible_route(chess,i,j,n);
	 }
	}


	if(is_chess_full(chess,n) == 1 )
	{
		num_of_possible_answer++;
		return;
	}
	else
		printf("중간에 계산이 잘못됨\n");
	
	return;

									

}


int main()
{
	//초기화
	int i;
	int j;
	int n;
	scanf("%d",&n);

//	int chess[N][N]={0,};
//	checking_all_possible_route(chess, 0,0,n);

	
	//N퀸 시작
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			int chess[N][N]={0,};
			already_passed(chess, i,j,n);
			Nqueen(chess,i,j,n);
			
		}
		
	printf("%d \n",num_of_possible_answer);
	return 0;
		
}