package samsungProb;
import java.util.Scanner;

public class BJ_14503_robotCleaner { // 1015 월요일 : 삼성기출 - 로봇청소기  (통과 1회독)
	static class Node{ // 좌표, 방향 클래스 
		int x, y, dir;
		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static int n, m;
	static boolean[][] check;
	static int count; // 청소기로 청소한 공간의 수 
	
	// 시뮬레이션 + dfs
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, dir;
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		check = new boolean[n][m];
		
		x = sc.nextInt();
		y = sc.nextInt();
		dir = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		/////////////입력부 완료//////////////
		
		dfs(x, y, dir);
		System.out.println(count);
	}
	
	public static void dfs(int x, int y, int dir) {
		//일단 현재 점 체크.
		if(map[x][y] == 0 && check[x][y] == false) {
			check[x][y] = true;
			count = count + 1;
		}
		
		int newDir = dir;
		boolean isState = true;
		while(true) {
			// 왼쪽으로 방향 한칸씩 바꾸는 로직 
			if(newDir != 0) {
				newDir = newDir - 1;
			}else {
				newDir = 3;
			}
			
			int newX = x + dx[newDir];
			int newY = y + dy[newDir];
			
			if(newX>=0 && newX<n && newY>=0 && newY<m && map[newX][newY]==0 && !check[newX][newY]) {
				dfs(newX, newY, newDir);
				break;
			}else {
				if(newDir == dir) {
					isState = false;
					break;
				}
			}
		}
		
		if(isState == false) { // 방향 다 돌아서 후진 필요 
			if(dir == 2 || dir == 3) {
				int nx = x + dx[dir-2];
				int ny = y + dy[dir-2];
				if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny] == 0) { // 갔던 곳도 벽만 아니면 후진 
					dfs(nx, ny, dir);
				}else {
					return;
				}
				
			}else if(dir == 1 || dir == 0) { //후진 및 진행 
				int nx = x + dx[dir+2];
				int ny = y + dy[dir+2];
				if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny] == 0) { // 갔던 곳도 벽만 아니면 후진 
					dfs(nx, ny, dir);
				}else {
					return;
				}
			}
		}
	}
}