package Study180927;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_cell_1005 { // 스터디 줄기세포 배양 
	static int[][] map = new int[20][20];
	static int[][] mapCopy = new int[20][20];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static Queue<cellPoint> q = new LinkedList<cellPoint>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 가로 
		int m = sc.nextInt(); // 세로 
		int time = sc.nextInt(); // 시간 

		int nx = 20/2;
		int ny = 20/2; // 각 중간을 기준으로 잡음 >> 일단 테스트용 30 

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i+nx][j+ny] = sc.nextInt();
				mapCopy[i+nx][j+ny] = map[i+nx][j+ny];
			}
		}

		// print용 
		//		for(int i=0; i<20; i++) {
		//			for(int j=0; j<20; j++) {
		//				System.out.print(map[i][j]+" ");
		//			}
		//			System.out.println();
		//		}

		for(int t=0; t<2; t++) { // 2 시간 동안 
			checkMapPushQueue();

			//TODO 큐의 갯수만큼 돌리는게 필요 
			bfs();
		}

		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void bfs() {
			cellPoint cP = q.remove();
			int x = cP.x;
			int y = cP.y;
			int lt = cP.lifeTime;

			if(lt != 0) { // 아직 시간이 안된 놈 
				lt = lt - 1;
				q.add(new cellPoint(x, y, lt));
//				map[x][y] = lt;
			}else { // 큐에 넣었던 값의 lifeTime이 0이라면. 활성화된 상태임. 
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if(map[nx][ny] != -1 && mapCopy[nx][ny] != 0) {
						if(map[nx][ny] < mapCopy[nx][ny]) {
							map[nx][ny] = mapCopy[nx][ny];
						}
					}else if(map[nx][ny] != -1 && mapCopy[nx][ny] == 0) {
						map[nx][ny] = mapCopy[x][y];
					}
				}
				map[x][y] = -1;
			}
	}

	public static void checkMapPushQueue() {
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				if(map[i][j] != 0 && map[i][j] != -1) { // 0이 아닐 경우 맵에 넣는다. 
					q.add(new cellPoint(i, j, map[i][j])); // life 살아있음 
				}
			}
		}
	}
}

class cellPoint{ // 각 좌표 위치, 각 좌표의 생명 길이 
	int x, y, lifeTime;
	boolean life;

	public cellPoint(int x, int y, int lifeTime) {
		this.x = x;
		this.y = y;
		this.lifeTime = lifeTime;
	}
}