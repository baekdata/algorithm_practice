package Algorithm;

import java.util.Scanner;

public class BackTrackingTest01 { // 1182번 문제 // 부분집합의 합
	// 백트래킹 기본 예제
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		String[] input = sc.next().split(" ");

		System.out.println(input.length);
		for(int i=0; i<input.length; i++){
			System.out.println(input[i]);
		}


	}

}
