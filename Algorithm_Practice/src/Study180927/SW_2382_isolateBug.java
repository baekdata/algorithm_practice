package Study180927;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class SW_2382_isolateBug { // 삼성 모의고사 // 재밌는 문제.
	// bfs가 아니라 시뮬레이션. 제대로 생각해서 풀기 
	static int testcase, num, time, bug; // 테스트케이스, 맵 가로세로길이, 진행 할 시간, 미생물 군집의 수 
	static int[][] map;
	static int[] d1 = {0, -1}; // 상 
	static int[] d2 = {0, 1}; // 하 
	static int[] d3 = {-1, 0}; // 좌 
	static int[] d4 = {1, 0}; // 우 
	static int sum;
	static int sumX, sumY, sumCount, sumDir;
	static int[][] sumMap;
	static int[][] sumMapDir;

	static int tempSum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();

		for(int i=0; i<testcase; i++) {
			num = sc.nextInt();
			time = sc.nextInt();
			bug = sc.nextInt();
			tempSum = bug;
			map = new int[num][num];
			sumMap = new int[num][num];
			sumMapDir = new int[num][num];
			sum = 0; // 초기화 
			Queue<bugPoint> q = new LinkedList<>();

			//TODO 겉표면 -1로 세팅해두기 / 나머지는 0
			for(int j=0; j<num; j++) {
				for(int k=0; k<num; k++) {
					map[j][k] = 0;
					if(j==0 || k==0 || j==(bug-1) || k==(bug-1)) {
						map[j][k] = -1;
					}
					sumMap[j][k] = 0;
					sumMapDir[j][k] = 0;
				}
			}

			for(int j=0; j<bug; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int count = sc.nextInt();
				sumMap[x][y] = 1; // 군집 1개씩 존재 
				map[x][y] = count;
				q.add(new bugPoint(x, y, count, sc.nextInt(), 0)); // x, y, 미생물 수 
			}

			for(int t=0; t<time; t++) {
				for(int b=0; b<bug; b++) { // 벌레수만큼 돌린다. 군집 수만큼 
					bugPoint bP = q.remove();
					int x = bP.x;
					int y = bP.y;
					int count = bP.count;
					int dir = bP.dir;
					int depth = bP.depth;
					int nx=0, ny=0;

					switch(dir) {
					case 1:
						nx = x + d1[0];
						ny = y + d1[1];
						break;
					case 2:
						nx = x + d2[0];
						ny = y + d2[1];
						break;
					case 3:
						nx = x + d3[0];
						ny = y + d3[1];
						break;
					case 4:
						nx = x + d4[0];
						ny = y + d4[1];
						break;
					}

					if(nx>=0 && nx<num && ny>=0 && ny<num) { // 벽체크 
						map[x][y] = 0; // 기존 자리 초기화 

						if(map[nx][ny] == -1) { // 약품 선으로 올라갔을 경우 
							count = count/2;
							if(dir == 1) { // 방향 변환 
								dir = 2;
							}else if(dir == 2) {
								dir = 1;
							}else if(dir == 3) {
								dir = 4;
							}else if(dir == 4) {
								dir = 3;
							}
						}else if(map[nx][ny] > 0) {
							tempSum = tempSum - 1;
							sumMap[nx][ny] = sumMap[nx][ny] + 1;
							map[nx][ny] = map[nx][ny] + count;
						}
					}
				}
				bug = tempSum;
			}
		}
		sc.close();
	}
}

class bugPoint{
	int x;
	int y;
	int count;
	int dir;
	int depth;

	public bugPoint(int x, int y, int count, int dir, int depth) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.dir = dir;
		this.depth =depth;
	}
}