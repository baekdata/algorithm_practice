package Study180823;
import java.util.Scanner;
public class BJ_1904_01tile { // 피보나치 규칙. dp문제. 규칙 찾기.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] d = new int[1000001]; // 범위 1000,000까지
		int n = sc.nextInt();
		d[0] = 0; d[1] = 1; d[2] = 2; // 초기화.

		for(int i=3; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] = d[i] % 15746; // 나머지 저장. 범위 때문에 여기서 나누기.
		}
		System.out.println(d[n]);
	}
}