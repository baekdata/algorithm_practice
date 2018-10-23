package samsungProb;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14889_startLink{ // 스타트와 링크 // dfs 및 조합 문제  // 다시 풀어보기. (FAIL) 
	static int N; //전체 인원 
	static int[][] map; //능력치
	static boolean[] check;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(row[j-1]);
			}
		}
		dfs(1);
		System.out.println(ans);
	}

	static int cnt=0;
	static void dfs(int idx) {
		if(cnt == N/2) {
			int d = diff();
			if(ans>d) ans = d;
			return;
		}
		for(int i=idx; i<=N; i++) {
			check[i] = true;
			cnt++;
			dfs(i+1);
			check[i] = false;
			cnt--;
		}
	}

	static int diff() { //스타트와 링크팀의 능력치 차이 계산
		int startSum = 0;
		int linkSum = 0;
		for(int i=1; i<=N; i++) {
			if(check[i]) {
				for(int j=1; j<=N; j++) {
					if(check[j]) startSum += map[i][j];
				}
			}else {
				for(int j=1; j<=N; j++) {
					if(!check[j]) linkSum += map[i][j];
				}
			}
		}
		return Math.abs(startSum - linkSum);
	}
}