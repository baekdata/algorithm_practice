#include <stdio.h>

int weight[13][13] = {0,};
int visited[13] = {0,};
int sum=0;
int result=10000000; 
int visited_num=0;
int no_path_flag = 0;

void finding_path(int start, int end, int N)
{

	int i;
	if(end!=1 && (visited_num > N || weight[start][end] == 0 || visited[end]==1))
	{
		no_path_flag = 1;

		return;

	}
	sum+=weight[start][end];
	visited_num++;
	visited[end] = 1;
	
	
	if(visited_num == N)
	{	
		sum +=weight[end][1];
		if(weight[end][1] == 0)
			return;

		if(sum < result)
		{
			result=sum;

		}
		return;
	}
	


	for(i=2;i<=N;i++)
	{
	
			finding_path(end,i,N);
			if(no_path_flag ==1)
				no_path_flag = 0;
			else
			{
				visited_num--;
				visited[i]=0;
				sum -= weight[end][i];
			}
	}

}
int main()
{
	int N;
	int i,j;
	scanf("%d",&N);
	for(i=1;i<=N;i++)
		for(j=1;j<=N;j++)
			scanf("%d",&weight[i][j]);
	finding_path(1,1,N);
	printf("%d \n",result);

	return 0;
}