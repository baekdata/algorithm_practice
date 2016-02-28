package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class olymBrainTrain {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		boolean flag = false;
		int count=0;
		int plus=0, minus=0, i=0;

		while(i<8&&count<=10000){
			if(!flag){
				minus=sc.nextInt();
				count-=minus;
				flag = true;
			}else{
				plus = sc.nextInt();
				count+=plus;
				flag = false;
			}
			if(i%2!=0){
				ar.add(count);
			}
			i++;
		}
		
		Collections.sort(ar);
		Collections.reverse(ar);
		System.out.println(ar.get(0));
		sc.close();
	}
}