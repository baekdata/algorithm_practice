import java.util.Scanner;


public class test124 { // �ִ����� ���ϱ�
	
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
		
		System.out.println("�ִ����� : "+a);
		
		
	}
	
}
