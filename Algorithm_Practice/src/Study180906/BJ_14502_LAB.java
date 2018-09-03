package Study180906;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author jongsubaek
 *
 * 로직은 쉬웠고, 엄청 쉽게 구현할 줄 알았는데 배열 복사 값 처리가 미흡해서 오래 걸림.
 * 
 * 즉, 처음 받은 맵으로 벽을 3개씩 백트래킹으로 세워가며 3개 세웠을 때의 맵으로 안전구역 찾는 함수 호출.
 * 
 * >> 안전구역 찾는 경우 계속해서 바이러스 퍼트려가며 하므로, 여기서는 copymap에다가 map을 복사해서
 * 그 맵으로 처리해가기.
 *
 */

public class BJ_14502_LAB { // 기출 // 백준 - 연구소 // 3개만 두는거라 완탐 가능.
	static int n, m;
	static int[][] map, temp;
	static int[][] copyMap;
	static int max = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		temp = new int[n][m];
		copyMap = new int[n][m];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		} sc.close();

		dfs(0);//맵의 0 중에서 3곳에 1두기. >> 반복. // 모든 경우에 대해. >> dfs + check배열 활용해서 완탐 진행하기 
		System.out.println(max); // 출력 
	}

	public static void solve() {
		Queue<LabPoint> queue = new LinkedList<>();
		copyMap = deepCopy(map, n, m);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
//				temp[i][j] = map[i][j]; // 벽 3개 세워진 맵을 옮겨주기 >> 이런식으로 deepCopy안쓰고 처리 가능. 
				if(copyMap[i][j] == 2) { // copymap에서 map으로 변경 
					queue.add(new LabPoint(i, j));
				}
			}
		}

		while(!queue.isEmpty()) {
			LabPoint lp = queue.remove();
			for(int i=0; i<4; i++) {
				int nxx = dx[i] + lp.x;
				int nyy = dy[i] + lp.y;

				if(nxx < 0 || n <= nxx || nyy < 0 || m <= nyy) continue;

				if(copyMap[nxx][nyy] == 0) {
					copyMap[nxx][nyy] = 2;
					queue.add(new LabPoint(nxx, nyy));
				}
			}
		}
		checkCount();
	}

	public static void dfs(int depth) { // 벽 3개 세우기 
		if(depth == 3) {
			solve(); // 벽이 3개 세워질 때마다 함수 호출 
			return;
		}

		for(int i=0; i<n; i++) { 
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1);
					map[i][j] = 0; //백트래킹 
				}
			}
		}
	}

	public static void checkCount() { // zero의 수 체크 
		int zeroCount = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copyMap[i][j]==0) {
					zeroCount = zeroCount + 1;
				}
			}
		}
		if(max < zeroCount) {
			max = zeroCount;
		}
	}

	public static int[][] deepCopy(int[][] original, int n, int m) { // 값만 복사 - 2차원 배열 
		if (original == null) { // null체크 
			return null;
		}

		int[][] result = new int[n][m];
		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0, original[i].length);
		}
		return result;
	}
}

class LabPoint{ // lab의 좌표 
	int x, y;

	public LabPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}