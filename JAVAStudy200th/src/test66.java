import java.util.Scanner;


public class test66 { // ��� 
	
		//%�� ������ �� �������� 0�̸� �� ����̴�. 10�� 5�� �������� �� �������� 0�̹Ƿ� 5�� 10�� ����� �ȴ�.
	
	public static void main(String args[]){
		
		int a=0;
		int b=0;
		
		Scanner input = new Scanner(System.in);
		b = input.nextInt();
		
		a= input.nextInt();
		
		if(b%a==0){
			System.out.println(b+"�� "+a+"�� ����Դϴ�.");
		}else{
			System.out.println(b+"�� "+a+"�� ����� �ƴմϴ�.");
		}
	}
}
