package Study180816;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_4014_hwaljuro { // dfs문제, 일단 가로부터 제대로 만들
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
			System.out.println(maxValue);

			//가로 테스트
			for(int i=0; i<n; i++) {
				int countN = 1;
				int max = -1;
				ArrayList<Integer> checkArray = new ArrayList<>();
				
				boolean isCheck = false;
				for(int j=0; j<n; j++) {
					if(j <= n-2 && map[i][j] == map[i][j+1]) {
						countN++;
					}else {
						checkArray.add(countN);
						countN = 1;
					}
//					if(max < countN) {
//						max = countN;
//					}
					
					for(int e=0; e<x[i]; e++) {
						if(map[i][j] == (e+1)) {
							count[e] = count[e] + 1;
						}
					}
					
				}
				
				Arrays.sort(count);

				for(int s=0; s<checkArray.size(); s++) {
					if(checkArray.get(s)>=m && (count[0]>=m || count[0]==0)) {
						result++;
					}
				}
				
//				if((countA >= m || countA == 0) && (countB >= m) && ) {
//					result++;
//				}
				max = -1;
			}

			//세로 테스
//			for(int j=0; j<n; j++) {
//				int countN = 1;
//				int max = -1;
//				int countA = 0;
//				int countB = 0;
//				int countC = 0;
//				for(int i=0; i<n; i++) {
//					if(i <= n-2 && map[i][j] == map[i+1][j]) {
//						countN++;
//					}else {
//						countN = 1;
//					}
//					if(max < countN) {
//						max = countN;
//					}
//					
//					if(map[i][j] == 1) {
//						countA++;
//					}else if(map[i][j] == 2) {
//						countB++;
//					}else {
//						countC++;
//					}
//				}
//				if((countA >= m || countA == 0) && (countB >= m) && max >= m) {
//					result++;
//				}
//				max = -1;
//				countA=0;
//				countB=0;
//				countC=0;
//			}
			System.out.println("#"+(k+1)+" "+result);
		}
	}
}