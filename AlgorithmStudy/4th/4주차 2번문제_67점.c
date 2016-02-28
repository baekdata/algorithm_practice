#include <stdio.h>
#include <stdlib.h>

int * hi = NULL;
int * answer =NULL;
int main()
{
	int N,i,j;
	scanf("%d",&N);
	hi = (int *) malloc (sizeof(int)*N);
	answer = (int * ) malloc(sizeof(int)*N);
	for(i=0;i<N;i++)
		scanf("%d",&hi[i]);
	for(i=0;i<N;i++)
	{	
		int num=0;
		int maxindex=0;
		for(j=i+1;j<N;j++)
		{
			
			
			if(hi[i]<hi[j])
			{	
//				printf("여기호출안돼?\n");
				num=j+1;
					maxindex = num;
					break;
			}
			if(hi[i] >= hi[j])
			{	
				continue;
			}
		}
		if(maxindex ==0)
			answer[i]=0;
		else
			answer[i]=maxindex;
	}
	answer[N-1]=0;
	for(i=0;i<N;i++)
		printf("%d\n",answer[i]);
}