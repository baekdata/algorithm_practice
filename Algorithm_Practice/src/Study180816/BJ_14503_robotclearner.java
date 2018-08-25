package Study180816;
import java.util.Scanner;

public class BJ_14503_robotclearner { //로봇청소기. 
	//dp or dfs활용(전형적인 dfs문제) - 시뮬레이션. //dfs문제인데, sw문제 기출, 까다로움
	static int map[][]; // 지도
	static int x, y, go, n, m; // 로봇좌표, 방향, 맵 크
	static int result = 1; // 청소한 장소 수(처음 초기장소는 했으므로 1)
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		x = sc.nextInt();
		y = sc.nextInt();
		go = sc.nextInt();

		for(int i=0; i<n; i++) { //map 세팅.
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		map[x][y] = -1; // 처음 위치는 청소함. 청소한 경우 -1처리.
		dfs(x, y, go);
		System.out.println(result);
	}

	public static void dfs(int x, int y, int go) {
		int nx, ny;
		int ngo = go; // 기존방향 세팅.
		for(int i=0; i<4; i++) {
			ngo = (ngo+3)%4; // 왼쪽방향으로 돌아가면서 gogo값 변경.(방향값 변경).
			nx = x+dx[ngo];
			ny = y+dy[ngo];
			if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==0) { // 방문없고, 벽 아닌 경우.
				result++;
				map[nx][ny]=-1;
				dfs(nx, ny, ngo);
				return;
			}else {
				continue;
			}
		}

		//4곳 중 방문할 곳 없을 경우
		ngo = (go+2)%4; // 기존 방향에서 후진
		nx = x+dx[ngo];
		ny = y+dy[ngo];

		if(map[nx][ny] == 1) {//후진이 벽일 경우 - 벽은 1.
			return;
		}else {
			dfs(nx, ny, go); // 벽이 아닐 경우, 현재위치와 기존 방향으로 호출.
		}
	}
}