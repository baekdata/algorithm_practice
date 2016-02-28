#include <iostream>
#include <vector>

using namespace std;

int main()
{
	vector<int> intArray;
	size_t size;

	cin >> size;
	intArray.reserve(size);

	for (size_t i = 0; i < size; i++)
	{
		int val = i + 1;
		size_t step;
		cin >> step;

		if (step == 0)
			intArray.push_back(val);
		else
			intArray.insert(intArray.begin() + i - step, val);
	}

	for (size_t i = 0; i < intArray.size(); i++)
		cout << intArray[i] << " ";

#ifdef _WIN32
	system("pause");
#endif
	return 0;
}