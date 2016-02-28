#include <stdio.h>
#include <string.h>

int stack[1000];
char arr[1000];
char visible[1000];

void push(int);
int pop(void);
int stackNumber =0;
int popValue;


int main(void){

	int i;
	int length = 0;
	int popCharNumber = 0;
	int count = 0;
	


	scanf("%s",arr);
	length = strlen(arr);
	

	for(i=0;i<length;i++)
	{
		visible[i] = 0;			
	}
	for(i=0;i<length;i++)
	{
		printf("1 : arr[i] : %c\n",arr[i]);

		if(arr[i] == 't' || arr[i] == 'c')
		{
			popCharNumber = pop();
			printf("first popCharNumber %d\n",popCharNumber);

			while(popCharNumber != -1)
			{
				

				if(popCharNumber != -1 && (arr[popCharNumber] == 'a' && arr[i] == 't'))
				{
					printf("2 : arr[popCharNumber] : %c , arr[i] : %c\n",arr[popCharNumber],arr[i]);
					visible[i] = 1;
					visible[popCharNumber] = 1;
					break;
				}
				else if(popCharNumber != -1 && (arr[popCharNumber] == 'g' && arr[i] == 'c'))
				{
					printf("3 : arr[popCharNumber] : %c , arr[i] : %c\n",arr[popCharNumber],arr[i]);
					visible[i] = 1;
					visible[popCharNumber] = 1;
					break;
				}
	
				popCharNumber = pop();
				printf("second popCharNumber %d\n",popCharNumber);

				
			}
			if((visible[i] == 0) && (i-1 >-1)){
				 push(i-1);
			}				 
		}else {
			printf("4 i : %d\n",i);
			push(i);
		}
		printf("5\n");
	}

	printf("6\n");

	for(i=0;i<length;i++)
	{
		if(visible[i] == 1){
			count++;
		}	
	}
	
	printf("%d\n", count);

	return 0;
}


void push(int i){
	printf("push stacnumber :%d\n", stackNumber);	
	stack[stackNumber] = i;
	stackNumber ++;
	
}
int pop(void){
		
	printf("pop stacnumber : %d\n", stackNumber);
	if(stackNumber == 0){
		return -1;
	}else{
		stackNumber --;		
		popValue = stack[stackNumber];
	}	
	return popValue;
}
