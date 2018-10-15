package samsungProb;

import java.util.Scanner;
public class BJ_14501_out { // 1014 일요일 : 삼성기출 (PASS - 1회독) 
	static int date[]; // 상담 걸리는 기간 
	static int dayLong[]; // 각 날짜에 받을 수 있는 금액 
	static int n; // 남은 날짜 
	static int maxBenefit = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		date = new int[n]; 
		dayLong = new int[n];

		for(int i=0; i<n; i++) {
			date[i] = sc.nextInt();
			dayLong[i] = sc.nextInt();
		}
		sc.close();
		dfs(0, 0); // 0 ~ n-1 / benefit total 
		System.out.println(maxBenefit);
	}

	//dfs를 통해 모든 경우의 수 체크하고 max값 비교. index안맞으면 다음 dfs로 이동 
	public static void dfs(int index, int benefit) { // 현재 위치, 현재 누적 benefit 
		if(index >= n) { //index가 범위 벗어나는 경
			if(benefit>maxBenefit) {
				maxBenefit = benefit; // 최대값 체크 
			}
			return;
		}

		if((index+date[index]) <= n) { // index날짜에 상담할 경우, 범위 체크 후 다음 재귀 
			dfs(index+date[index], benefit+dayLong[index]);
		}
		if((index+1) <= n) { // index날짜에 상담하지 않을 경우, 범위 체크 후 다음날 재귀 
			dfs(index+1, benefit);
		}
	}
}