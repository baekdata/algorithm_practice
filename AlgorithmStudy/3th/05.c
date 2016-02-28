#include <stdio.h>
#include <stdlib.h>


int arr[512][512];

int tile (int s_x, int s_y, int e_x, int e_y, int direction);
void find(int s_x, int s_y, int e_x, int e_y);

int main(void)
{
	int N;
	int i, j, x, y;
	scanf("%d", &N);
	scanf("%d%d",&x,&y);
	for(i = 0; i < N; i ++)
	{
		for(j = 0; j < N; j++)
		{
			arr[i][j] = 5;
		}
	}
	arr[x][y] = 0;

	find(0,0,N-1,N-1);
	
	for(i=0; i<N; i++)
	{
		for(j = 0; j < N; j++)
		{
			printf("%d ",arr[i][j]);
		}
		printf("\n");
	}

	return 0;
}

void find(int s_x, int s_y, int e_x, int e_y){

	int result = 0;
	int i , j;
	printf("e_x-s_x : %d , e_y-s_y : %d\n",e_x-s_x,e_y-s_y);

		printf("before result : %d %d %d %d\n",s_x,s_y,(e_x-s_x+1)/2-1+s_x,(e_y-s_y+1)/2-1+s_y);
		printf("before result : %d %d %d %d\n",(e_x-s_x+1)/2+s_x,s_y,(e_x),(e_y-s_y+1)/2-1+s_y);
		printf("before result : %d %d %d %d\n",s_x,(e_y-s_y+1)/2+s_y,(e_x-s_x+1)/2-1+s_x,(e_y));
		printf("before result : %d %d %d %d\n",(e_x-s_x+1)/2+s_x,(e_y-s_y+1)/2+s_y,(e_x),(e_y));
		result = tile(s_x,s_y,(e_x-s_x+1)/2-1+s_x,(e_y-s_y+1)/2-1+s_y,1);
		result += tile((e_x-s_x+1)/2+s_x,s_y,(e_x),(e_y-s_y+1)/2-1+s_y,2);
		result += tile(s_x,(e_y-s_y+1)/2+s_y,(e_x-s_x+1)/2-1+s_x,(e_y),3);
		result += tile((e_x-s_x+1)/2+s_x,(e_y-s_y+1)/2+s_y,(e_x),(e_y),4);
	
		switch(result)
		{
		case 1 :
			 printf("1\n"); 
			 printf("1 : %d %d\n",(e_x-s_x+1)/2+s_x, (e_y-s_y+1)/2-1+s_y);
			 printf("1 : %d %d\n",(e_x-s_x+1)/2-1+s_x, (e_y-s_y+1)/2+s_y);
			 printf("1 : %d %d\n",(e_x-s_x+1)/2+s_x, (e_y-s_y+1)/2+s_y);
			 arr[(e_x-s_x+1)/2+s_x][(e_y-s_y+1)/2-1+s_y]   = 1;
			 arr[(e_x-s_x+1)/2-1+s_x][(e_y-s_y+1)/2+s_y]   = 1;
			 arr[(e_x-s_x+1)/2+s_x][(e_y-s_y+1)/2+s_y]    = 1;	
			 break;
		case 2 : 
			 printf("2\n"); 
			 printf("2 : %d %d\n",(e_x-s_x+1)/2-1+s_x, (e_y-s_y+1)/2-1+s_y);
			 printf("2 : %d %d\n",(e_x-s_x+1)/2-1+s_x, (e_y-s_y+1)/2+s_y);
			 printf("2 : %d %d\n",(e_x-s_x+1)/2+s_x, (e_y-s_y+1)/2+s_y);	
			 arr[(e_x-s_x+1)/2-1+s_x][(e_y-s_y+1)/2-1+s_y] = 2;
			 arr[(e_x-s_x+1)/2-1+s_x][(e_y-s_y+1)/2+s_y]   = 2;
			 arr[(e_x-s_x+1)/2+s_x][(e_y-s_y+1)/2+s_y]    = 2;	
			 break;
	        case 3 : 
			 printf("3\n"); 
			 printf("3 : %d %d\n",(e_x-s_x+1)/2-1+s_x, (e_y-s_y+1)/2-1+s_y);
			 printf("3 : %d %d\n",(e_x-s_x+1)/2+s_x, (e_y-s_y+1)/2-1+s_y);
			 printf("3 : %d %d\n",(e_x-s_x+1)/2+s_x, (e_y-s_y+1)/2+s_y);
			 arr[(e_x-s_x+1)/2-1+s_x][(e_y-s_y+1)/2-1+s_y] = 3;
			 arr[(e_x-s_x+1)/2+s_x][(e_y-s_y+1)/2-1+s_y]   = 3;
			 arr[(e_x-s_x+1)/2+s_x][(e_y-s_y+1)/2+s_y]    = 3;	
		
			 break;
		case 4 : 
			 printf("4\n"); 	
			 printf("4 : %d %d\n",(e_x-s_x+1)/2-1+s_x, (e_y-s_y+1)/2-1+s_y);
			 printf("4 : %d %d\n",(e_x-s_x+1)/2+s_x, (e_y-s_y+1)/2-1+s_y);
			 printf("4 : %d %d\n",(e_x-s_x+1)/2-1+s_x, (e_y-s_y+1)/2+s_y);
			 arr[(e_x-s_x+1)/2-1+s_x][(e_y-s_y+1)/2-1+s_y]  = 4;
			 arr[(e_x-s_x+1)/2+s_x][(e_y-s_y+1)/2-1+s_y]   = 4;
			 arr[(e_x-s_x+1)/2-1+s_x][(e_y-s_y+1)/2+s_y]    = 4;
			 break;
		default : printf("error\n"); 
		}
		printf("before if : %d %d\n",e_x-s_x, e_y-s_y);	 
		if( ((e_x-s_x) == 1) || ((e_y-s_y) == 1) ){
			printf("return\n");
			return;						
		}else {

			printf("find %d %d %d %d\n",s_x,s_y,(e_x-s_x+1)/2-1+s_x,(e_y-s_y+1)/2-1+s_y);
			printf("find %d %d %d %d\n",(e_x-s_x+1)/2+s_x,s_y,e_x,(e_y-s_y+1)/2-1+s_y);
			printf("find %d %d %d %d\n",s_x,(e_y-s_y+1)/2+s_y,(e_x-s_x+1)/2-1+s_x,e_y);
			printf("find %d %d %d %d\n",(e_x-s_x+1)/2+s_x,(e_y-s_y+1)/2+s_y,e_x,e_y	);		
			find(s_x,s_y,(e_x-s_x+1)/2-1+s_x,(e_y-s_y+1)/2-1+s_y);
			find((e_x-s_x+1)/2+s_x,s_y,e_x,(e_y-s_y+1)/2-1+s_y);
			find(s_x,(e_y-s_y+1)/2+s_y,(e_x-s_x+1)/2-1+s_x,e_y);
			find((e_x-s_x+1)/2+s_x,(e_y-s_y+1)/2+s_y,e_x,e_y);
		}
	
}

int tile (int s_x, int s_y, int e_x, int e_y, int direction){

	int i, j;
	int count = 0;
	for(i = s_x; i <= e_x; i++)
	{
		for(j = s_y; j <= e_y; j++)
		{
			printf("arr[%d][%d] = %d\n",i,j,arr[i][j]);
			if(arr[i][j] != 5)
			{
				count= count+1;
				return direction;
			}
		}
	}

	if(count != 0){
		printf("direction : %d\n",direction);
		return direction;
	}else{
		printf("no hasugu\n");
		 return 0; 
	}
			
}



