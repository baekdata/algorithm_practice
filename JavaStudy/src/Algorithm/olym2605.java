package Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class olym2605 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		ArrayList<Integer> AL = new ArrayList<Integer>();

		//		for(int i=0; i<count; i++){
		//			AL.add(sc.nextInt());
		//		}

		for(int i=1; i<=count; i++){
			int k = sc.nextInt();
			if(k!=0){
				AL.add(i-k-1,i);
			}else{
				AL.add(i);
			}
		}
		for(int i=0; i<AL.size(); i++){
			System.out.print(AL.get(i)+" ");
		}
	}
}
