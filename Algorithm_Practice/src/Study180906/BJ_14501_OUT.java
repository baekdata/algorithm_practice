package Study180906;
import java.util.Scanner;

public class BJ_14501_OUT { // 백준 퇴사 문제 // dp 문제 // 백준 소스 및 강의 참고 
	static int[] d = new int[200];
	static int[] t = new int[20];
	static int[] p = new int[20];
	static int n;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i=0; i<n; i++) {
			if (d[i+1] < d[i]) {
				d[i+1] = d[i];
			}
			if (d[i+t[i]] < d[i]+p[i]) {
				d[i+t[i]] = d[i]+p[i];
			}
		}
		System.out.println(d[n]);
	}
}
