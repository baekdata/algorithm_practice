#include<iostream>
#pragma warning(disable:4996)
using namespace std; // �� �ȿ� string����
	char s[111]; // 

int main(){
	//�� �� �� �ڿ� ���� �����ϰ� ����.
	//�� �� �Է� ���� �� ����.
	// ���� �����ϴ� ��� ���� �����ϰ� ����
	while (scanf("%[^\n]", s)==1){
		printf("%s\n", s);
	}
	return 0;
}