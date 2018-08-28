<<<<<<< HEAD
package Study180830;
=======
<<<<<<< HEAD
package Study180830;
=======
package Study0830;
>>>>>>> branch 'master' of https://github.com/baekdata/algorithm_practice.git
>>>>>>> branch 'master' of https://github.com/baekdata/algorithm_practice.git
import java.util.Scanner;

public class BJ_14499_dice { // PASS, 시뮬레이션,  주사위 굴리기
	static int n, m, x, y, answer;
	static int[][] map;
	static int[] answerList;
	static int[] dice = new int[7]; // index 유지 위해. 1~6 / index 0은 무시 
	static int[] diceCopy = new int[7]; // 주사위 index // copy

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		x = sc.nextInt(); y = sc.nextInt();
		answer = sc.nextInt();
		map = new int[n][m];
		answerList = new int[answer];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for(int i=0; i<answer; i++) {
			answerList[i] = sc.nextInt();
		}
		sc.close();

		for(int i=0; i<answer; i++) {
			dice(answerList[i]); // 주사위 굴리기 
		}
	}

	public static void dice(int an) { //주사위 모양 생각해서 고
		if(an == 1) { //동쪽 
			y = y+1;
			dice[1] = diceCopy[5]; dice[3] = diceCopy[6];
			dice[5] = diceCopy[3]; dice[6] = diceCopy[1];
		}else if(an == 2) { //서쪽 
			y = y-1;
			dice[5] = diceCopy[1]; dice[6] = diceCopy[3];
			dice[3] = diceCopy[5]; dice[1] = diceCopy[6];
		}else if(an == 3) {//북쪽 
			x = x-1;
			dice[1] = diceCopy[4]; dice[2] = diceCopy[1];
			dice[3] = diceCopy[2]; dice[4] = diceCopy[3];
		}else if(an == 4) {//남쪽 
			x = x+1;
			dice[4] = diceCopy[1]; dice[1] = diceCopy[2];
		    dice[2] = diceCopy[3]; dice[3] = diceCopy[4];
		}

		if(x>=0 && x<n && y>=0 && y<m) { // 범위 벽체크 
			for(int i=1; i<7; i++) { // 변화된 값 그대로 백업 
				diceCopy[i] = dice[i];
			}
			if(map[x][y] == 0) { // 이동 시 바닥이 0이면 
				map[x][y] = dice[3]; //바닥값 = 주사위바닥값 
			}else { // 이동 후 바닥이 0이 아니면 
				diceCopy[3] = map[x][y]; // 주사위 = 바닥칸 값
				dice[3] = map[x][y]; // 주사위 = 바닥칸 값
				map[x][y] = 0; // 바닥 0
			}
			System.out.println(dice[1]); // 윗면 출력 
		}else {
			for(int i=1; i<7; i++) { // 원복 
				dice[i] = diceCopy[i];
			}
			if(an == 1) { // 원복 초기화 
				y = y-1;
			}else if(an == 2) {
				y = y+1;
			}else if(an == 3) {
				x = x+1;
			}else if(an == 4) {
				x = x-1;
			}
		}
	}
}