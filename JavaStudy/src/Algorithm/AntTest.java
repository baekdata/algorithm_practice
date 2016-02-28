package Algorithm;

import java.util.Scanner;

public class AntTest { // 개미수열, 일단 10까지
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		String name = "";
		int count =1; 
		String example = "1";
		int tmp =0;
		String result = "";
		Boolean flag = false;

		for(int i=0; i<a; i++){
			int num = example.charAt(i) - '0'; // 숫자 변환
			if(flag){
				result = (num+""); // length 활용
				flag = true;
			}
			while(count < example.length()){
				count++;
			}
//			example="";
			result += ""+count;

			example += result;
			System.out.print(example);
			System.out.println();
		}
		//		String b = example + ""; // 1
		//		
		//		for(int i=0; i<a; i++){
		//			tmp = b.charAt(i);
		//			for(int j=0; j<tmp; j++){
		//				count++;
		//			}
		//			name = name + count;
		//		}
		//		System.out.println(name);
	}
}
