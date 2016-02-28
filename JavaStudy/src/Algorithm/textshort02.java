package Algorithm;

import java.util.Scanner;

public class textshort02 { // ≈ÿΩ∫∆Æ complress
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		String str;
		str = keyboard.nextLine()+ " ";
		int count =1;
		char s;
		String Final = "";
		
		for(int i=0; i<str.length()-1; i++){
			s = str.charAt(i);
			if(s == str.charAt(i+1)){
				count++;
			}else{
				Final = Final + s + count;
				count = 1;
			}
		}
		System.out.println(Final);
	}
}
