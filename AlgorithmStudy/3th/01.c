#include <stdio.h>
#include <stdlib.h>

typedef struct sosigi
{
	int lN;
	int wN; // lN: length, wN: width
}sosigi;

int main(void){
	
	int N = 0;  
	int i = 0, j = 0;
	sosigi box;
	sosigi* sosig = NULL;
	sosigi* sosig_t = NULL;
	int count = 1, count1 = 1;
	
	scanf("%d",&N);
	sosig = (sosigi*)malloc(sizeof(sosigi)*N);
	sosig_t = (sosigi*)malloc(sizeof(sosigi)*N);
	
	for(i = 0; i <N; i ++)
	{
		scanf("%d%d",&sosig[i].lN,&sosig[i].wN);
		scanf("%d%d",&sosig_t[i].lN,&sosig_t[i].wN);
	}
	/*
	for(i = 0; i <N; i ++)
	{
		printf("%d%d",sosig[i].lN,sosig[i].wN);
	}
	return 0;
	*/
	for(j=0;j<N-1; j++)
	{
		for(i=0; i <N-1; i++)
		{
			if(sosig[i].lN<sosig[i+1].lN)
			{
	
				//printf("sosig[%d].lN: %d\n",i,sosig[i].lN);
				//printf("sosig[%d].lN: %d\n",i+1,sosig[i+1].lN);	
				box = sosig[i];
				sosig[i] = sosig[i+1];
				sosig[i+1] = box;
			}
			else if(sosig[i].lN == sosig[i+1].lN)
			{
				if(sosig[i].wN < sosig[i].wN)
				{
					box = sosig[i];
					sosig[i] = sosig[i+1];
					sosig[i+1] = box;
				}
			}
		}
	}//for
					 
	for(i=0; i<N;i ++){
		printf("sosig[%d].lN: %d\n",i,sosig[i].lN);	
		printf("sosig[%d].wN: %d\n",i,sosig[i].wN);
		if(sosig[i].wN < sosig[i+1].wN)
		{
			count++;
		}
	}

	for(j=0;j<N-1; j++)
	{
		for(i=0; i <N-1; i++)
		{
			if(sosig_t[i].wN<sosig_t[i+1].wN)
			{
	
				//printf("sosig[%d].lN: %d\n",i,sosig[i].lN);
				//printf("sosig[%d].lN: %d\n",i+1,sosig[i+1].lN);	
				box = sosig[i];
				sosig_t[i] = sosig_t[i+1];
				sosig_t[i+1] = box;
			}
			else if(sosig_t[i].wN == sosig_t[i+1].wN)
			{
				if(sosig_t[i].lN < sosig_t[i].lN)
				{
					box = sosig_t[i];
					sosig_t[i] = sosig_t[i+1];
					sosig_t[i+1] = box;
				}
			}
		}
	}//for
					 
	for(i=0; i<N; i++){
		//printf("sosig[%d].lN: %d\n",i,sosig[i].lN);	
		//printf("sosig[%d].wN: %d\n",i,sosig[i].wN);
		if(sosig_t[i].lN < sosig_t[i+1].lN)
		{
			count1++;
		}
	}
	
	free(sosig);
	
	if(count < count1)
	{	
		printf("%d\n",count);
	}else {
	  	printf("%d\n",count1);
	
	}
		
	return 0;	

}
