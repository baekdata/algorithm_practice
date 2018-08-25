package Study180809;
import java.util.Scanner;

public class BJ_2156_Graph { // 다이나믹 프로그래밍 // DP문제 
	/**
	 * 참고 > limkydev.tistory.com/112
	 * 
	 * 3번은 안되므로 > 0, 1, 2번 연속 마실 수 있는 경우의 최대
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int p[] = new int[n+1]; //n번째 포도주의 양
		int dp[] = new int[n+1]; //포도주 n개가 주어졌을 때, 가장 많이 마실 수 있는 양
		
		for(int i=1; i<=n; i++) {
			p[i] = sc.nextInt();
		}
		
		dp[1] = p[1]; // dp[i-3]이 있으므로 dp[1], dp[2]는 초기화.   
		if(n>1) {
			dp[2] = p[1] + p[2];
		}
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+p[i], dp[i-3]+p[i-1]+p[i]));
		}
		System.out.println(dp[n]);
	}
}
