#include <stdio.h>
#include <stdlib.h>
//int * arr = NULL;
int arr[50000]={0,};
//int * answer = NULL;
int answer[200000]={0,};
int answer_index=0;
int main()
{
	int N;
	int Q;
	int i,j;
	int max=0;
	scanf("%d",&N);
	scanf("%d",&Q);
//	arr = (int *) malloc (sizeof(int) * N);
	//answer = (int *) malloc (sizeof(int)* Q);
	for(i=0;i<N;i++)
		scanf("%d",&arr[i]);
	for(i=0;i<Q;i++)
	{
		int first;
		int last;
		int index;
		scanf("%d",&first);
		scanf("%d",&last);
		index=first-1;

		if(index == last-1)
			max = arr[index];

		while(index != last-1)
		{
			if(arr[index] > max)
				max = arr[index];
			index ++;
			if(index == last-1)
				if(arr[index]>max)
				{	max=arr[index];
					break;
				}
		}
		answer[answer_index] = max;
		answer_index++;
		max=0;
//		printf("%d\n",max);
	}
	for(i=0;i<Q;i++)
		printf("%d\n",answer[i]);
}