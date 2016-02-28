#include <stdio.h>
#define N 128

int paper[N][N] = {0,};
int blue;
int white;
int is_all_1(int row_start, int row_end, int column_start, int column_end)
{
	int i,j;
	for(i=row_start;i<=row_end;i++)
		for(j=column_start;j<=column_end;j++)
		{
			if(paper[i][j] == 0)
				return 0;
		}
	return 1;
}
int is_all_0(int row_start, int row_end, int column_start, int column_end)
{
	int i,j;
	for(i=row_start;i<=row_end;i++)
		for(j=column_start;j<=column_end;j++)
		{
			if(paper[i][j] == 1)
				return 0;
		}
	return 1;

}
// 0 : Èò»ö, 1 : ÆÄ¶õ»ö
void find_blue_white(int row_start, int row_end, int column_start, int column_end, int n)
{
	if(is_all_1(row_start,row_end,column_start,column_end))
	{
		blue++;
		return;
	}
	if(is_all_0(row_start,row_end,column_start,column_end))
	{
		white++;
		return;
	}

	find_blue_white(row_start,row_start+n/2-1 ,column_start,column_start+n/2-1 ,n/2); // 1
	find_blue_white(row_start,row_start+n/2-1 ,column_start+n/2,column_start+n/2+n/2-1,n/2 ); // 2
	find_blue_white(row_start+n/2,row_start+n/2+n/2-1,column_start,column_start+n/2-1,n/2); // 3
	find_blue_white(row_start+n/2,row_start+n/2+n/2-1,column_start+n/2,column_start+n/2+n/2-1,n/2); // 4
}
int main()
{
	int length;
	int i,j;
	scanf("%d",&length);
	for(i=0;i<length;i++)
		for(j=0;j<length;j++)
		{
			scanf("%d",&paper[i][j]);
		}
	find_blue_white(0,length-1,0, length-1,length);
	printf("%d\n",white);
	printf("%d\n",blue);
	return 0;
}