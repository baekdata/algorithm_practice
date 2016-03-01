#include<iostream>
#pragma warning(disable:4996)
#include<string>
//char s[111]; //string문자열

/*
int main(){
	// scanf리턴값 활용
	// 10개씩 끊어온다.
	while (scanf("%10s", s)==1){
		printf("%s\n", s);
	}
	return 0;
}
*/
/*
int main(){
	int a = 0, b = 0, c = 0;
	scanf("%d %*d %d", &a, &b, &c);
	printf("%d", a + b + c);
}

using namespace std;
int main(){
	string s;
	getline(cin, s);
	//getline은 string넘겨야함
	cout << s << "\n";//cout으로 출력
}


#include<iomanip>
using namespace std;
int main(){
	double f = 3.14232423423525;
	cout << setprecision(5) << f << '\n';
	// 소수점 지정
	// '\n'이런식으로 사용
}


#include<algorithm>
#include<vector>
#include<tuple>

using namespace std;

int main(){
	pair<int, int> p1;
	cout << p1.first << ' ' << p1.second << '\n';

	p1 = make_pair(10, 10);
	cout << p1.first << '\n';

	tuple<int, int, int> t1 = make_tuple(1, 2, 3);
	int x = get<0>(t1);
	int y = get<1>(t1);
	int z = get<2>(t1);

	cout << x << ' ' << y << ' ' << z << '\n';
	x = y = z = 0;
	cout << x << ' ' << y << ' ' << z << '\n';
	tie(x, y, z) = t1;
	cout << x << ' ' << y << ' ' << z << '\n';


		
}



#include<vector>
using namespace std;

int main(){
	vector<int> a = { 1, 2, 3, 4, 5 };
	a.push_back(10);
	int count = 0;
	
	for (auto &i : a){ // ranged based for
		cout << i << ' ';
	}
	cout << '\n';

	for (auto it = a.begin(); it != a.end(); ++it){
		cout << (it - a.begin()) << ' ' << *it << '\n';
	} // it-a.begin() // 인덱스
	  // *it // iterator는 참조이므로

	return 0;
}



*/

#include<list>
#include<algorithm>
#include<vector>
#include<functional> // greater포함
using namespace std;

void print(list <int> &l){
	int ab = l.size();

	for (auto it = l.begin(); it != l.end(); it++){
		printf("%d ", *it);
	}
} // C++ list는 직접 접근 안됨

int main(){
	list<int> l = { 2, 1, -5, 4, -3, 6, -7 };

	l.sort(); 
	print(l);

	l.sort(greater<int>());
	print(l);

	return 0;
}






















































