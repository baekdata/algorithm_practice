package Study180927;

import java.util.Scanner;

/**
 * 
 *1. 맵을 만든다.
 *2. 군집을 다음 위치로 이동하고 이동한 위치에 +1
 *3. 맵을 처음부터 끝까지 검사하면서 값이 2이상일 경우군집 병함.
 *3-1. 병합할 군집을 모두 찾아서 최값 가진 군집을 계산.
 *3-2. 해당 군집에 미생물 수 더해주고, 최대가 아닌 다른 군집은 0으로 체크.
 * @author jongsubaek
 *
 */

public class BJ_2382_ref { // sw 모의고사 미생물 격리 참고 답안 
	static int[][] map;
	static int time, num, mapSize;
	static int[][] group;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int i=1; i<=testCase; i++) { // testcase만큼 돌리기 
			mapSize = sc.nextInt();
			time = sc.nextInt();
			num = sc.nextInt();
			
			group = new int[num][5];
			for(int j=0; j<num; j++) { // 클래스 만들지 말고 배열로 받았음 
				group[j][0] = 1;
				group[j][1] = sc.nextInt();
				group[j][2] = sc.nextInt();
				group[j][3] = sc.nextInt();
				group[j][4] = sc.nextInt();
			}
			
			for(int j=0; j<time; j++) { // 시간만큼 이동 
				move();
			}
			
			int result = 0;
			for(int j=0; j<num; j++) {
				if(group[j][0] == 1) {
					result+= group[j][3];
				}
			}
			
			System.out.println("#"+i+" "+result);
		}
		sc.close();
	}
	
	static void move() { // 이동 
		map = new int[mapSize][mapSize];
		
		for(int i=0; i<num ; i++) {
			if(group[i][0] == 1) {
				int nowY = group[i][1];
				int nowX = group[i][2];
				int nowDirection = group[i][4];
				
				switch(nowDirection) {
				//상
				case 1:
					nowY-=1;
					if(nowY==0) {
						group[i][3]/=2;
						group[i][4]=2;
					}
					break;
					
				case 2:
					nowY+=1;
					if(nowY== mapSize-1) {
						group[i][3] /=2;
						group[i][4] =1;
					}
					break;
					
				case 3:
					nowX-=1;
					if(nowX==0) {
						group[i][3]/=2;
						group[i][4]=4;
					}
					break;
					
				case 4:
					nowX+=1;
					if(nowX == mapSize-1) {
						group[i][3]/=2;
						group[i][4]=3;
					}
					break;
				}
				
				map[nowY][nowX] += 1;
				group[i][1] = nowY;
				group[i][2] = nowX;
			}
		}
		
		for(int i=0; i<mapSize; i++) {
			for(int j=0; j<mapSize; j++) {
				int value = map[i][j];
				if(value >1) {
					int[]values= new int[value];
					
					int now =0;
					int max = -1;
					
					for(int k=0; k<num; k++) {
						if(group[k][0] == 1 && group[k][1] == i && group[k][2] == j) {
							values[now] =k;
							now += 1;
							if(max == -1) {
								max = k;
							}else if(group[max][3] < group[k][3]) {
								max = k;
							}
						}
					}
					
					for(int k=0; k<value; k++) {
						int nowValue = values[k];
						if(nowValue != max && group[nowValue][0] == 1) {
							group[nowValue][0] = 0;
							group[max][3] += group[nowValue][3];
						}
					}
				}
			}
		}
	}
	
	static void showVaues() {
		for(int i=0; i<num; i++) {
			System.out.println((i+1)+":");
			
			for(int j=0; j<5; j++) {
				System.out.print(group[i][j]+ "");
			}
			System.out.println();
		}
		System.out.println();
	}
}
