package Study180816;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_9205_beer { // 맥주마시면서 걷기 //bfs문제 or 플로이드 와샬 문제. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for(int i=0; i<testCase; i++) {
			boolean result = false;
			// 위치 순서 집, 편의점 들... , 락페스티벌.
			int n = sc.nextInt();
			Point[] point = new Point[n+2];
			boolean[] check = new boolean[n+2]; // false 초기화.
			Queue<Point> q = new LinkedList<Point>();

			for(int j=0; j<n+2; j++) {
				point[j] = new Point(sc.nextInt(), sc.nextInt());
			}

			Point start = point[0]; // 시작
			Point end = point[n+1]; // 끝
			q.add(start);

			while(!q.isEmpty()) {
				Point p = q.remove();
				if(p.equals(end)) { // 다음 장소가 도착지라 종료.
					result = true;
					break;
				}

				for(int k=0; k<n+2; k++) { // 모든 방문할 위치 중 맥주 20병 안에 도착할 경우만 큐에 삽입.
					if(!check[k] && (Math.abs(p.x - point[k].x)+ Math.abs(p.y - point[k].y)) <= 1000) {
						q.add(point[k]);
						check[k] = true;
					}
				}
			}
			System.out.println(result ? "happy" : "sad"); // 출력.
		}
	}
}

class Point{ //좌표 클래스. 
	int x, y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}