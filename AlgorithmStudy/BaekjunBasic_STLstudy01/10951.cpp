//scanf�� ���ϰ��� ���������� �Է¹��� ������ ����.
#include<iostream>
#pragma warning(disable:4996)

int main(){
	int a = 0, b = 0;

	while (scanf("%d %d", &a, &b) == 2){
		//scanf�� ���ϰ��� ������ �μ��� ��
		printf("%d\n", a + b);
	}
	return 0;
}