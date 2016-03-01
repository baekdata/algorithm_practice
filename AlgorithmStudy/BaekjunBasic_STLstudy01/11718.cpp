#include<iostream>
#pragma warning(disable:4996)
using namespace std; // 이 안에 string포함
	char s[111]; // 

int main(){
	//각 줄 앞 뒤에 공백 무시하고 받음.
	//빈 줄 입력 받을 수 없음.
	// 공백 시작하는 경우 공백 무시하고 받음
	while (scanf("%[^\n]", s)==1){
		printf("%s\n", s);
	}
	return 0;
}