package Study180913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1012_Vegitable { // 전형적인 bfs 문제  // PASS 
	static int testcase, n, m, bugCount;
	static int[][] map;
	static boolean[][] check;
	static Queue<VegPoint> q = new LinkedList<>();
	static int[] dx = {1, -1, 0, 0}; // 이렇게 하기. 변수 틀리는 케이스 많으니 주의 
	static int[] dy = {0, 0, 1, -1};
	static int groupCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();
		
		for(int i=0; i<testcase; i++) {
			n= sc.nextInt();
			m= sc.nextInt();
			bugCount = sc.nextInt();
			map = new int[n][m];
			check = new boolean[n][m];
			groupCount = 0;
			
			for(int k=0; k<bugCount; k++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[x][y] = 1;
			}
			
			for(int k=0; k<n; k++) {
				for(int w=0; w<m; w++) {
					if(map[k][w] == 1 && !check[k][w]) {
						bfs(k, w);
					}
				}
			}
			System.out.println(groupCount);
		}
		sc.close(); 
	}
	
	public static void bfs(int x, int y) {
		q.add(new VegPoint(x, y));
		check[x][y] = true;
		groupCount = groupCount + 1;
		
		while(!q.isEmpty()) {
			VegPoint vP = q.remove();
			int xx = vP.x;
			int yy = vP.y;
			
			for(int s=0; s<4; s++) {
				int nx = xx + dx[s];
				int ny = yy + dy[s];
				
				if(nx>=0 && ny>=0 && nx<n && ny <m) { // 벽체크 
					if(!check[nx][ny] && (map[nx][ny] == 1)) {
						check[nx][ny] = true;
						q.add(new VegPoint(nx, ny));
					}
				}
			}
		}
	}
}

class VegPoint{ // 좌표 클래스 
	int x, y;
	
	public VegPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}