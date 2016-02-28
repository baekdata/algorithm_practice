#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Cow
{
public:
	// �迭 Ү index ��ȣ.
	size_t index;

	// �Ұ� �� �ִ� ����.
	unsigned long long see;

	/**
	 * �⺻ ������.
	 */
	Cow()
	{
	};

	/**
	* ������ from see and index.
	*
	* @param index ���� ū ���� �迭 Ү index ��ȣ.
	* @param see ���� ū �Ұ� �� �ִ� ����.
	*/
	Cow(size_t index, unsigned long long see)
	{
		this->index = index;
		this->see = see;
	};
};

int main()
{
	vector<int> heightArray;

	/////////////////////////////////////////
	// �ҵ��� Ű �迭 ����
	/////////////////////////////////////////
	size_t size;
	cin >> size;
	heightArray.assign(size, 0);

	for (size_t i = 0; i < heightArray.size(); i++)
		cin >> heightArray[i];

	/////////////////////////////////////////
	// �� ������ �Ҹ� �� �� �ֳ�
	/////////////////////////////////////////
	unsigned long long totalSee = 0;
	map<int, Cow> heightMap;

	// ������ �Ҵ� �̸� �����
	heightMap[heightArray.back()] = Cow(heightArray.size() - 1, 0);

	for (long i = heightArray.size() - 2; i >= 0; i--)
	{
		size_t index = (size_t)i;
		int height = heightArray[i];
		unsigned long long see = 0;

		///////////////////////////////////////////////
		// �ڽź��� ũ�ų� ���� �Ҹ� ã��
		///////////////////////////////////////////////
		map<int, Cow>::iterator it = heightMap.lower_bound(height);

		if (it != heightMap.end())
		{
			// �ڽź��� ���ų� Ȥ�� �� ū �Ұ� �����Ѵٸ�
			size_t greaterIndex = it->second.index;

			// �� ���̿� �׺��� �� ū �Ұ� ���� �� Ȯ���Ѵ�
			for (size_t j = i + 1; j < greaterIndex; j++)
				if (heightArray[j] >= heightArray[i])
				{
					greaterIndex = j;
					break;
				}
			
			// �� �ҿ� �ڽ� ���̿� �� ���� ����ŭ �� �� �ִ�.
			see = greaterIndex - index - 1;
		}
		else
		{
			// �ڽŰ� ���ų� �� ū �Ұ� �ƿ� ���ٸ�, 
			// ���� �Ұ� ���� ū ���̴�, ��� �� �� �ִ�.
			see = totalSee + 1;
		}

		heightMap[height] = Cow(index, see);
		totalSee += see;
	}
	cout << totalSee;

#ifdef _WIN32
	system("pause");
#endif
	return 0;
}