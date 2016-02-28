import java.util.Scanner;


public class test124 { // 최대공약수 구하기
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		if(a<b){
			int tmp =a;
			a = b;
			b = tmp;
		}
		
		while(a>b){
			a = a-b;
		}
		
		System.out.println("최대공약수 : "+a);
		
		
	}
	
}
