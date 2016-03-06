#include <stdio.h>
#include "./structQueue/circleQueue.h"

Data data[200][200];

int main(void)
{
	int i,j;
	int N,M;
	int x_cur = 0, y_cur = 0;
	int result = 0 ;
	int length = 1;
	Queue q;
	Data dequeData;
	QueueInit(&q);

//입력을 받는다
	scanf("%d %d",&N,&M);
	
 
	for(j=0; j<N; j++)
	{
		for(i=0; i<M; i++)
		{
			scanf("%d",&data[i][j].value);
			data[i][j].use = 0;
		}
	}

	//printf("test value %d\n",data[1][1].value);
	data[0][0].x_cur = 0;
	data[0][0].y_cur = 0; 
	data[0][0].length = length;
	Enqueue(&q,&data[0][0]);

	while(!QIsEmpty(&q))
	{
			//printf("deque\n");
			//printf("data[0][0] : %d %d\n",data[0][0].x_cur,data[0][0].y_cur);
			
			dequeData = Dequeue(&q);
			data[dequeData.x_cur][dequeData.y_cur].use = 1;
			//printf("x_cur : %d y_cur : %d\n", dequeData.x_cur, dequeData.y_cur);
			//printf("dequeData.value %d\n",dequeData.value);		
			if((data[dequeData.x_cur][dequeData.y_cur].value == 1 ))
			{
		
				if((dequeData.x_cur+1 < M)&& (data[dequeData.x_cur+1][dequeData.y_cur].use == 0))
				{
					//printf("x_cur +1 enqueue\n");
					data[dequeData.x_cur+1][dequeData.y_cur].length = dequeData.length + 1 ;
					data[dequeData.x_cur+1][dequeData.y_cur].x_cur = dequeData.x_cur + 1;  
					data[dequeData.x_cur+1][dequeData.y_cur].y_cur = dequeData.y_cur;
					Enqueue(&q,&data[dequeData.x_cur+1][dequeData.y_cur]);		
				}
				if((dequeData.y_cur+1 < N)&& (data[dequeData.x_cur][dequeData.y_cur+1].use == 0))
				{
					//printf("y_cur +1 enqueue\n");
					data[dequeData.x_cur][dequeData.y_cur+1].length = dequeData.length + 1 ;
					data[dequeData.x_cur][dequeData.y_cur+1].x_cur = dequeData.x_cur;
					data[dequeData.x_cur][dequeData.y_cur+1].y_cur = dequeData.y_cur + 1;
					Enqueue(&q,&data[dequeData.x_cur][dequeData.y_cur+1]);		
				}
				if((0 <= dequeData.x_cur-1)&& (data[dequeData.x_cur-1][dequeData.y_cur].use == 0))
				{
					//printf("x_cur -1 enqueue\n");
					data[dequeData.x_cur-1][dequeData.y_cur].length = dequeData.length + 1 ;
					data[dequeData.x_cur-1][dequeData.y_cur].x_cur = dequeData.x_cur - 1;  
					data[dequeData.x_cur-1][dequeData.y_cur].y_cur = dequeData.y_cur;
					Enqueue(&q,&data[dequeData.x_cur-1][dequeData.y_cur]);				
				}
				if((0 <= dequeData.y_cur-1) && (data[dequeData.x_cur][dequeData.y_cur-1].use == 0))
				{
					//printf("y_cur -1 enqueue\n");
					data[dequeData.x_cur][dequeData.y_cur-1].length = dequeData.length + 1 ;
					data[dequeData.x_cur][dequeData.y_cur-1].x_cur = dequeData.x_cur;  
					data[dequeData.x_cur][dequeData.y_cur-1].y_cur = dequeData.y_cur-1;
					Enqueue(&q,&data[dequeData.x_cur][dequeData.y_cur-1]);				
				}
			}
			
	}


	printf("%d\n",data[M-1][N-1].length);
							
	return 0;
}
