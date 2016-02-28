package Algorithm;

import java.util.Scanner;

public class olymmultiplex {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int sum = a*b*c;
		
		String result = sum+"";
		char[] as = new char[result.length()];
		int[] bs = new int[10];
		
		for(int i=0; i<result.length(); i++){
			as[i]=result.charAt(i);
		}
		
		for(int j=0; j<result.length(); j++){
			bs[(int)((as[j])-'0')] = bs[(int)((as[j]-'0'))]+1;
		}
		for(int k=0; k<10; k++){
			System.out.println(bs[k]);
		}
	}

}
