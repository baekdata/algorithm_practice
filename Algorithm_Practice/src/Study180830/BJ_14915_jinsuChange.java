package Study180830;
import java.util.Scanner;
public class BJ_14915_jinsuChange { // 재귀형태랑 while문 형태 2가지로 볼 수 있다.
	static int m;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		m = sc.nextInt();
		
		System.out.print(num+"의 2진수는 : ");
		binary(num);
	}
	
	public static void binary(int num){
		if((num/m)==0){
			System.out.print(1);
			return;
		}
		
//		binary(num/m);
		if(num%m>=10) {
			System.out.println("tt");
		}else {
			System.out.print(num%m);
		}
	}
}