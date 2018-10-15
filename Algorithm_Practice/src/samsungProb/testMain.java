package samsungProb;

import java.util.Scanner;

public class testMain {
	static int num;
	static int[] day;
	static int[] score;
	static int MAX_VALUE = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		day = new int[num];
		score = new int[num];
		
		for(int i=0; i<num; i++) {
			day[i] = sc.nextInt();
			score[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		sc.close();
		System.out.println(MAX_VALUE);
	}
	
	static public void dfs(int index, int value) {
		if(index>=num) { // 현재 index가 기준보다 크거나 같을 경우 
			if(value>MAX_VALUE) {
				MAX_VALUE = value;
			}
			return;
		}
		
		if(index + day[index] <= num) { // 현재 index 
			dfs(index+day[index], value+score[index]);
			//값은 값 넘기고 
		}
		
		if(index+1 <= num) {
			dfs(index+1, value);
		}
	}

}
