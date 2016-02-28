package Algorithm;
import java.util.Scanner;
public class olymStair {// 계단오르기 // DP // 
	//반복적 동적 계획법을 이용 // 제대로 이해하기
	public static void main(String[] args){
		int[] a = new int[305];
		int[][] dp = new int[305][3];

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for(int i=1; i<=count; i++){
			a[i] = sc.nextInt();
		}// 입력

		dp[1][1]=dp[1][2]=a[1];
		for(int j=2; j<=count; j++){
			dp[j][1] = dp[j-1][2]+a[j];
			dp[j][2] = Math.max(dp[j-2][1], dp[j-2][2])+a[j];
		}
		System.out.println(Math.max(dp[count][1], dp[count][2]));
	}
}