package Algorithm;

import java.util.Scanner;

public class lowmulti {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = a*b;
		while(a!=b){
			if(a>b){
				a-=b;
			}else if(b>a){
				b-=a;
			}
		}
		System.out.println("�ִ� ����� :" + a);
		
		System.out.println("�ּҰ���� : "+sum/a);
	}
}
