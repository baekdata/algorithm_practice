package Study180906;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_3197_lake { // 이렇게 범위 넓은 경우 시간초과 난다. 현재 풀었지만 시간초과 남. 백준것 보고 따로 푸는 연습 이따 하
	static int n, m, day;
	static String[][] map, temp;
	static boolean[][] check;
	static boolean tt = false;
	static boolean goNext;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		map = new String[n][m];
		temp = new String[n][m];
		check = new boolean[n][m];

		for(int i=0; i<n; i++) { // 입력 
			String input = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = input.charAt(j)+"";
			}
		}
		sc.close();
		
		clear();
		checkIce();
		goIce();
	}
	
	public static void clear() {
		goNext = false;
		tt = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				check[i][j] = false;
			}
		}
	}

	public static void goIce() {
		if(tt) {
			System.out.println(day);
		}else {
			clear();
			day = day + 1;
			meltIce();
			checkIce();
			goIce();
		}
	}

	public static void checkIce() {
		Queue<IcePoint> q = new LinkedList<>();
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j].equals("L") && !goNext) {
					q.add(new IcePoint(i,j));
					goNext = true;
				}
			}
		}

		while(!q.isEmpty()) {
			IcePoint ip = q.remove();
			int qx = ip.x;
			int qy = ip.y;
			check[qx][qy] = true;

			for(int k=0; k<4; k++) {
				int nx = qx + dx[k];
				int ny = qy + dy[k];

				if(nx<0 || nx>=n || ny<0 || ny>=m || check[nx][ny]) continue;
				
				if(map[nx][ny].equals("X")) continue;

				if(map[nx][ny].equals("L") && !check[nx][ny]) {
					tt = true;
					q.clear();
					break;
				}

				if(map[nx][ny].equals(".") && !check[nx][ny]) {
					q.add(new IcePoint(nx, ny));
				}
			}
		}
	}

	public static String[][] deepCopy(String[][] original, int n, int m) { // 값만 복사 - 2차원 배열 
		if (original == null) return null;

		String[][] result = new String[n][m];
		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0, original[i].length);
		} return result;
	}

	public static void meltIce() {
		temp = deepCopy(map, n, m); // 기존 맵 저장 필요 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j].equals("X")) { // 비교는 기존 맵으로 
					if((j-1 >= 0 && temp[i][j-1].equals(".")) || ((j+1)<m && temp[i][j+1].equals("."))) {
						map[i][j] = "."; // 변화는 현재 맵 
					}
				}
			}
		}
	}
}

class IcePoint{
	int x, y;

	public IcePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}