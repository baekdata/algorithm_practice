#include <stdio.h>
#define T 100

typedef struct
{
	int row;
	int column;
	int depth;
}point; // BFS에 쓰일 구조체

int JangGiPan[T][T]={0,}; // 장기판
point queue[T]= {0,}; // 큐
int queue_index=-1; //큐의 현재 인덱스

void enqueue(point Point)
{
	if(queue_index == -1)
	{	
		queue[0].row = Point.row;
		queue[0].column = Point.column;
		queue[0].depth = Point.depth;
		queue_index++;
	}
	else
	{
		queue[queue_index+1].row = Point.row;
		queue[queue_index+1].column = Point.column;
		queue[queue_index+1].depth = Point.depth;
		queue_index++;
	}
}
int is_empty()
{
	if(queue_index == -1)
		return 1;
	else
		return 0;
}
point dequeue()
{
	int i;
	point return_value=queue[0];
	

	for(i=0;i<queue_index;i++)
		queue[i]=queue[i+1];
	queue_index--;
	return return_value;

}


int main()
{
	int answer=-1;
	int N=-1; //행
	int M=-1; //열
	int R=-1; //말의 행
	int C=-1; //말의 열
	int S=-1; //졸의 행
	int K=-1; //졸의 열
	scanf("%d",&N);
	scanf("%d",&M);
	scanf("%d",&R);
	scanf("%d",&C);
	scanf("%d",&S);
	scanf("%d",&K);
	point initial_point={R,C,0};

	enqueue(initial_point);
	while(1)
	{
		if(is_empty())
		{	break;
		}
		point compare = dequeue();

		JangGiPan[compare.row][compare.column] = 1;
		if(compare.row == S && compare.column == K)
		{	
			answer = compare.depth;
			printf("%d \n", answer);
			break;
		}
		else
		{
			int new_depth = compare.depth + 1;
			int i;
			point new_point[8];

			new_point[0].row =compare.row-2;
			new_point[0].column =compare.column-1 ;
			new_point[0].depth = new_depth;
			new_point[1].row = compare.row-2;
			new_point[1].column = compare.column+1;
			new_point[1].depth = new_depth;
			new_point[2].row = compare.row-1;
			new_point[2].column = compare.column+2;
			new_point[2].depth = new_depth;
			new_point[3].row = compare.row+1;
			new_point[3].column = compare.column+2;
			new_point[3].depth = new_depth;
			new_point[4].row = compare.row+2;
			new_point[4].column = compare.column+1;
			new_point[4].depth = new_depth;
			new_point[5].row = compare.row+2;
			new_point[5].column = compare.column-1;
			new_point[5].depth = new_depth;
			new_point[6].row = compare.row+1;
			new_point[6].column = compare.column-2;
			new_point[6].depth = new_depth;
			new_point[7].row = compare.row-1;
			new_point[7].column = compare.column-2;
			new_point[7].depth= new_depth;
			for(i=0;i<8;i++)
			{
				if(new_point[i].row <1 || new_point[i].row > N || new_point[i].column <1 || new_point[i].column >M)
					continue;
				else if(JangGiPan[new_point[i].row][new_point[i].column] != 1)
					enqueue(new_point[i]);
				
			}


		}
	}



	return 0;
}