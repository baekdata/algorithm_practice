#define TRUE 1
#define FALSE 0

#define QUE_LEN 100
typedef struct _Data
{
	int  value;
	int  length;
	int  x_cur;
	int  y_cur;
	int  use;

}Data;

typedef struct _cQueue
{
	int front;
	int rear;
	Data queArr[QUE_LEN];
}CQueue;


typedef CQueue Queue;

void QueueInit(Queue* pq);
int QIsEmpty(Queue* pq);
void Enqueue(Queue* pq, Data* data);
Data Dequeue(Queue* Pq);
Data QPeek(Queue* pq);
int NextPosIdx(int pos);
