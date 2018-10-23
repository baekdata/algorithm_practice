package samsungProb;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_5014_StartL { // 단일 큐 사용. BFS
	static Queue<Integer> q = new LinkedList<Integer>(); // 그냥 큐는 이렇게 진행 
	static int f, s, g, u, d;
	static boolean check[];
	static int[] dist;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		
		check = new boolean[f+1];
		dist = new int[f+1];
		
		bfs(s);
		
		if(check[g]) {
			result = dist[g];
			System.out.println(result);
		}else {
			System.out.println("use the stairs");
		}
	}
	
	public static void bfs(int index) {
		q.add(index);
		check[index] = true;
		
		while(!q.isEmpty()) {
			int qq = q.remove();
			
			if(qq+u<=g && check[qq+u] == false) {
				check[qq+u] = true;
				q.add(qq+u);
				dist[qq+u] = dist[qq] + 1; // 거리 체크 배열로 진행. 
			}
			
			if(qq-d>=1 && check[qq-d] == false) {
				check[qq-d] = true;
				q.add(qq-d);
				dist[qq-d] = dist[qq] + 1;
			}
		}
	}
}