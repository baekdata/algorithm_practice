package Study180913;

import java.util.Scanner;

public class BJ_primeNum {

	// 에라토스테네스 체 
	public static void main() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		if(isPrimeNum(input)) {
			System.out.println("소");
		}else {
			System.out.println("no");
		}
		
	}
	
	public static boolean isPrimeNum(int num) {
		for(int i=2; i*i <=num; i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
}
