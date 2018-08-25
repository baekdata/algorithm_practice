package Study180816;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_hideandseek { // 숨바꼭질, BFS, 백트래
	public static final int MAX = 200000; // 최대값 설정, 100000은 런타임에러나서 200000으로 설정. 100001도 될듯.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int finish = sc.nextInt();
		int dist[] = new int[MAX];
		boolean check[] = new boolean[MAX];
		Queue<Integer> q = new LinkedList<Integer>();
		
		//start의 초기값 세팅.
		dist[start] = 0;
		check[start] = true;
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.remove();
			if(now-1 >= 0 && !check[now-1]) {
				q.add(now-1);
				check[now-1] = true;
				dist[now-1] = dist[now] +1;
			}

			if(now+1 < MAX && !check[now+1]) {
				q.add(now+1);
				check[now+1] = true;
				dist[now+1] = dist[now] + 1;
			}

			if(now*2 < MAX && !check[now*2]) {
				q.add(now*2);
				check[now*2] = true;
				dist[now*2] = dist[now] +1;
			}
		}
		System.out.println(dist[finish]);
	}
}
