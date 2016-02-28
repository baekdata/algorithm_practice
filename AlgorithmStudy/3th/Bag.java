/*
 *  값어치/무게 값을 나타내는 새로운 배열 추가.
 *  이 새로운 배열을 정리함.
 *  큰 값부터 보석을 가방에 최대한 넣음.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bag {

	public static void main(String[] args) {
		int N, W;
		int Count=0;
		
		Scanner scan =new Scanner(System.in);
		N=scan.nextInt();
		W=scan.nextInt();
		
		List <Integer> WeidivideArr = new <Integer> ArrayList();
		List <Integer> WeiArr = new <Integer> ArrayList();
		
		int[][] Mat = new int[N][2];
		for(int i=0; i<N; i++){
			for(int j=0; j<2; j++){
				Mat[i][j]=scan.nextInt();
			}
		}
		
		for(int i=0; i<N;i++){
			WeidivideArr.add(Mat[i][1]/Mat[i][0]);
		}
		int temp;
		int temp1;
		for(int i=0; i<N-1;i++){
			for(int j=i+1; j<N;j++){
				if(WeidivideArr.get(i)>WeidivideArr.get(j)){
					temp =WeidivideArr.get(i);
					WeidivideArr.set(i, WeidivideArr.get(j));
					WeidivideArr.set(j,temp);
					temp=Mat[i][0];
					temp1=Mat[i][1];
					Mat[i][0]=Mat[j][0];
					Mat[i][1]=Mat[j][1];
					Mat[j][0]=temp;
					Mat[j][1]=temp1;
					
				}
				
			}
		}
		
		
		for(int i=N-1; i>0; i--){
			if(W/Mat[i][0]>0){
				Count+=(W/Mat[i][0])*Mat[i][1];
				W=W%Mat[i][0];
				System.out.println(Count);
			}
			else
				break;
		}
		System.out.println(Count);
		
		
		
	}

}
