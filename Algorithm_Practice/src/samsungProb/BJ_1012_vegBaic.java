package samsungProb;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1012_vegBaic {
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, m;// 가로 세로 길이 
	static int instruction;
	static int[][] map;
	static boolean[][] check;
	static Queue<Point> q = new LinkedList<Point>();
	static int sum;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();  // 테스트 케이스 
		for(int i=0; i<inputN; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			sum = 0;
			instruction = sc.nextInt();
			map = new int[n][m]; // 맵 초기화 
			check = new boolean[n][m];
			
			for(int j=0; j<instruction; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1; // 배추 심어진 장소 
			}
			
			for(int s=0; s<n; s++) {
				for(int t=0; t<m; t++) {
					if(map[s][t] == 1 && !check[s][t]) {
						bfs(s, t);
					}
				}
			}
			System.out.println(sum);
		}
	}
	
	public static void bfs(int x, int y) {
		check[x][y] = true;
		q.add(new Point(x, y));
		sum = sum + 1;
		
		while(!q.isEmpty()) {
			Point p = q.remove();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny >=0 && nx<n && ny <m) { // 벽체크 
					if(check[nx][ny] == false && map[nx][ny] == 1) { //방문 안함  + 배추있음 
						check[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
}