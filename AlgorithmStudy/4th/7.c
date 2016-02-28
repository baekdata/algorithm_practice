#include <stdio.h>

int dequeue(void);
void enqueue(int i);

int arr[100000];
int que[100000];
int buildingNumber[100000];
int queNumber = 0;

int main(void){

	int i,j;
	int box;
	int N;

	scanf("%d",&N);
	for(i=1; i<=N; i++){
		scanf("%d",&arr[i]);
	}
	for(i=1; i<=N; i++){
		if(arr[i]>=arr[i+1])
		{
			enqueue(i);
		}
		else if(arr[i]<arr[i+1])
		{
			buildingNumber[i] = i+1;
			box = dequeue();
			while(box != -1){
				if(arr[box] < arr[i+1])
				{	
					buildingNumber[box] = i+1;
				}
				else if(arr[box] >= arr[i+1])
				{
					enqueue(box);
					break;
				}
				box = dequeue();
			}
		}	
	}

	for(i=1; i<=N; i++){
		printf("%d\n",buildingNumber[i]);
	}
	return 0;
}

void enqueue(int i){
	
	queNumber++;
	que[queNumber] = i;
	return ;	
}

int dequeue(void){
	int box;

	if(queNumber == 0) return -1;
	else {
		box = que[queNumber];
		queNumber--;
		return box;
	}	
}
