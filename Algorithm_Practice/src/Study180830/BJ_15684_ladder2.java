package Study180830;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_15684_ladder2 { // pass // 조합 + 시뮬레이션 + dfs 
	static int[][] map;
	static int n, h;
	static int ans = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로 선 
		int m = sc.nextInt(); // 현재 가로선의 갯수
		h = sc.nextInt(); // 세로선마다 가로선 넣을 수 있는 개수 
		
		map = new int[h + 1][n + 1];
		for (int i = 0; i < m; i++) {// 사다리 입력 
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = y + 1; // 사다리가 움직일 방향의 값을 넣어둠.
			map[x][y + 1] = y; // 위와 반대로 
		}
		
		if (checkLadder()) {
			ans = 0; // 사다리 필요없음 
		
		} else { // 사다리 필요있을 경우 
			for (int count = 1; count <= 3; count++) {// 사다리 갯수 1 ~ 3까지 가능 
				for (int i = 1; i <= h; i++) { // 가로 넣을 수 있는 수만큼 돌리기 
					for (int j = 1; j < n; j++) {// 세로로 체크해서 가로선 넣을 수 있는지 체크해가며 넣어야 함.
						if (map[i][j] == 0 && map[i][j+1] == 0) {
							List<PointLadder> point = new ArrayList<PointLadder>();
							point.add(new PointLadder(i, j));
							dfs(point, count);
						}
					}
				}
			}
		}
		sc.close();
		System.out.println(ans == 4 ? -1 : ans); // 출력 
	}

	static boolean checkLadder() {// 사다리 번호랑 결과 같은지 체크 같으면 true, 아니면 false 
		for (int start = 1; start <= n; start++) {
			int tmp = start;
			for (int i = 1; i <= h; i++) {// step to bottom
				if (map[i][tmp] > 0) {// move
					tmp = map[i][tmp]; // 사다리에 그 index를 넣었으므로 0이 아닐 경우 index에 대입 
				}
			}
			if (tmp != start) // 하나라도 틀리면 false 
				return false;
		}
		return true;
	}

	static void dfs(List<PointLadder> point, int count) {
		if (ans != 4)// 가지치기 - 초기값 4였으므로, 아니라면 return
			return;
		if (count == point.size()) {// 1~3
			for (int p = 0; p < point.size(); p++) {//lines will draw into map
				int x = point.get(p).i;
				int y = point.get(p).j;
				map[x][y] = y + 1;
				map[x][y + 1] = y;
			}
			if (checkLadder()) {// 가지치기 - 맞다면 바로 return 
				ans = point.size(); // 맞을 경우 현재 추가 사다리 갯수 리턴 
				return;
			}
			
			for (int p = 0; p < point.size(); p++) { // 바꿨던 맵 초기화 
				int x = point.get(p).i;
				int y = point.get(p).j;
				map[x][y] = 0;
				map[x][y + 1] = 0;
			}
			return;
		}
		
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j < n; j++) {// next point
				if (map[i][j] == 0 && map[i][j + 1] == 0) {// 사다리 놓을 수 있는 자리인지 체크 
					boolean flag = true;
					for (int p = 0; p < point.size(); p++) {//duplicate check
						if (point.get(p).i == i && point.get(p).j == j) {
							flag = false;
							break;
						}
					}
					if (flag) {
						point.add(new PointLadder(i, j));
						dfs(point, count);//recursive
						point.remove(point.size() - 1); // 백트래킹 
					}
				}
			}
		}
	}
}

class PointLadder { // 사다리 좌표 
	int i;
	int j;

	PointLadder(int i, int j) {
		this.i = i;
		this.j = j;
	}
}