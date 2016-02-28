package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class olym200601 { // 2006 น้มุ ศฆผ๖
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int sum=0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for(int i=0; i<7; i++){
			int j = sc.nextInt();
			if(j%2!=0){
				ar.add(j);
			}
		}
		Collections.sort(ar);
		for(int k=0; k<ar.size(); k++){
			sum+=ar.get(k);
		}
		System.out.println(sum);
		System.out.println(ar.get(0));
	}
}