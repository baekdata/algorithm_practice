package samsungProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_14502_LAB { // 1015 월요일 : 삼성기출 - 연구소 BFS 
	static class node{ // node point 클래스 
		int x, y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int[][] map2;
	static int n, m;
	static Queue<node> queue = new LinkedList<node>();
	static int areaCount; // 0의 갯수 (안전영역)
	static int maxCount = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		map2 = new int[n][m];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				map2[i][j] = map[i][j];
				if(map[i][j] == 2) {
					queue.add(new node(i, j));
				}
			}
		}
		sc.close();

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 || map[i][j] == 2) continue;
				recoveryMap();
				map[i][j] = 1;
				go(1);
				map[i][j] = 0;
			}
		}
		System.out.println(maxCount);
	}
	
	static public void go(int cnt) {
		if(cnt == 3) {
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
	
	static public void recoveryMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = map2[i][j];
			}
		}
	}

	static public void printZeroCount() {
		areaCount = 0; // 초기화 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					areaCount = areaCount + 1;
				}
			}
		}
		if(maxCount<areaCount) { // 최대값 구하기 
			maxCount = areaCount;
		}
	}

	public static void bfs() {
		while(!queue.isEmpty()) {
			node nd = queue.remove();

			for(int i=0; i<4; i++) {
				int nx = nd.x + dx[i];
				int ny = nd.y + dy[i];

				if(nx>=0 && nx<n && ny>=0 && ny<m) { // 벽체크 
					if(map[nx][ny] == 0) { // 빈 곳일 경우 	
						map[nx][ny] = 2;
						queue.add(new node(nx, ny));
					}
				}
			}
		}
		printZeroCount();
	}
}