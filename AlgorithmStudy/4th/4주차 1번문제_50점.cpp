#include <stdio.h>

int distance[101]={0,};
int found[101]={0,};
int weight[101][101]={0,};


int lowest_weight_index(int N)
{
	int i, min, minpos;
	min = 20000; // 매우 큰 수
	minpos =0 ;
	for(i=1;i<=N;i++)
		if(distance[i] != 0 && distance[i]<min && !found[i])
		{
			min=distance[i];
			minpos=i;
		}
	return minpos;
}

void shortest_path(int n, int start)
{
	int i,u,w;

	for(i=0;i<n-1;i++)
	{
		u = lowest_weight_index(n);
		found[u]= 1;//true
		for(w=1;w<=n;w++)
		{	
			if(w != start)
			{
				if(distance[w] == 0 && weight[u][w] !=0)
					distance[w]=distance[u]+weight[u][w];
			
				else if(  distance[u]+weight[u][w]<distance[w] && weight[u][w] !=0 )
				{	
					distance[w] = distance[u]+weight[u][w];
				}
			}
		}
	}

}


int main()
{
	//초기화
	int N, M,i,j,k;
	int num_of_vertex=0;
	long sum=0;
	int start=1;
	double result;
	scanf("%d",&N);
	for(i=0;i<N;i ++)
	{	
		int j,k;
		scanf("%d",&j);
		if(num_of_vertex < j)
			num_of_vertex = j;
		scanf("%d",&k);
		if(num_of_vertex < k)
			num_of_vertex = k;
		weight[j][k]=1;
	}


	for(start=1;start<=num_of_vertex;start++)
	{	for(i=1;i<=num_of_vertex;i++)
		{	
		
			found[i] = 0; // false
			distance[i] = weight[start][i];
			
		}
		found[start] = 1; // true
		shortest_path(num_of_vertex,start);

		for(j=1;j<=N;j++)
			sum += distance[j];
	}

		result = (double) sum/(num_of_vertex*(num_of_vertex-1));
		printf("%.3lf\n",result);

	



}