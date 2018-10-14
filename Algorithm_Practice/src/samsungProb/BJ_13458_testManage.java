package samsungProb;
import java.util.Scanner;

public class BJ_13458_testManage { // 1014 일요일 : 삼성기출 - 시험감독 (PASS - 1회독)
	static int[] peopleNum;
	static long sum; // sum 값은 integer 범위를 넘어설 수 있으므로 long으로 처리 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		peopleNum = new int[input];

		for(int i=0; i<input; i++) {
			peopleNum[i] = sc.nextInt();
		}
		int aTeacher = sc.nextInt();
		int bTeacher = sc.nextInt();
		sum += input;

		for(int i=0; i<input; i++) {
			peopleNum[i] = peopleNum[i] - aTeacher;
			if(peopleNum[i] > 0) { //이런 체크 중요 >> 0인경우 0을 나누게 되는 케이스가 존재 
				if(peopleNum[i]%bTeacher == 0) {
					sum+= peopleNum[i]/bTeacher;
				}else {
					sum+= peopleNum[i]/bTeacher + 1;
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}
}