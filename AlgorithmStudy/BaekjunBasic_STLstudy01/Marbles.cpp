#include<iostream>
#include<cstdio>
#pragma warning(disable:4996)
using namespace std;
void main(){ // Ʈ���̴׺�// 55�� // �ذ�// ���� testcase�� �����ϱ�
	int result = 0;
	int ar[2][2];

	scanf("%d", &result);
	for (int i = 0; i < 2; i++)
		scanf("%d %d", &ar[i][0], &ar[i][1]);

	int count = 0;
	int count2 = 1;
	int module = 0;
	while (true){
		if ((result - ar[1][1] * count2) % ar[0][1] == 0){ // �ִ��� �տ��� �ְ� ���
			module = result - count2*ar[1][1];
			count = module / ar[0][1];
			break;
		}count2++;
		if ((result - ar[0][1]) < count2*ar[1][1])
			break;
	}
	if (count == 0)
		printf("failed\n");
	else
		printf("%d %d\n", count, count2);
}