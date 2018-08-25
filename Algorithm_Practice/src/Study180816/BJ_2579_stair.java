package Study180816;
import java.util.Scanner;

public class BJ_2579_stair { // 계단오르기, DP문제. //뒤에서부터 체크하는 것이 수월하다. 
	public static void main(String[] args){ // http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220788947949 참고.
		int[] stair = new int[301]; // 300개 이하의 계단.
		int[][] dp = new int[301][2]; 
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt(); // 계단 갯수.

		for(int i=1; i<=count; i++){
			stair[i] = sc.nextInt();
		}
		
		//초기화.
		dp[1][0]=dp[1][1]= stair[1];
		//dp[i][0] - 1칸 전에서 올라 온 최대 점수
		//dp[i][1] - 2칸 전에서 올라 온 최대 점수 
		//3칸 연속을 방지하고자 2차원배열 사용.

		for(int j=2; j<=count; j++){
			dp[j][0] = dp[j-1][1]+ stair[j]; // 1칸 전이므로 3칸 방지하려면, 임시계단까지 2칸 전만 가능.
			dp[j][1] = Math.max(dp[j-2][0], dp[j-2][1])+stair[j]; // 3칸 체크 필요없음, 임시계단까지 2칸 or 1칸 어떤게 큰지만 체크.
		}
		System.out.println(Math.max(dp[count][0], dp[count][1]));
	}
}