<<<<<<< HEAD
package Study180830;
=======
package Study0830;
>>>>>>> branch 'master' of https://github.com/baekdata/algorithm_practice.git
import java.util.Scanner;

public class BJ_14500_tetromino2 { //  참고 소스 
	static int N,M;
	static int[][] arr;
	static int[][] visit;
	static int MAX;
	static int sum;
	static int dx[]={1,-1,0,0};
	static int dy[]={0,0,1,-1};

	public static void main(String args[]) throws Exception{ // DFS로 풀고, dfs안되는 예외는 따로 처리 
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();

		arr=new int[N][M];
		visit=new int[N][M];

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j]=scan.nextInt();
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				DFS(i,j,0);
				sum=0;
//				exception(i,j);
//				sum=0;
			}
		}

		System.out.println(MAX);
		scan.close();
	}

	static void DFS(int x, int y, int depth){
		if(depth==4){
			if(sum>MAX)
				MAX=sum;
			return;
		}

		visit[x][y]=1;
		sum+=arr[x][y];

		for(int i=0; i<4; i++){ //이동할 수 있는 범위인지 확인하고 이동할 수 있는 범위이면 이동
			int nx=x+dx[i];
			int ny=y+dy[i];

			if(nx>=0 && nx<N && ny>=0 && ny<M && visit[nx][ny]==0)
				DFS(nx,ny,depth+1);
		}
		visit[x][y]=0;
		sum-=arr[x][y];
	}


	static void exception(int i, int j){ //DFS로 처리 불가능한 예외 경우 처리 (ㅓ,ㅜ,ㅏ,ㅗ 모양)
		if(i-1>=0 && i+1<N && j-1>=0)
		{
			if(MAX < arr[i-1][j]+arr[i][j]+arr[i+1][j]+arr[i][j-1])
				MAX = arr[i-1][j]+arr[i][j]+arr[i+1][j]+arr[i][j-1];
		}
		if(i-1>=0 && i+1<N && j+1<M){
			if(MAX < arr[i-1][j]+arr[i][j]+arr[i+1][j]+arr[i][j+1])
				MAX = arr[i-1][j]+arr[i][j]+arr[i+1][j]+arr[i][j+1];
		}
		if(i-1>=0 && j-1>=0 && j+1<M)
		{
			if(MAX < arr[i-1][j]+arr[i][j]+arr[i][j-1]+arr[i][j+1])
				MAX = arr[i-1][j]+arr[i][j]+arr[i][j-1]+arr[i][j+1];
		}
		if(i+1<N && j-1>=0 && j+1<M){
			if(MAX < arr[i+1][j]+arr[i][j]+arr[i][j-1]+arr[i][j+1])
				MAX = arr[i+1][j]+arr[i][j]+arr[i][j-1]+arr[i][j+1];
		}
	}

}