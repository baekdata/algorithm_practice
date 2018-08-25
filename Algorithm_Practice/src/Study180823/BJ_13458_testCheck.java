package Study180823;
import java.util.Scanner;

public class BJ_13458_testCheck { //백준, 시험감독. 시뮬레이션.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, acheck, bcheck; // 시험장 수, 총감독 가능 수, 부감독 가능 수.
		int[] array; // 응시생  
		boolean[] check;
		long result = 0; // 최종 결과, 범위 때문에 int말고 long으로
		num = sc.nextInt();
		array = new int[num];
		check = new boolean[num];

		for(int i=0; i<num; i++) { // 입력.
			array[i] = sc.nextInt();
		}
		acheck = sc.nextInt(); bcheck = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			array[i] = array[i] - acheck;
			if(array[i] > 0) {
				check[i] = true;
			}else {
				check[i] = false;
			}
		}
		
		for(int i=0; i<num; i++) {
			if(check[i]) {
				if((array[i] % bcheck) == 0) {
					result += array[i]/bcheck;
				}else {
					result += (array[i]/bcheck) + 1;
				}
			}
		}
		System.out.println(result + num);
	}
}