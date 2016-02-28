#include <stdio.h>
#include <stdlib.h>


int main(void)
{
	int i, j;
	int N, W;
	int maxPrice; 
	int arr[10001][3];
	int max[10001];
	scanf("%d%d", &N, &W);
	for(i=1; i<=N; i++)
	{
		scanf("%d%d", &arr[i][1], &arr[i][2]);
	}

	max[1] = 0;

	for(i=1; i<= W; i ++)
	{
		maxPrice = 0;
		for(j=1; j <= N; j++)
		{
			if((i-arr[j][1] >= 0) && (max[i-arr[j][1]]+arr[j][2] > maxPrice))
			{
				//printf("arr[%d][2]]: %d \n",j,arr[j][2]);
				maxPrice = max[i-arr[j][1]]+arr[j][2] ;	
				//printf("W: %d, max[%d-arr[%d][1]]+arr[%d][2] : %d \n",W,i,j,j, max[i-arr[j][1]]+arr[j][2]);
			}
		}
		max[i] = maxPrice;			
	}
	
	printf("%d\n",max[W]);
	
	
	return 0;
}



