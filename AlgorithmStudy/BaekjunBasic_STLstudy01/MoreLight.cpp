#include<iostream>
#include<vector>
#pragma warning(disable:4996)
using namespace std; //약수가 홀수일 경우, 마지막 yes// 짝수면 no
void main(){ //Light, More Light // 트레이닝북 49번 // 정수론
	long long count = 0;
	while (scanf("%lld", &count) == 1){
		vector<int> ar(count, 0); //count만큼 0초기화
		int num = 0;
		for (int i = 1; i <= count; i++){
			if (count%i == 0) //약수
				num++;
		}
		if (num %2 != 0) //홀수
			printf("yes\n");
		else//짝수
			printf("no\n");
	}
}