package samsungProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_3184_sheep {
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx= {0, 0, 1, -1};
	static int[] dy= {1, -1, 0, 0};
	static int n, m;
	static char[][] map;
	static boolean[][] check;
	static Queue<Point> q = new LinkedList<Point>();
	static int sumSheep;
	static int sumWolf;
	
	static int resultSheep;
	static int resultWolf;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		check = new boolean[n][m];

		for(int i=0; i<n; i++) {
			String input = sc.next(); // string은 next로 
			for(int j=0; j<m; j++) {
				map[i][j] = input.charAt(j); // char 저장 
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(check[i][j] == false && (map[i][j] == 'o' || map[i][j] == 'v')) {
					sumSheep = 0;
					sumWolf = 0;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(resultSheep+" "+resultWolf);
	}

	public static void bfs(int x, int y) {
		check[x][y] = true;
		q.add(new Point(x, y));
		if(map[x][y] == 'o') {
			sumSheep = sumSheep + 1;
		}else if(map[x][y] == 'v') {
			sumWolf = sumWolf + 1;
		}

		while(!q.isEmpty()) {
			Point p = q.remove();

			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

				if(check[nx][ny]) continue;

				if(map[nx][ny] == 'o') {
					sumSheep = sumSheep + 1;
				}

				if(map[nx][ny] == 'v') {
					sumWolf = sumWolf + 1;
				}

				if(map[nx][ny] != '#') {
					check[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		
		if(sumWolf>=sumSheep) {
			resultWolf += sumWolf;
		}else if(sumSheep>sumWolf) {
			resultSheep += sumSheep;
		}
	}
}





