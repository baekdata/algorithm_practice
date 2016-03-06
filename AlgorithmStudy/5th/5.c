#include <stdio.h>



unsigned long N,M;
unsigned long partition(unsigned long k);
unsigned long result;
unsigned long box;
unsigned long part ;

int main(void)
{

	box = 1;

	scanf("%lu %lu", &N, &M);
	result = partition(M);
	//result = result%20091024;
	printf("%lu\n",result);
	return 0;
}

unsigned long partition(unsigned long k)
{

	int i,j;
	

	box = 1;
	part = 1;	

	if(k % 2 == 0)
	{
		printf("k : %lu\n",k);
		part = partition(k/2);
		if(part >= 20091024)
		{
				part = part%20091024;
		}
		part = part*part;
		if(part >= 20091024)
		{
			part = part%20091024;
		}
		printf("part : %lu\n",part);
			
		return part;
	}	
	else
	{
		for(i = 1; i <= k; i++)
		{
			
			if(box >= 20091024)
			{
				box = box%20091024;
			}
			
			
			box *= N;
			
		}
		printf("box : %lu\n",box);
		return box; 
	}
	
	

}









