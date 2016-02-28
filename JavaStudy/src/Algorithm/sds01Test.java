package Algorithm;

import java.util.Scanner;

public class sds01Test {
	public static void main(String[] args){
//		Scanner inputString = new Scanner(System.in);
//		String input = inputString.nextLine();
		String input = "1122431224";
		int length = input.length();
		boolean flag = false;
		int []a = new int[100];
		int t=0, s = 0;
		int temp =0;

		for(int i=0; i<length-1; i++){
			flag = false;
			for(int j=i+1; j<length; j++){
				flag = false;
				if(input.charAt(i)==input.charAt(j)){
					if(a[i]!=0){
						temp = a[i];
						a[i]=0;
					}
					a[i]+=1;
					t = i; s = j;
					while(!flag&&t<(length)&&s<(length)){
						if(input.charAt(++t)==input.charAt(++s)){
							a[i]+=1;
						}else{
							flag = true;
							if(temp!=0){
								if(temp>a[i]){
									a[i]=temp;
								}
								temp = 0;
							}
						}
					}
				}
			}
		}
		int moment = a[0];
		for(int w=0; w<length; w++){
			System.out.print(a[w]+" ");
		}
		System.out.println();
		
		for(int e=1; e<length; e++){
			if(moment<a[e]){
				moment = a[e];
			}
		}
		System.out.println("가장 긴 문자열의 길이는 : "+moment+"입니다.");
	}
}