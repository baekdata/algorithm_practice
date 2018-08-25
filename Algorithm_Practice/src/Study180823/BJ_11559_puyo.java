package Study180823;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11559_puyo { // BFS, DFS, 시뮬레이션. http://mygumi.tistory.com/267 참고. dfs, bfs 구분 확실히.
	static boolean[][] check = new boolean[12][6];
	static Queue<puyoPointXXX> q = new LinkedList<puyoPointXXX>();
	static ArrayList<puyoPointXXX> puyo = new ArrayList<>();
	static int checkCount;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	static char[][] array = new char[12][6];
	static int recoveryCount;
	static ArrayList<Character> recoveryColor = new ArrayList<>();
	static boolean isGo = false;
	static final char[] COLOR = {'.', 'R', 'G', 'B', 'P', 'Y'}; // 컬러값 
	static int result = 0; // 결과값. 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i=0; i<12; i++) { // 12 * 6 배열 입력 
			String input = sc.next();
			for(int j=0; j<6; j++) {
				array[i][j] = input.charAt(j);
			}
		}
		sol(); // 시작. 
	}

	// 중력에 의해 아래 내려가도록 처리 
	public static void recovery() {
		for(int i=11; i>=0; i--) {
			if(Math.abs(i-12) <= recoveryColor.size()) {
				array[i][recoveryCount] = recoveryColor.get(Math.abs(i-11));
			}else {
				array[i][recoveryCount] = '.'; // 초기화 
			}
		}
	}
	
	public static void sol() {
		for(int i=0; i<12; i++) { // bfs 시작 
			for(int j=0; j<6; j++) {
				if(array[i][j] != COLOR[0] && !check[i][j]) { // .이 아닐 경우 
					checkCount = 1; // 초기화.
					puyo.clear();
					bfs(i, j, array[i][j]);
				}
			}
		}

		for(int i=10; i>=0; i--) { // 12 * 6 배열.
			for(int j=0; j<6; j++) {
				if(array[i][j] != '.' && array[i+1][j] == '.') {
					// for문으로 array[i][j], array[i-1][j] ... '.'가 아니면서 i-1이 0보다 클때까지 array[i][j]값을 저장.
					// 이 2값으로 세팅.
					recoveryCount = j; // 해당 열값 저장 
					recoveryColor.add(array[i][j]); // 해당 칼라값 저장 
					int k = i-1;
					while(array[k][j] != '.' && k > 0) {
						recoveryColor.add(array[k][j]); // 다음 칼라값 있을 경우 다 저장 
						k = k-1;
					}

					//recovery 실행
					recovery();

					//초기화.
					recoveryCount = 0;
					recoveryColor.clear();
				}
			}
		}

		for(int i=0; i<12; i++) { // 12 * 6 배열.
			for(int j=0; j<6; j++) {
				// 체크 초기화.
				check[i][j] = false;
			}
		}
		
		if(isGo) { // isGo면 한번 터졌다는 의미. 
			result = result + 1;
			isGo = false;
			sol();
		}else {
			System.out.println(result);
		}
	}

	public static void bfs(int i, int j, char color) { // 좌표, 컬러값. 
		q.add(new puyoPointXXX(i,j));
		puyo.add(new puyoPointXXX(i, j));
		check[i][j] = true;

		if(checkCount>=4) { //일단 여기 걸리면 좌표 다 0으로 세팅 - 4개 이상 뿌요 터지는 곳 
			isGo = true;
			for(int t=0; t<puyo.size(); t++) { 
				array[puyo.get(t).x][puyo.get(t).y] = '.'; // 터진 블럭 .으로 세팅 
			}
		}

		while(!q.isEmpty()) {
			puyoPointXXX p = q.remove();
			int x = p.x;
			int y = p.y;

			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(nx>=0 && nx<12 && ny >=0 && ny<6 && !check[nx][ny] && color == array[nx][ny]) {
					checkCount = checkCount + 1;
					bfs(nx, ny, array[nx][ny]);
				}
			}
		}
	}
}

class puyoPoint{
	int x;
	int y;

	puyoPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
}