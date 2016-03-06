#include <stdio.h>


int s[1000];
int e[1000];

int main(void)
{
	int N;
	int i,j;
	int box, box1;
	int comp = 0;
	int count = 1; 
	int pre;

	scanf("%d",&N);


	for(i=1; i<= N; i++)
	{
		scanf("%d %d", &s[i], &e[i]);
	}

	for(i=1; i<= N; i++){
		for(j=1; j<= N; j++){
			if(s[i] < s[j])
			{
				box = s[i];
				s[i] = s[j];
				s[j] = box;
			}
			if(e[i] < e[j])
			{
				box = e[i];
				e[i] = e[j];
				e[j] = box;
			}		
		}
	}

	j = 1;
	
	for(i = 1; i <= N; i++ )
	{
		if(s[i]>e[j])
		{
			
			count++;
			j++;
			while(s[i]>e[j]) j++;
		}
	}

	printf("%d\n", count);

	return 0;
}	
