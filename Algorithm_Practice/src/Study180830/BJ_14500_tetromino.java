<<<<<<< HEAD
package Study180830;
=======
<<<<<<< HEAD
package Study180830;
=======
package Study0830;
>>>>>>> branch 'master' of https://github.com/baekdata/algorithm_practice.git
>>>>>>> branch 'master' of https://github.com/baekdata/algorithm_practice.git
import java.io.IOException;
import java.util.Scanner;
public class BJ_14500_tetromino { //PASS  DFS + 예외케이스 처리 / brute force가능. // dfs처리 시 백트래킹 처리 필수 
	//이런건 일일이 다 하드코딩이 더 빠를 순 있음. 
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	static int[][] map;
	static boolean[][] check;
	static int max = Integer.MIN_VALUE;
	static int n, m, result;

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		map = new int[n][m];
		check = new boolean[n][m];

		for(int i=0; i<n; i++) { // 입력 
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(sc.next());
				check[i][j] = false;
			}
		}
		sc.close();

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(i, j, 0);
				result = 0;
				dfs_other(i, j); // dfs로 처리 안되는 부분 
			}
		}
		System.out.println(max);
	}

	public static void dfs(int i, int j, int depth) {
		if(depth == 4) {
			if(result > max) {
				max = result;
			}
			return; // 4개 도착 시 가지치기 
		}
		check[i][j] = true;
		result += map[i][j];

		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if((nx>=0) && (ny>=0) && (nx<n) && (ny<m) && !check[nx][ny]) {
				dfs(nx, ny, depth+1);
			}
		}

		//백트래킹 
		check[i][j] = false;
		result -= map[i][j];
	}
	
	public static void dfs_other(int i, int j) {
		if(i>=0 && i+1<n && j+2 <m && j>=0) { //예외케이스 체크(dfs로 안되는) map 가로/아래  
			int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
			if(max < temp) max = temp;
		}
		
		if(i>=0 && i+1 < n && j>=0 && j+2 < m) { //map 가로 위 
			int temp = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
			if(max < temp) max = temp;
		}
			
		if(i>=0 && i+2<n && j>=0 && j+1<m) { // 예외케이스 체크(dfs로 안되는) map 세로/쪽 
			int temp = map[i+1][j] + map[i][j+1] + map[i+1][j+1]+ map[i+2][j+1];
			if(max < temp) max = temp;
		}
		
		if(i>=0 && i+2 <n && j>=0 && j+1 <m) { // 세로/오른쪽  
			int temp = map[i+1][j+1] + map[i][j] + map[i+1][j] + map[i+2][j]; 
			if(max < temp) max = temp;
		}
	}
}