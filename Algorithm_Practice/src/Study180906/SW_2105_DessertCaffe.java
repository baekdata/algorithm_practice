package Study180906;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_2105_DessertCaffe { // 삼성 기출 // 스터디 1시간 반 
	static int testcase, num; // 테스트케이스, 맵 숫자 
	static int max = Integer.MIN_VALUE; // 최대값 찾기 위한 숫자 
	static int[][] map; // 지도 
	static boolean[][] check; // 방문여부 체크 
	static boolean isPass; // max값 유무 체크 
	static ArrayList<DessertClass> arrayList = new ArrayList<>();
	static ArrayList<Integer> sortCheck = new ArrayList<>();

	static boolean successdPass; // 연속 체크 

	static int startX, startY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();

		for(int i=0; i<testcase; i++) {
			num = sc.nextInt();
			map = new int[num][num];
			check = new boolean[num][num];
			isPass = false;
			arrayList.clear();
			sortCheck.clear();

			for(int j=0; j<num; j++) {
				for(int k=0; k<num; k++) {
					check[j][k] = false;
				}
			}	

			startX = 0; startY = 0;
			max = Integer.MIN_VALUE;

			// 값 초기화 및 세팅 

			for(int j=0; j<num; j++) {
				for(int k=0; k<num; k++) {
					map[j][k] = sc.nextInt();
				}
			}

			//TODO 출발 점 제대로 해보기 
			for(int j=0; j<num; j++) {
				for(int k=0; k<num; k++) {
					if((j-1>=0) && (j+1 <num) && (k+2<num) && (k>=0)){	
						arrayList.add(new DessertClass(j, k, 1)); // 가능성 있는 출발점 넣기 
					}
				}
			}			

			for(int s=0; s<arrayList.size(); s++) {
				int x = arrayList.get(s).x;
				int y = arrayList.get(s).y;
				int go = arrayList.get(s).go;

				startX = x; // start 좌표 및 go배열 초기화 
				startY = y;
				sortCheck.clear();
				successdPass = false;

				for(int j=0; j<num; j++) {
					for(int k=0; k<num; k++) {
						check[j][k] = false;
					}
				}		

				if((x+1)<num && (y+1) < num && (map[x][y] != map[x+1][y+1])) {
					dfs(x, y, go);
				}
			}

			if(isPass) { // max값 찾았을 경우 
				System.out.println("#"+(i+1)+" "+max);
			}else {
				System.out.println("#"+(i+1)+" -1");
			}
		}
		sc.close();
	}

	public static void dfs(int x, int y, int go) { // dfs, 대각선 타고가기 
		//탈출 부 > check 하기 전에 startX, startY랑 같으면 isPass = true 해주기 
		if(go>4) { // 방향이 초과할 경우 탈출 조건 
			isPass = false;
			return;
		}

		int nx = x;
		int ny = y;
		check[x][y] = true; // 방문 체크 
		if(!(sortCheck.contains(map[x][y]))) {
			sortCheck.add(map[x][y]); // 해당 종류 넣기 
		}

		switch(go) { // 4가지 방향 체크 
		case 1:
			nx = nx + 1;
			ny = ny + 1;
			break;
		case 2:
			nx = nx - 1;
			ny = ny + 1;
			break;
		case 3:
			nx = nx - 1;
			ny = ny - 1;
			break;
		case 4:
			nx = nx + 1;
			ny = ny - 1;
			break;
		}

		if((nx == startX) && (ny == startY)) {
			isPass = true; // 회귀 했을 경우

			if(max<sortCheck.size()) {
				max = sortCheck.size();
			}
			return; // 끝났으므로 탈출 
		}
		
		if(go == 4) {
			return;
		}

		//TODO go랑 go+1이 1개 차이어야 함. 

		if(nx >= 0 && ny >= 0 && nx < num && ny < num) { // 벽 넘어가면 탈출 
			if(!check[nx][ny]) { // 방문 안했어야 함. 
				if(!sortCheck.contains(map[nx][ny])) { // 종류 체크 필요 // 기존에 없던 종류일 경우
					dfs(nx, ny, go); // 기존 방향 그대로 
					successdPass = false;
				}else {
					if(successdPass) {
						isPass = false;
						return;
					}else {
						check[x][y] = false;
						sortCheck.remove(sortCheck.size()-1);
						dfs(x, y, go+1); // 조건 넘어갈 경우 기존 좌표, 다른방향 해보기 
						successdPass = true;
					}
				}
			}else {
				if(successdPass) {
					isPass = false;
					return;
				}else {
					check[x][y] = false;
					sortCheck.remove(sortCheck.size()-1);
					dfs(x, y, go+1); // 조건 넘어갈 경우 기존 좌표, 다른방향 해보기 
					successdPass = true;
				}
			}
		}else {
			if(successdPass) {
				isPass = false;
				return;
			}else {
				check[x][y] = false;
				sortCheck.remove(sortCheck.size()-1);
				dfs(x, y, go+1); // 조건 넘어갈 경우 기존 좌표, 다른방향 해보기 
				successdPass = true;
			}
		}
	}
}

class DessertClass{ // 각 좌표 + 방향 (방향 1,2,3,4 순서 - 오른아래, 왼 아래, 왼 위 , 오른 위)
	int x, y, go;

	public DessertClass(int x, int y, int go) {
		this.x = x;
		this.y = y;
		this.go = go;
	}
}