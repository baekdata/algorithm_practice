#include<iostream>
#include<vector>
#pragma warning(disable:4996)
using namespace std; //����� Ȧ���� ���, ������ yes// ¦���� no
void main(){ //Light, More Light // Ʈ���̴׺� 49�� // ������
	long long count = 0;
	while (scanf("%lld", &count) == 1){
		vector<int> ar(count, 0); //count��ŭ 0�ʱ�ȭ
		int num = 0;
		for (int i = 1; i <= count; i++){
			if (count%i == 0) //���
				num++;
		}
		if (num %2 != 0) //Ȧ��
			printf("yes\n");
		else//¦��
			printf("no\n");
	}
}