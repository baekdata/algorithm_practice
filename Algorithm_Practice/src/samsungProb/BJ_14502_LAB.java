package samsungProb;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_14502_LAB { // 1015 월요일 : 삼성기출 - 연구소 BFS  (PASS 1회독)
	static class node{ // node point 클래스 
		int x, y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] a;
	static int[][] map;
	static int n, m;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		map = new int[n][m];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt(); // 초기 데이터 세팅 
			}
		}
		sc.close();
		//입력 완료//

		for(int i=0; i<n; i++) { // 0에 3곳에 벽 세우기 - 백트래킹 
			for(int j=0; j<m; j++) {
				if(a[i][j] == 1 || a[i][j] == 2) continue;
				recoveryMap();
				map[i][j] = 1;
				go(1);
				map[i][j] = 0;
			}
		}
		System.out.println(ans); // 출력 
	}

	static public void go(int cnt) {
		if(cnt == 3) { // 3개 세웠을 경우 바이러스 퍼뜨리기 
			bfs();
			return;
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 || map[i][j] == 2) continue;
				map[i][j] = 1;
				go(cnt+1);
				map[i][j] = 0;
			}
		}
	}

	static public void recoveryMap() { // 기존 데이터 세팅 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = a[i][j];
			}
		}
	}

	public static void bfs() {
		int[][] temp = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				temp[i][j] = map[i][j];

		Queue<node> q = new LinkedList<>();
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(temp[i][j]==2)
					q.add(new node(i,j));

		while(!q.isEmpty()) {
			node nd = q.remove();

			for(int i=0; i<4; i++) {
				int nx = nd.x + dx[i];
				int ny = nd.y + dy[i];

				if(nx>=0 && nx<n && ny>=0 && ny<m) { // 벽체크 
					if(temp[nx][ny] == 0) { // 빈 곳일 경우 	
						temp[nx][ny] = 2;
						q.add(new node(nx, ny));
					}
				}
			}
		}

		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j]==0) {
					cnt = cnt + 1;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
}