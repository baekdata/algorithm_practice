#include <iostream>  
#pragma warning(disable:4996)
using namespace std;  // 책과 달리, 어떤 소수든 4개만 하면 되는 것임
int isPrime(int x) { // 소수 판정 // 소수 네 개의 합// 트레이닝 북 53번
	int s = sqrt(x);
	for (int i=2; i <=s; i++){ //제곱근 이용해서 소수구하기
		if (x%i == 0) // 훨씬 성능 좋다.
			return 0;
	}return 1;
}
void calPrime(int x, int &a, int &b) {
	for(int i=2; i<=x/2; i++){ 
		if(isPrime(i) && isPrime(x-i)){
			a = i; //나머지 중 소수 2가지 찾기
			b = x-i; // greedy방식 비슷
			return;
		}
	} 
}
void main(){
	int n, numA=0, numB=0;
	while(scanf("%d", &n) == 1){
		if(n <= 7){// 4개로 불가 2+2+2+2 = 8
			cout<<"Impossible."<<endl;
		}else if(n%2==1){ //홀수
			calPrime(n-5, numA, numB);
			cout <<"2 3 "<<numA<<" "<<numB<<"\n";
		}else{ // 짝수
			calPrime(n-4, numA, numB);
			cout<<"2 2 "<<numA<<" "<<numB<<"\n";
		}
	}
}