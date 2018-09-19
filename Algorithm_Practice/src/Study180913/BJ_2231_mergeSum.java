package Study180913;
import java.util.Scanner;
public class BJ_2231_mergeSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		//		String numString = num+"";
		//		int size = numString.length();

		// ex 19
		calc(num);
	}

	public static void calc(int num) {
		int sum = 0;	
		int n = 0;
		boolean isOk = false;
		for(int i=1; i<=1000000; i++) {
			sum = i;
			n = i;
			while(n!=0) {
				sum += n%10;
				n = n/10;
			}
			
			if(sum == num) {
				System.out.println(i);
				n=0;
				isOk = true;
				break;
			}
		}
		if(!isOk) {
			System.out.println(0);
		}
	}
}