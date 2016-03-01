#include<iostream>
#pragma warning(disable:4996)

int main(){
	int n = 0;
	scanf("%d", &n);
	int sum = 0;

	for (int i = 0; i < n; i++){
		int x = 0;
		scanf("%1d", &x); // 1개씩 뽑아온다.
		sum += x;
	}
	printf("%d\n", sum);
	
	return 0;
}