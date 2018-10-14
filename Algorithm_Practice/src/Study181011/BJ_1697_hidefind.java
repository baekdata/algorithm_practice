package Study181011;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_hidefind { // (PASS) bfs 기본 숨바꼭질 
	static final int MAX = 200000;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] dist = new int[MAX];
	static boolean[] check = new boolean[MAX];

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();

		if(start == end) { // 이런 예외처리 항상 유의해야 한다. 
			System.out.println(0);
		}else {
			queue.add(start);
			solve();
			
			System.out.println(dist[end]);
		}
		sc.close();
	}

	public static void solve() {
		while(!queue.isEmpty()) {
			int now = queue.remove();
			if(now+1 < MAX) {
				if(!check[now+1]) {
					queue.add(now+1);
					dist[now+1] = dist[now] + 1;
					check[now+1] = true;
				}
			}

			if(now-1 >= 0) {
				if(!check[now-1]) {
					queue.add(now-1);
					dist[now-1] = dist[now] + 1;
					check[now-1] = true;
				}
			}

			if(now*2 < MAX) {
				if(!check[now*2]) {
					queue.add(now*2);
					dist[now*2] = dist[now] + 1;
					check[now*2] = true;
				}
			}
		}
	}
}