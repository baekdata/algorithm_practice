#include <stdio.h>


int main(void)
{
	int i,j,k,l;
	int N;
	int d[1000][1000];
	int count = 0 ;
	int lastPageNumber = 1;
	double result;


	scanf("%d", &N);

	for(i = 1; i <= N; i++)
	{
		for(j = 1; j <= N; j++)
		{
			d[i][j] = 100;
			if(i == j) d[i][j] = 0;
		}
	}


	for(j = 1; j <= N; j++)
	{	
		scanf("%d %d",&k, &l);
		if(k > lastPageNumber) lastPageNumber = k;
		if(l > lastPageNumber) lastPageNumber = l;
		d[k][l] = 1;
	}

	for (k = 1; k <= N; k++){
		for (i = 1 ;i <= N; i++){
		    for (j = 1; j <= N; j++){
		        if (d[i][j] > d[i][k]+d[k][j]){
		            d[i][j] = d[i][k]+d[k][j]; 
		        }
		    }
		}
	}

	for(i = 1; i <= N; i++)
	{
		for(j = 1; j <= N; j++)
		{
			if(d[i][j] != 100)
			{			
				count = count + d[i][j] ;
			}
		}
	}
	
	result = (double)(count)/(double)(lastPageNumber*(lastPageNumber-1));
	//printf("count : %d\n", count);
	//printf("N*N : %d\n", lastPageNumber*(lastPageNumber-1));
	printf("%.3lf\n", result);
	return 0;
}
