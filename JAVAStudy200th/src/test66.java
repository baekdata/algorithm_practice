import java.util.Scanner;


public class test66 { // 약수 
	
		//%로 나눴을 때 나머지가 0이면 즉 약수이다. 10을 5로 나누었을 때 나머지가 0이므로 5는 10의 약수가 된다.
	
	public static void main(String args[]){
		
		int a=0;
		int b=0;
		
		Scanner input = new Scanner(System.in);
		b = input.nextInt();
		
		a= input.nextInt();
		
		if(b%a==0){
			System.out.println(b+"는 "+a+"의 약수입니다.");
		}else{
			System.out.println(b+"는 "+a+"의 약수가 아닙니다.");
		}
	}
}
