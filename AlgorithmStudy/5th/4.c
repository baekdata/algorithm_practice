#include <stdio.h>
#define COM1 startPointer->number
#define COM2 startPointer->pnext->number
#define COM3 startPointer->pnext->pnext->number

typedef struct cell{

	int number;
	struct cell *pnext;

}cell;


int detect_d(void);
int detext_i(void);
int search(void);
void insert(int num);
void  delete(int num);
struct cell *startPointer;
//detect_i : 넣을 공간을 찾는다
//detect_d : 삭제할 공간을 찾는다
//search : 줄이 맞는지 안맞는지 확인
//insert : 넣기
//delete : 삭제
//detect_d->delete->detect_i->insert 순으로 진행된다.


cell arr[1000];
int deleteIndex;
int insertIndex;
int N;
int main(void)
{
	int i;
	int count = 0;
	
	deleteIndex = -1;

	scanf("%d", &N);
		
	for(i=1; i<=N; i++)
	{
		scanf("%d", &arr[i].number);
		arr[i].pnext = &arr[i+1];
	}
	
	startPointer = &arr[1];
	while(search()!=0)
	{

	//printf("current.pnext->number: %d\n",arr[0].pnext->number) ;

		
		if(deleteIndex != -1)
		{	
			count ++;
			delete(deleteIndex);
			insertIndex = detect_i();
			if(insertIndex == -1) printf("insertIndex error\n");
			insert(insertIndex);
			//printf("%d",arr[i].pnext->number);
		}
		
	}	
	
	printf("%d\n", count);
	return 0;
}


int search(void)
{
	cell* current;
	int i;
	current = startPointer;
	deleteIndex = -1;
	
	printf("ewewrew\n");
	for(i=1; i<N; i++)
	{
		printf("i : %d\n", i);
		//printf("current.pnext->number: %d\n",arr[1].pnext->number) ;
		printf("current.number : %d\n",current->number);
		printf("current.pnext->number: %d\n",current->pnext->number) ;
		
		if(current->number>current->pnext->number)
		{
			if(i < 3)
			{
				deleteIndex = detect_d();
				printf("deleteIndex : %d\n", deleteIndex);
			}
			else deleteIndex = i+1;
			return -1;
		}
			current = current->pnext;
		
	}
	return 0;
}

void delete(int num)
{
	if(num == 1) startPointer = arr[num].pnext ;
	arr[num-1].pnext = &arr[num+1];
	arr[num].pnext = NULL;
}

void insert(int num)
{
	arr[deleteIndex].pnext = arr[num].pnext;
	arr[num].pnext = &arr[deleteIndex];
}

int detect_d(void){
	if( (COM1 < COM2) && (COM2 > COM3) && (COM1 > COM2)) return 3;
	if( (COM1 > COM2) && (COM2 < COM3) && (COM1 < COM3)) return 1;
	if( (COM1 < COM2) && (COM2 > COM3) && (COM1 > COM3)) return 3;
	if( (COM1 > COM2) && (COM2 < COM3) && (COM1 > COM3)) return 1;
	if( (COM1 > COM2) && (COM2 > COM3) && (COM1 > COM3)) return 2;
	
}

int detect_i(void)
{

	int i;

	if(arr[deleteIndex].number  == 1){
			insertIndex = 1;
			printf("insertIndex = 1\n");
		 	return 1;
	}
	for(i = 1; i <= N; i++)
	{
		if(arr[deleteIndex].number-1 == arr[i].number)
		{
			insertIndex = i;
			printf("insertIndex = %d\n",i);
			return i;
		}
	}
	return -1;
} 





