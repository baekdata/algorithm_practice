/*
 * visit 배열생성하고 j에 방문하면 visit[j]= true.
 * mat[i,j]==0 이면 방문 안함.
 *
 * BackTraking함수를 재귀적으로 이용.
 * 파라매터: 출발위치, sum, 도착위치 입력.
 * 
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Hamilton {

	public static void main(String[] args) {
		
		int N;
		Scanner scan =new Scanner(System.in);
		N=scan.nextInt();
		Hamil H =new Hamil(N);
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				H.addEdge(i, j, scan.nextInt());
			}
		}
		H.print();
		
	}
}

class IN{
	protected int N;
	protected int[][] Mat;
	
	public IN(){}
	public IN(int N){
		this.N=N;
		this.Mat = new int[N+1][N+1];
	}
	protected void addEdge(int row, int col, int wei){
		Mat[row][col] = wei;
	}
	
}
class Hamil extends IN{
	private boolean[] visit;
	private int min;
	
	public Hamil(){}
	public Hamil(int n){
		super(n);
		this.visit = new boolean[n+1];
		this.min = Integer.MAX_VALUE;
	}
	
	void BackTraking(int i, int sum, int check){
		for(int j=2; j<=N;j++){
			if(promising(i,j)){
				visit[j]= true;
				sum+=Mat[i][j];
				if(check ==N-1){
					if(promising(j,1) && (min >sum+Mat[j][1])){
						min = sum+Mat[j][1];
					}
					visit[j]=false;
					return;
				}
				BackTraking(j,sum,check+1);
				visit[j] =false;
				sum-=Mat[i][j];
			}
		}
	}
	private boolean promising(int i, int j){
		if(visit[j]){
			return false;
		}
		if(Mat[i][j]==0){
			return false;
		}
		return true;
	}
	void print(){
		BackTraking(1,0,1);
		System.out.println(min);
	}
	
	
}
