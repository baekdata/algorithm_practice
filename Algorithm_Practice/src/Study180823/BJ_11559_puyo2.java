package Study180823;
import java.util.Scanner;

public class BJ_11559_puyo2 { // PASS 소스 // DFS, 뿌요뿌요 // recovery쪽 수정. 3중 for문 > 2중 for문. / 런타임 해결. 
	static boolean[][] check = new boolean[12][6];
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {1, 0, -1, 0};
	static char[][] array = new char[12][6];
	static final char[] COLOR = {'.', 'R', 'G', 'B', 'P', 'Y'}; // 컬러값 
	static int checkCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<12; i++) { // 12 * 6 배열 입력 
			String input = sc.next();
			for(int j=0; j<6; j++) {
				array[i][j] = input.charAt(j);
			}
		}
		sc.close();

		while(true) { 
			boolean next = false;
			check = new boolean[12][6]; // 여기서 초기화, 따로 false for문 필요없음 

			for(int i=0; i<12; i++) { // dfs 시작 
				for(int j=0; j<6; j++) {
					if(array[i][j] != COLOR[0] && !check[i][j]) { // .이 아닐 경우 
						if(dfs(i, j, array[i][j]) >= 4) {
							next = true;
							go();
						}
						clear();
					}
				}
			}

			if(next) {
				checkCount++;
				recoveryMap();
			}else {
				break;
			}
		}
		System.out.println(checkCount);
	}

	public static int dfs(int i, int j, char color) { // 좌표, 컬러값. 
		check[i][j] = true;
		int checkcheckCount = 1;

		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx>=0 && nx<12 && ny >=0 && ny<6 && !check[nx][ny] && color == array[nx][ny]) { // 벽 체크 
				checkcheckCount += dfs(nx, ny, array[nx][ny]);
			}
		}
		return checkcheckCount;
	}

	public static void go() { // recovery진행 
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(check[i][j]) {
					array[i][j] = '.';
				}
				check[i][j] = false;
			}
		}
	}

	public static void clear() { // 초기화 
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				check[i][j] = false;
			}
		}
	}

	public static void recoveryMap() {
		for(int i=10; i>=0; i--) {
			for(int j=5; j>=0; j--) {
				if(array[i][j] == '.') continue;

				int k = i;
				while(true) {
					if(k == 11 || array[k+1][j] != '.') break; //계속 체크 필요.
					array[k+1][j] = array[k][j];
					array[k][j] = '.';
					k++;
				}
			}
		}
	}
}

class puyoPointXY{ // 좌표값 
	int x;
	int y;

	puyoPointXY(int x, int y){
		this.x = x;
		this.y = y;
	}
}