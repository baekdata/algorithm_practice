#include<iostream> // cstdio를 포함
#pragma warning(disable:4996)
using namespace std;

int main(){
	int a = 0;
	scanf("%i", &a); //%i를 사용하면, 진수에 상관없이 정수를 변환해준다.
	printf("%i\n", a);

	return 0;
}