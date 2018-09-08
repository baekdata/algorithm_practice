package Study180906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_2105_Dessert_ref { // 백준 디저트카페 // 참조 소스 
	static int[][] direction= { // 내가 할 방향들 이렇게 만들어두기.
			{1,1},
			{1,-1},
			{-1,-1},
			{-1,1}
	};
	static int n;
	static int[][] arr;
	static int max=-1;
	static boolean[] des = new boolean[101];
	static int startI;
	static int startJ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stzr;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=0;tc<tcNum;tc++) {

			n = Integer.parseInt(br.readLine().trim());
			arr = new int[n][n];
			for(int i=0;i<n;i++) {
				stzr = new StringTokenizer(br.readLine().trim());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(stzr.nextToken());
				}
			}//테스트 케이스 하나 입력 완료

			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					des[arr[i][j]]=true; // 방문체크가 아닌 배열로 값체크 
					startI = i;
					startJ = j;
					go(i,j,0,1);
					Arrays.fill(des, false); // 배열 값 체크 초기화 
				}
			}
			System.out.println("#"+(tc+1)+" "+max);
			max = -1;
		}
	}

	private static void go(int i, int j, int d, int cnt) {
		int newI, newJ;
		newI = i+direction[d][0]; // 시작하자마자 방향 전환 
		newJ = j+direction[d][1];

		if(newI==startI && newJ==startJ && d==3) { // 맞으면서 마지막 방향일 때 마무리 
			if(max<cnt) {
				max = cnt;  
			}
			return;
		}
		
		if(newI>=0 && newI<n && newJ>=0 && newJ<n) { // 벽체크 
			if(!des[arr[newI][newJ]]){ // 그 값이 있는지 체크 // 이방법이 좋음 contain은 for문임 
				des[arr[newI][newJ]]=true;
				
				if(d!=3) { 
					go(newI, newJ, d+1, cnt+1); // 방향 변환 
				}
				
				//백트래킹 
				go(newI, newJ, d, cnt+1); // 방향 그대로 
				des[arr[newI][newJ]]=false; // 여기 왔다는 건 위에 둘다 return 되었다는 의미 
			}
		}
		
	}
}