package Study180816;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2667_danjiSet { // dfs, bfs 문제 /  dfs로 풀어보기. // 문제 똑바로 읽기.
	// 변수 제대로 지정하고 정적변수. 
	// 정렬 등 잘 알기. // 혼자 풀었음.
	// 단지 붙이기
	static int count = 0;
	static int innerCount = 0;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] map;
	static boolean[][] check;
	static int num;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		map = new int[num][num];
		check = new boolean[num][num];
		
		for(int i=0; i<num; i++) {
			String input = sc.next();
			for(int j=0; j<num; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j));
				check[i][j] = false;
			}
		}
//		
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<num; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(map[i][j] == 1 && check[i][j] == false) {
//					System.out.println("test"+" " +i+" "+j);
					count++;
					result.add(innerCount);
					innerCount = 1;
					dfs(i, j);
				}
			}
		}
		result.add(innerCount);
		System.out.println(count);
		Collections.sort(result);
		for(int i=1; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void dfs(int n, int m) {
		map[n][m] = 2;
		check[n][m] = true;
		
		for(int i=0; i<4; i++) {
			int nx = n + dx[i];
			int ny = m + dy[i];
			
			if(nx >= 0 && nx < num && ny >= 0 && ny < num && map[nx][ny] == 1 && map[n][m] == 2) {
				innerCount++;
				dfs(nx, ny);
			}
		}
	}
}