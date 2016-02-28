import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;

	public Point(){
		x=0;
		y=0;
	}
	public Point(int a, int b){
		x=a;
		y=b;
	}
};

public class Janggi { //장기
	static int n,m;
	static int[][] arr= new int[102][102];
	static boolean[][] visit = new boolean[101][101];
	static Queue<Point> que = new LinkedList<Point>(); //초기화 필수
	//Queue는 기본적으로 LinkedList로 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();

		for (int i = 0; i <= 100; i++)
			for (int j = 0; j <= 100; j++)
				visit[i][j] = true; // 기본 true로 초기화

		//여기서도 king의 이동반경때문에 초기화
		for (int i = 2; i <= n + 1; i++)
			for (int j = 2; j <= m + 1; j++)
				visit[i][j] = false;

		Point target = new Point();//쫄의 위치
		Point temp = new Point(); //기본값 세팅
		int kx = sc.nextInt();
		int ky = sc.nextInt();
		Point king = new Point(kx, ky);		//말의 위치

		target.x = sc.nextInt();
		target.y = sc.nextInt();
		
		king.x++;
		king.y++;
		
		target.x++;
		target.y++;

		que.offer(king); // 큐가 초기화 되어야 함. 
		visit[king.x][king.y] = true;

		//중요 부분 BFS
		while(true){
			if(visit[target.x][target.y]==true){
				break;
			}
			temp = que.poll(); // 빼고, 큐에서 제거한다. peek()은 그대로
			check(temp.x, temp.y, arr[temp.x][temp.y]);
		}
		System.out.println(arr[target.x][target.y]);
	}

	static void check(int x, int y, int k){ // BFS 전 레벨 차근히 탐색
		if(arr[x+1][y+2]==0 && visit[x+1][y+2]==false){
			arr[x+1][y+2] = k+1;
			visit[x+1][y+2] = true;
			Point temp = new Point(x+1, y+2);
			que.offer(temp);
		}

		if(arr[x+2][y+1]==0 && visit[x+2][y+1]==false){
			arr[x+2][y+1] = k+1;
			visit[x+2][y+1] = true;
			Point temp = new Point(x+2, y+1);
			que.offer(temp);
		}

		if(arr[x+2][y-1]==0 && visit[x+2][y-1]==false){
			arr[x+2][y-1] = k+1;
			visit[x+2][y-1] = true;
			Point temp = new Point(x+2, y-1);
			que.offer(temp);
		}

		if(arr[x+1][y-2]==0 && visit[x+1][y-2]==false){
			arr[x+1][y-2] = k+1;
			visit[x+1][y-2] = true;
			Point temp = new Point(x+1, y-2);
			que.offer(temp);
		}

		if(arr[x-1][y-2]==0 && visit[x-1][y-2]==false){
			arr[x-1][y-2] = k+1;
			visit[x-1][y-2] = true;
			Point temp = new Point(x-1, y-2);
			que.offer(temp);
		}

		if(arr[x-2][y-1]==0 && visit[x-2][y-1]==false){
			arr[x-2][y-1] = k+1;
			visit[x-2][y-1] = true;
			Point temp = new Point(x-2, y-1);
			que.offer(temp);
		}

		if(arr[x-2][y+1]==0 && visit[x-2][y+1]==false){
			arr[x-2][y+1] = k+1;
			visit[x-2][y+1] = true;
			Point temp = new Point(x-2, y+1);
			que.offer(temp);
		}

		if(arr[x-1][y+2]==0 && visit[x-1][y+2]==false){
			arr[x-1][y+2] = k+1;
			visit[x-1][y+2] = true;
			Point temp = new Point(x-1, y+2);
			que.offer(temp);
		}
	}
}