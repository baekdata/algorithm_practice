#include <stdio.h>
#define N 100

typedef struct
{
	int confer_num;
	int start_time;
	int end_time;
}conference;

conference confer[N] = {0,};
conference result[N] = {0,};
int greed=0; // 
conference temp;


int main()
{
	int i;
	int j;
	int num_of_confer;
	
	//입력 받기
	scanf("%d",&num_of_confer);
	for(i=0;i<num_of_confer;i++)
	{
		scanf("%d",&confer[i].confer_num);
		scanf("%d",&confer[i].start_time);
		scanf("%d",&confer[i].end_time);
	}

	
	// 오름차순으로 회의 배열을 정렬
	for(i=0;i<num_of_confer;i++)
		for(j=i+1;j<num_of_confer;j++)
		{	
			if(confer[i].end_time > confer[j].end_time)
			{
				
				temp.confer_num=confer[i].confer_num;
				temp.start_time=confer[i].start_time;
				temp.end_time=confer[i].end_time;

				confer[i].confer_num = confer[j].confer_num ;
				confer[i].start_time = confer[j].start_time;
				confer[i].end_time = confer[j].end_time;

				confer[j].confer_num = temp.confer_num;
				confer[j].start_time = temp.start_time;
				confer[j].end_time = temp.end_time;
		//		printf("how many \n");


			}
		}

		

	 //greed 알고리즘
		 result[0] = confer[0];
		 
		 for(i=1;i<num_of_confer;i++)
		{	 
			if(result[greed].end_time > confer[i].start_time)
				 continue;
			else
			{
				greed++;
				result[greed].confer_num = confer[i].confer_num;
				result[greed].start_time = confer[i].start_time;
				result[greed].end_time = confer[i].end_time;

			}
		 }
	 // 결과 출력
	printf("%d\n",greed+1);
		for(i=0;i<=greed;i++)
				printf("%d ", result[i].confer_num);
		printf("\n");




}