<<<<<<< HEAD
package Study180830;
import java.util.Scanner;

public class BJ_15864_ladder { //false // 사다리조작, brute force // 삼성기출문제 
	//TODO n, m, k값을 잘 비교해서 인지해서 다시 풀어보기.
	// 로직은 사다리 잇고, dfs로 1,2,3개 가능한 만큼 계속 dfs돌려서 맞을때까지 진행.
	
	//52%에서 틀림 //
	
	static int[][] map;
	static int n, m, k;
	static int[] result;
	static boolean isPass;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); 
		k = sc.nextInt(); map = new int[k+1][n+1];
		result = new int[n+1];

		for(int i=1; i<=k; i++) { // 사다리 index 맞게 하려고 1부터 n, m까지 // 0제외 
			for(int j=1; j<=n; j++) {
				map[i][j] = 0;
			}
		}

		for(int i=0; i<m; i++) {
			int temp = sc.nextInt();
			int temp2 = sc.nextInt();
			map[temp][temp2] = 1;
			map[temp][temp2+1] = 2;
		}

		checkLadder(); //사다리 체크.
		checkResult(); //결과값 출력 여부 체크. 
		
		if(isPass) {
			//TODO 최소 사다리 조작 갯수 출력
			System.out.println(0);
		}else {
//			System.out.println("사다리 조작 다시");
			
			for(int s=1; s<=3; s++) {
				dfs(1, 0, s); // depth 0, 사다리 1~3개로 체크 가능.
				if(isPass) {
					break;
				}
			}
			
			if(!isPass) {
				System.out.println("-1");
			}
//			checkLadder();
		}
	}
	
	public static void checkLadder() {
		for(int j=1; j<=n; j++) { // 0번, 1번, 2번 >>세로줄 진행. 
			int x = j;
			for(int i=1; i<=k; i++) { // 가로줄 진행. 
				if(map[i][x] == 1) { // 사다리 오른쪽 
					if(x+1 <= k) {
						x = x+1;
					}
				}else if(map[i][x] == 2) { // 사다리 왼쪽 
					if(x-1>=1) {
						x = x-1;
					}
				}

				if(i == (k)) { // 값 대입 
					result[j] = x;
				}
			}
		}
	}
	
	public static void checkResult() {
		for(int i=1; i<=n; i++) {
			if((i) == result[i]) {
				isPass = true;
			}else {
				isPass = false;
				break;
			}
		}
	}
	
	public static void dfs(int row, int depth, int index) {
		if(index == depth) {
			checkLadder();
			checkResult();
			
			if(isPass) {
				System.out.println(index+"");
			}
			return;
		}
		
		for(int s=row; s<=k; s++) {
			for(int t=1; t<n; t++) {
				if(map[s][t]==0) {
					if(t-1 < 0 || t+1 > n) continue;
					if(map[s][t-1] == 1) continue;
					if(map[s][t+1] == 1) continue;
					
					map[s][t] = 1;
					map[s][t+1] = 2;
					
					dfs(s, depth+1, index); 
					if(isPass) return;
					
					map[s][t] = 0; // 백트래킹 
					map[s][t+1] = 0;
=======
package Study0830;
import java.util.Scanner;

public class BJ_15864_ladder { //false // 사다리조작, brute force // 삼성기출문제 
	//TODO n, m, k값을 잘 비교해서 인지해서 다시 풀어보기.
	// 로직은 사다리 잇고, dfs로 1,2,3개 가능한 만큼 계속 dfs돌려서 맞을때까지 진행.
	
	static int[][] map;
	static int n, m, k;
	static int[] result;
	static boolean isPass;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); 
		k = sc.nextInt(); map = new int[k+1][n+1];
		result = new int[n+1];

		for(int i=1; i<=k; i++) { // 사다리 index 맞게 하려고 1부터 n, m까지 // 0제외 
			for(int j=1; j<=n; j++) {
				map[i][j] = 0;
			}
		}

		for(int i=0; i<m; i++) {
			int temp = sc.nextInt();
			int temp2 = sc.nextInt();
			map[temp][temp2] = 1;
			map[temp][temp2+1] = 2;
		}

		checkLadder(); //사다리 체크.
		checkResult(); //결과값 출력 여부 체크. 
		
		if(isPass) {
			//TODO 최소 사다리 조작 갯수 출력
			System.out.println(0);
		}else {
//			System.out.println("사다리 조작 다시");
			
			for(int s=1; s<=3; s++) {
				dfs(0, s); // depth 0, 사다리 1~3개로 체크 가능.
			}
			
			if(!isPass) {
				System.out.println(-1);
			}
//			checkLadder();
		}
	}
	
	public static void checkLadder() {
		for(int j=1; j<=n; j++) { // 0번, 1번, 2번 >>세로줄 진행. 
			int x = j;
			for(int i=1; i<=k; i++) { // 가로줄 진행. 
				if(map[i][x] == 1) { // 사다리 오른쪽 
					x = x+1;
				}else if(map[i][x] == 2) { // 사다리 왼쪽 
					x = x-1;
				}

				if(i == (k-1)) { // 값 대입 
					result[j-1] = x;
				}
			}
		}
	}
	
	public static void checkResult() {
		for(int i=0; i<n; i++) {
			if((i+1) == result[i]) {
				isPass = true;
			}else {
				isPass = false;
				break;
			}
		}
	}
	
	public static void dfs(int depth, int index) {
		if(index == depth) {
			checkLadder();
			checkResult();
			
			if(isPass) {
				System.out.println(index);
			}
			return;
		}
		
		for(int s=1; s<=n; s++) {
			for(int t=1; t<=k; t++) {
				if(map[t][s]==0) {
					if(s-1 < 0 || s+1 > n) continue;
					if(map[t][s-1] == 1) continue;
					if(map[t][s+1] == 1) continue;
					
					map[t][s] = 1;
					map[t][s+1] = 2;
					
					dfs(depth+1, index); 
					if(isPass) return;
					
					map[t][s] = 0; // 백트래킹 
					map[t][s+1] = 0;
>>>>>>> branch 'master' of https://github.com/baekdata/algorithm_practice.git
				}
			}
		}
	}
}