package Study180927;

import java.util.HashSet;
import java.util.Scanner;

public class BJ_10815_numCard { // 백준 숫자카드 // set은 순서는 없고 체크 가능 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nA, nB;
		HashSet<Integer> arrayA;
		int[] arrayB;
		nA = sc.nextInt();
		arrayA = new HashSet<Integer>();

		for(int i=0; i<nA; i++) {
			arrayA.add(sc.nextInt());
		}
		nB = sc.nextInt();		
		arrayB = new int[nB];
		for(int i=0; i<nB; i++) {
			arrayB[i] = sc.nextInt();
		}
		sc.close();

		for(int i=0; i<nB; i++) {
			if(arrayA.contains(arrayB[i])){
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
		}
		System.out.println();
	}
}