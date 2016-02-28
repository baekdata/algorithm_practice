#include <stdio.h>
#define N 5000

typedef struct
{
	int length;
	int width;

}sosage;

sosage Sosage[N] = {0,};
sosage result[N] = {0,};
int greed=0; // 
sosage temp;


int main()
{
	int i;
	int j;
	int num_of_sosage;
	int result1=1;
	int result2=1;
	//입력 받기
	scanf("%d",&num_of_sosage);
	for(i=0;i<num_of_sosage;i++)
	{
		scanf("%d",&Sosage[i].length);
		scanf("%d",&Sosage[i].width);

	}

	
	// 오름차순으로 회의 배열을 정렬
	for(i=0;i<num_of_sosage;i++)
		for(j=i+1;j<num_of_sosage;j++)
		{	
			if(Sosage[i].length > Sosage[j].length)
			{
				
				temp.length=Sosage[i].length;
				temp.width=Sosage[i].width;
				
				Sosage[i].length = Sosage[j].length ;
				Sosage[i].width = Sosage[j].width;

				Sosage[j].length = temp.length;
				Sosage[j].width = temp.width;

		//		printf("how many \n");


			}
		}
		for(i=0;i<num_of_sosage;i++)
			if(((i+1) <num_of_sosage) && (Sosage[i].width > Sosage[i+1].width))
				result1++;


	for(i=0;i<num_of_sosage;i++)
		for(j=i+1;j<num_of_sosage;j++)
		{	
			if(Sosage[i].width > Sosage[j].width)
			{
				
				temp.length=Sosage[i].length;
				temp.width=Sosage[i].width;
				
				Sosage[i].length = Sosage[j].length ;
				Sosage[i].width = Sosage[j].width;

				Sosage[j].length = temp.length;
				Sosage[j].width = temp.width;

		//		printf("how many \n");


			}
		}
		for(i=0;i<num_of_sosage;i++)
			if(((i+1) <num_of_sosage) && (Sosage[i].length > Sosage[i+1].length))
				result2++;
		
		printf("%d\n", result1>result2? result2:result1);

	 //greed 알고리즘

	 // 결과 출력




}