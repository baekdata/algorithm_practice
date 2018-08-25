package Study180823;

import java.util.Scanner;

public class BJ_4014_hwaljuro2 { // dfs문제, 일단 가로부터 제대로 만들기 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int k=0; k<testcase; k++) {
			int n = sc.nextInt(); // map 크기
			int m = sc.nextInt(); // 활주로 가로 길이
			int map[][] = new int[n][n];
			int result = 0;
			int maxValue = -1;

			int[] x = new int[n]; // 가로.
			int[] y = new int[n];  // 세로.
			int[] count = new int[n];

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
					if(maxValue < map[i][j]) {
						maxValue = map[i][j];
						x[i] = maxValue;
					}
				}
			}
		}
	}
}