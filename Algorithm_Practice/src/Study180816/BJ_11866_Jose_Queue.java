package Study180816;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11866_Jose_Queue { // 큐 관련 혼자 테스트.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {
			q.add(i+1);
		}

		while(!q.isEmpty()) {
			for(int i=0; i<m; i++) {
				if(i == (m-1)) {
					result.add(((LinkedList<Integer>) q).get(0));
				}else {
					q.add(q.peek());	
				}
				q.remove();
			}
		}
		
		System.out.print("<");
		
		for(int i=0; i<result.size(); i++) {
			if(i == result.size()-1) {
				System.out.print(result.get(i));
			}else {
				System.out.print(result.get(i)+", ");
			}
		}
		System.out.println(">");
	}
}