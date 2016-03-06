#include<iostream>
#include <vector>
#include <cstring>
#include <queue>
#define x first
#define y second // pair first, second 가독성 위해 변경
using namespace std;
typedef pair<int, int> point; // 2중배열처럼 만들어줌.
//매번 piar<int, int> 쓰기도 귀찮고, Point(a,b)로만 가능 // 클래스보다 안전하게 사용가능하고 연산자 오버로딩도 가능하고
// functional 헤더 안의 기능들과 연동되어 쓸 수 있어서 좋다.
char row[51][51];
int visited[51][51];
vector<point> startpoint;

int main(){ // 정올 // BFS활용 보물섬 문제 
	int R, C;
	cin >> R >> C;

	for (int i = 0; i < R; ++i){
		cin >> row[i]; // char 이차원배열
	} // 초기 맵 셋팅
	//for (int i = 0; i < R; i++){
	//	cout << row[i][0]<< endl;
	//}

	//L인 곳을 찾고 
	for (int i = 0; i < R; ++i){
		for (int j = 0; j < C; ++j){
			if (row[i][j] == 'L'){ // L인 곳 찾아서 값 input
				startpoint.push_back(point(i, j));
			}
		}
	}
	const int di[] = { -1, 0, 0, 1 }; // 방향
	const int dj[] = { 0, 1, -1, 0 };

	//L인곳을 하나씩 선택해서 이동해가면서 맵에 값 저장하고
	int n = startpoint.size();
	int maximum = 0;

	for (int i = 0; i < n; ++i){// 각 스타트 값을 하나씩 넣어가며 BFS진행
		memset(visited, -1, sizeof(visited)); // -1로 초기화
		point start = startpoint[i]; // 찾은 L값에 대해 모든 경우에 대해서 start해보기. 시작 값이 정해지지 않았으므로
		queue<point> q;
		q.push(start); // 방문할 node 큐에 삽입
		visited[start.x][start.y] = 0; // 방문했으므로 0 삽입

		while (!q.empty()){ // 큐가 비어있으면 탈출
			point here = q.front(); // 방문할 최초 노드의 값을 큐에서 꺼냄
			//cout << "here " << here.first << " " << here.second << " " << visited[here.first][here.second] << endl;
			q.pop();// 꺼냈기 때문에 pop

			for (int k = 0; k < 4; ++k){
				//there
				int ni = here.x + di[k];
				int nj = here.y + dj[k]; // 상하좌우 모두 확인
				char c = row[ni][nj];
				if (ni < 0 || ni >= R)continue; // 0보다 작거나 R,C범위 이탈 시 continue;
				if (nj < 0 || nj >= C)continue;
				if (c == 'L'&& visited[ni][nj] == -1){ // L이고, -1이라면 큐에 삽입
					visited[ni][nj] = visited[here.x][here.y] + 1; // 방문이 연속되면 +해줌.
					if (visited[ni][nj] > maximum) maximum = visited[ni][nj]; // 최대값 갱신
					q.push(point(ni, nj)); // 큐와 인접해 있는 노드들을 큐에 삽입
				}
			}
		}
	}
	cout << maximum << endl;
	return 0;
}