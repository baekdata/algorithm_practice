//scanf의 리턴값은 성공적으로 입력받은 인자의 개수.
#include<iostream>
#pragma warning(disable:4996)

int main(){
	int a = 0, b = 0;

	while (scanf("%d %d", &a, &b) == 2){
		//scanf의 리턴값은 성공한 인수의 수
		printf("%d\n", a + b);
	}
	return 0;
}