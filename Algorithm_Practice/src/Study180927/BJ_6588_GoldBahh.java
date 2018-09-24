package Study180927;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_6588_GoldBahh { // 골든바흐 시간초과 
	
	// 어떤 값에서 소수를 뺐을 때 소수면 그것도 소수.
	// 에스트로의체의 배열을 활용하기 
	static boolean[] map; // 체크 배
	static int[] check;
	static int count, sum;
	static ArrayList<Integer> resultArray = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			resultArray.clear();
			count=0; sum =0;
			
			int input = sc.nextInt();
			if(input == 0) {
				break;
			}
			map = new boolean[input+1];
			check = new int[input+1];

			map[1] = false;
			for(int i=2; i<=input; i++) {
				if(isPrime(i)) {
					map[i] = true;
					check[count++] = i;
				}else {
					map[i] = false;
				}
			}

			for(int i=1; i<=input; i++) {
				if(map[input-check[i]]) {
					sum += check[i];
					resultArray.add(check[i]);
					resultArray.add(input-check[i]);
					sum += (input-check[i]);
					break;
				}
			}
			System.out.println(sum +" = "+resultArray.get(0)+" + "+resultArray.get(1));
		}
		sc.close();
	}

	public static boolean isPrime(int n) {
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}