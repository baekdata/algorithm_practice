#include <iostream>
#include <string>
//#define T 101
using std::string;
using std::cin;
using std::cout;
using std::endl;
const int T =101;
typedef struct
{
	int row;
	int column;
	int depth;
}zergling; // BFS에 쓰일 구조체

int zerglings[T][T]={0,}; // 1 : 저글링이 있다, 0 : 저글링이 없다

zergling queue[T]= {0,}; // 큐
int queue_index=-1; //큐의 현재 인덱스
int current_depth=0;
void enqueue(zergling Zergling)
{
	if(queue_index == -1)
	{	
		queue[0].row = Zergling.row;
		queue[0].column = Zergling.column;
		queue[0].depth = Zergling.depth;
		queue_index++;
	}
	else
	{
		queue[queue_index+1].row = Zergling.row;
		queue[queue_index+1].column = Zergling.column;
		queue[queue_index+1].depth = Zergling.depth;
		queue_index++;
	}
}

zergling dequeue()
{
	int i;
	zergling return_value;
	return_value= queue[0];
	for(i=0;i<queue_index;i++)
		queue[i]=queue[i+1];
	queue_index--;
	return return_value;

}

int is_empty()
{
	if(queue_index == -1)
		return 1;
	else
		return 0;
}
int main()
{
	int zergling_remaining=0;
	int zergling_input;
	int i,j;
	int M; //열
	int N; //행
	int R; //저글링의 열
	int C; //저글링의 행
	string s1;
	cin>>M;
	cin>>N;

	for(i=1;i<=N;i++)
	{	
		cin>>s1;
		for(j=1;j<=M;j++)
		{
			zergling_input = s1[j-1]-'0';
			zerglings[i][j] = zergling_input;
		}
	}

	cin>>R;
	cin>>C;
	zergling initial_point = {C,R,0};

	enqueue(initial_point);
	while(1)
	{
		if(is_empty())
			break;
		zergling compare = dequeue();
		if(current_depth < compare.depth)
			current_depth = compare.depth;
		int new_depth = compare.depth + 1;
		int i;
		zergling zergling[4];

		zerglings[compare.row][compare.column] = 0;
	
//		else
	//	{


			zergling[0].row =compare.row;
			zergling[0].column =compare.column+1 ;
			zergling[0].depth = new_depth; //오른쪽
			zergling[1].row = compare.row;
			zergling[1].column = compare.column-1;
			zergling[1].depth = new_depth; // 왼쪽
			zergling[2].row = compare.row-1;
			zergling[2].column = compare.column;
			zergling[2].depth = new_depth; // 위
			zergling[3].row = compare.row+1;
			zergling[3].column = compare.column;
			zergling[3].depth = new_depth; // 아래
			for(i=0;i<4;i++)
			{
				if(zergling[i].row <1 || zergling[i].row > N || zergling[i].column <1 || zergling[i].column >M)
					continue;
				else if(zerglings[zergling[i].row][zergling[i].column] != 0)
					enqueue(zergling[i]);
				
			}
				

	//	}
	}
	
	
	for(i=1;i<=N;i++)
		for(j=1;j<=N;j++)
		{	
			if(zerglings[i][j] == 1)
				zergling_remaining++;
		}	
	printf("%d\n%d \n",current_depth+3,zergling_remaining);



	return 0;
}