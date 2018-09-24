package Study180927;

import java.util.Scanner;

public class BJ_GCD_LCD_2609 {
	/**
	 * GCD > 최대공약수, 유클리드
	 * LCD > 최소공배수, 두 수 곱한 후 / 최대공약수로 나누기
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputA = sc.nextInt();
		int inputB = sc.nextInt();
		
		int result = gcd(inputA, inputB);
		System.out.println(result);
		System.out.println((inputA * inputB)/result);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
}
