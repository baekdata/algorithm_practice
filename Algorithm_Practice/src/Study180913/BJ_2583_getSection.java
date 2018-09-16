package Study180913;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * 진행 중
 * >>2개의 점으로 배열 체크하는 법
 * 영역 bfs
 * @author jongsubaek
 *
 */

public class BJ_2583_getSection { // 백준 영역구하기 
	static int[][] map;
	static int groupCount, n, m;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static boolean[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int kt=y1; kt<y2; kt++) { // 좌표로 값 세팅 시 이렇게 
				for(int j=x1; j<x2; j++) {
					map[kt][j] = 1;
				}
			}
		}
		sc.close();
		// 입력 종료 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j] && map[i][j] == 0) {
					groupCount++;
					bfs(i, j);
				}
			}
		}
		System.out.println(groupCount);
	}
	
	public static void bfs(int i, int j) {
		Queue<SecClass> q = new LinkedList<>();
		q.add(new SecClass(i, j));
		map[i][j] = groupCount;
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			SecClass seC = q.remove();
			int x = seC.x;
			int y = seC.y;
			
			for(int ix=0; ix<4; ix++) {
				int nx = x + dx[ix];
				int ny = y + dy[ix];
				
				if(nx>=0 && ny >=0 && nx<n && ny < m) { // 벽체크 
					if(!visit[nx][ny]) { //방문 안했을 경우 
						visit[nx][ny] = true;
						map[nx][ny] = groupCount;
						q.add(new SecClass(nx, ny));
					}
				}
			}
		}
	}
}

class SecClass{
	int x, y;
	
	public SecClass(int x, int y) {
		this.x = x;
		this.y = y;
	}
}