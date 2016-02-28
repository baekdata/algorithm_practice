#include <stdio.h>
#include <stdlib.h>



typedef struct zugle{

	int visible; // 1:visible 0:not visible
	int virus; // 1:virus
	int time;


}zugle;

zugle arr[100][100];
int N, M;
int maxTime = 0;
int survivalNumber = 0;
void search(int x, int y);
void survival();

int main(void)
{
	int i,j,k;
	int max;

	scanf("%d%d",&N, &M);
	for(j = 0 ; j<M; j++)
	{
		for(i = 0; i<N; i++)
		{
			scanf("%d",&arr[i][j].visible);
			arr[i][j].virus = 0;
		}
	}
	scanf("%d%d",&i,&j);
	arr[i-1][j-1].virus = 1;
	arr[i-1][j-1].time = 3;
	
	search(i-1,j-1);
	survival();

	printf("%d\n",maxTime);
	printf("%d\n",survivalNumber);		

	return 0 ;
}

void search(int x, int y){
	
	int i = 0 , j = 0, k = 0, l = 0;
	
	if(arr[x][y].time > maxTime){
		maxTime = arr[x][y].time;
	}

	if( (x < 0) || (y < 0) || ((x+1) > N) || ((y+1) > M))
	{
		return;
	}
	
	if(((x+1) <N) && (arr[x+1][y].visible == 1) && (arr[x+1][y].virus == 0)){
			i = 1;
			arr[x+1][y].virus = 1;
			arr[x+1][y].time = arr[x][y].time+1;
		
	}
	if(( (x-1) >=0) && (arr[x-1][y].visible == 1) && (arr[x-1][y].virus == 0)){
			j = 1;
			arr[x-1][y].virus = 1;
			arr[x-1][y].time = arr[x][y].time+1;
		
	}
	if(((y-1) >=0 ) && (arr[x][y-1].visible == 1) && (arr[x][y-1].virus == 0)){
			k = 1;
			arr[x][y-1].virus = 1;
			arr[x][y-1].time = arr[x][y].time+1;
		
	}
	if(( (y+1) < M) && (arr[x][y+1].visible == 1) && (arr[x][y+1].virus == 0)){
			l = 1;
			arr[x][y+1].virus = 1;
			arr[x][y+1].time = arr[x][y].time+1;
		
	}
	if( i == 1) search(x+1,y);
	if( j == 1) search(x-1,y);
	if( k == 1) search(x,y-1);
	if( l == 1) search(x,y+1);

}

				

void survival(){

	int i, j;
	for(i = 0; i < N; i++){
		for(j = 0; j <M; j++){
			if((arr[i][j].visible == 1) && (arr[i][j].virus == 0)){
				survivalNumber++;
			}
		}
	}

	
}

