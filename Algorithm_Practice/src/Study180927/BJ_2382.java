package Study180927;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2382 { // sw 모의고사 미생물 격리 // 시뮬레이션 
	static int num, time, groupCount; // 배열 칸, 진행 시간, 군집의 수 
	static int[][] map; // 맵 > 각 x,y좌표에 count 저장 
	static int[][] map2; // 맵 > 각 x,y좌표에 count 저장 // 번갈아가면서 저장할 맵 
	static int[][] dir; // 방향 저장
	static Queue<bugGroup> q = new LinkedList<>();

	static int[] d1 = {0, -1}; // 상 
	static int[] d2 = {0, 1}; // 하 
	static int[] d3 = {-1, 0}; // 좌 
	static int[] d4 = {1, 0}; // 우 
	
	static int result;
	
	static boolean isTemp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		time = sc.nextInt();
		groupCount = sc.nextInt();

		//각 배열 초기화
		map = new int[num][num];
		map2 = new int[num][num];
		dir = new int[num][num];

		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				map[i][j] = 0; // map 초기화 
				map2[i][j] = 0; // 번갈아 사용할 맵 
				dir[i][j] = 0; 
			}
		}

		for(int i=0; i<groupCount; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt(); 
			map[x][y] = sc.nextInt();
			dir[x][y] = sc.nextInt(); 
			q.add(new bugGroup(x, y));
		}

		for(int i=0; i<1; i++) { 
			bfs(); // 이 때 다음 단계로 진행한다. 
			initQueue(); // 준비단계 
		}
		
		checkBugCount();
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void checkBugCount() {
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			bugGroup bG = q.remove();
			int x = bG.x;
			int y = bG.y;
			int nx=0, ny=0;
			
			switch(dir[x][y]) {
			case 1: // 상  >> 그려보면 안다. 
				nx = x - 1;
				ny = y;
				break;
			case 2: // 하 
				nx = x + 1;
				ny = y;
				break;
			case 3: // 좌 
				nx = x;
				ny = y - 1;
				break;
			case 4: // 우  
				nx = x;
				ny = y + 1;
				break;
			}
			System.out.println(dir[x][y]);
			
			if(nx >= 0 && nx < num && ny >= 0 && ny <num) { // 벽체크 
				//약품자리인지 체크 
				if(nx == 0 || ny == 0 || nx == (num-1) || ny == (num-1)) {
					map2[nx][ny] = map[x][y] / 2;
					if(dir[x][y] == 1) { // 방향 반대로 처리 
						dir[nx][ny] = 2;
					}else if(dir[x][y] == 2) {
						dir[nx][ny] = 1;
					}else if(dir[x][y] == 3) {
						dir[nx][ny] = 4;
					}else if(dir[x][y] == 4) {
						dir[nx][ny] = 3;
					}
				}else { // 약품자리 아닐 경우 
					if(map2[nx][ny] != 0) { // 해당 자리에 값이 있을 경우 
						if(map[x][y] > map2[nx][ny]) { // 미생물 수 큰 곳의 방향으로 진행 
							dir[nx][ny] = dir[x][y];
							map2[nx][ny] = map2[nx][ny] + map[x][y]; // 혹시 값이 있을 경우 합치는 것. 
						}
					}else {
						// 해당 자리에 값이 없을 경우 
						dir[nx][ny] = dir[x][y]; // 현재 방향 그대로 저장 
						map2[nx][ny] = map[x][y];
					}
					
				}
			}
		}
	}

	public static void initQueue() {
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(map2[i][j] > 0) {
					q.add(new bugGroup(i, j));
				}
			}
		}
		copyMap(); // map2를 map으로 옮기고 map2 clear 
	}
	
	public static void copyMap() {
		for(int i=0; i<num ;i++) {
			for(int j=0; j<num; j++) {
				map[i][j] = map2[i][j];
				map2[i][j] = 0;
			}
		}
	}
}

class bugGroup{
	int x, y;

	public bugGroup(int x, int y) {
		this.x = x;
		this.y = y;
	}
}