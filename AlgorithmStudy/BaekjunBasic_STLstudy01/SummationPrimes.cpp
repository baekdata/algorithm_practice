#include <iostream>  
#pragma warning(disable:4996)
using namespace std;  // å�� �޸�, � �Ҽ��� 4���� �ϸ� �Ǵ� ����
int isPrime(int x) { // �Ҽ� ���� // �Ҽ� �� ���� ��// Ʈ���̴� �� 53��
	int s = sqrt(x);
	for (int i=2; i <=s; i++){ //������ �̿��ؼ� �Ҽ����ϱ�
		if (x%i == 0) // �ξ� ���� ����.
			return 0;
	}return 1;
}
void calPrime(int x, int &a, int &b) {
	for(int i=2; i<=x/2; i++){ 
		if(isPrime(i) && isPrime(x-i)){
			a = i; //������ �� �Ҽ� 2���� ã��
			b = x-i; // greedy��� ���
			return;
		}
	} 
}
void main(){
	int n, numA=0, numB=0;
	while(scanf("%d", &n) == 1){
		if(n <= 7){// 4���� �Ұ� 2+2+2+2 = 8
			cout<<"Impossible."<<endl;
		}else if(n%2==1){ //Ȧ��
			calPrime(n-5, numA, numB);
			cout <<"2 3 "<<numA<<" "<<numB<<"\n";
		}else{ // ¦��
			calPrime(n-4, numA, numB);
			cout<<"2 2 "<<numA<<" "<<numB<<"\n";
		}
	}
}