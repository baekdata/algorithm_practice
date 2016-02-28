package Algorithm;
import java.util.Scanner;
public class olym03 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cookie = 0;
		int num = 0;
		int money = 0;
		int result = 0;

		cookie = input.nextInt();
		num = input.nextInt();
		money = input.nextInt();
		input.close();
		
		if(cookie>=1&&cookie<=1000&&num>=1&&num<=1000&&money>=1&&money<=100000){
			if(money<cookie*num){
				result = cookie*num - money;
			}else{
				result = 0;
			}
			System.out.println(result);
		}else{
			System.out.println("숫자의 범위가 잘못 되었습니다.");
		}
	}
}
