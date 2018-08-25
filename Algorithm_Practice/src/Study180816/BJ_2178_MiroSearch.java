package Study180816;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178_MiroSearch {
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int MIN = 100000;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n+1][m+1];

		Queue<PointXY> q = new LinkedList<PointXY>();
		for(int i=1; i<n+1; i++) {
			String input = sc.next();
			for(int j=1; j<m+1; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j-1)); // char to integer
			}
		}
		check = new boolean[n+1][m+1];
		q.add(new PointXY(1, 1, 1));
		check[1][1] = true;
		
		while(!q.isEmpty()) {
			PointXY newp = q.remove();
			int x = newp.x;
			int y = newp.y;
			int len = newp.len;

			if(x == n && y == m) {
				if(len < MIN) MIN = len; 
				break;
			}

			for(int i=0; i<4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				int nlen = len + 1;
				if(nx >= 1 && nx <=n && ny >= 1 && ny <= m && map[nx][ny] == 1 && !check[nx][ny]) {
					q.add(new PointXY(nx, ny, nlen));
					check[nx][ny] = true;
				}
			}
		}
		System.out.println(MIN);
	}
}

class PointXY{
	int x;
	int y;
	int len;

	PointXY(int x, int y, int len){
		this.x = x;
		this.y = y;
		this.len = len;
	}
}