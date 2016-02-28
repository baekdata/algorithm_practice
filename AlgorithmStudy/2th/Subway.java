//다익스트라 방법을 이용.

import java.util.Arrays; 
import java.util.ArrayList;
import java.util.*;
public class Subway {
	
	public static void main(String[] args) {
		
		int N; //역의 수.
		int M; //목적지.
		int temp=0;
		Scanner scan =new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		
		int[][] S = new int [N][N]; 
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				S[i][j] = scan.nextInt();
			}
		}
		
		
		
		int start = 0;  // 출발점.
		int [] Distance = new int [N];  // 임시거리.
		int [] Path= new int [N];		// 통로.
		
		for(int i=0; i<N;i++)
			Distance[i]=Integer.MAX_VALUE;
		Distance[start]=0;
		
		
		boolean [] visit = new boolean [N]; 
		int min;
		
		// 다익스트라.
		for(int i=0; i<N;i++){
			min= Integer.MAX_VALUE;
			for(int j=0;j<N; j++){
				if(visit[j]==false && Distance[j]<min){
					temp=j;
					min=Distance[j];
				}
			}
			visit[temp]=true;
			for(int k=0; k<N; k++){
				if(Distance[k]> Distance[temp] + S[temp][k]){
					Distance[k]= Distance[temp] + S[temp][k];
					Path[k]=temp;
				}
			}
		}
		
		System.out.println(Distance[M-1]);
		
		
		
		int End=M-1;
		int[] path =new int [N];
		int cnt=0;
		while(true){
			path[cnt++]=End;
			if(End==start){
				break;
			}
			End=Path[End];
		}
		for(int i=cnt-1; i>=0; i--){
			System.out.print(path[i]+1+" " );
		}
	}
}


