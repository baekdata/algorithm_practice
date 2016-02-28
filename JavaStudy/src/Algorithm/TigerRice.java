package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TigerRice {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int max = 0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ArrayList<Integer> br = new ArrayList<Integer>();
		
		for(int i=0; i<9; i++){
			ar.add(sc.nextInt());
		}
		br.addAll(ar);
		Collections.sort(br);
		Collections.reverse(br);
		max = br.get(0);
		
		System.out.println(max);
		
		for(int j=0; j<9; j++){
			if(ar.get(j)==max){
				System.out.println(j+1);
			}
		}
	}
}
