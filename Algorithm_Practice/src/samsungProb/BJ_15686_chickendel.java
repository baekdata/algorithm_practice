package samsungProb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_15686_chickendel { // 1015 월요일 : 삼성기출 - 치킨배달   >>> 솔직히 30분 컷 문제 (1회독 pass) 
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) { 
		// 13개 중에 n개 고르거나 재귀함수 사용 
		// 백준 > 13개 중에 n개 고르는식으로 진행. 순열 활용. nextPermutation 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 맵 크기 
		int m = sc.nextInt(); //치킨집 수 
		int[][] a = new int[n][n];
		ArrayList<Pair> people = new ArrayList<>();
		ArrayList<Pair> store = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 1) {
					people.add(new Pair(i, j));
				}else if(a[i][j] == 2) {
					store.add(new Pair(i, j));
				}
			}
		}
		
		int d[] = new int[store.size()]; // 2가 들어있는 수만큼 만들기 
		for(int i=0; i<m; i++) { // 주어진 m만큼 1넣기 
			d[i] = 1;
		}
		Arrays.sort(d);
		int ans = -1;
		
		do { // 주어진 치킨집 수 중 m만큼 뽑아서 거리 측정  // 1100 1001 1010 등 치킨집 위치 순열 
			int sum = 0;
			for(Pair p : people) {
				int min = -1;
				for(int i=0; i<store.size(); i++) {
					System.out.println(d[i]);
					if(d[i] == 0) continue;
					Pair s = store.get(i); // 거리 측정 하기 
					int d1 = p.x - s.x;
					int d2 = p.y - s.y;
					if(d1<0) d1 = -d1;
					if(d2<0) d2 = -d2;
					int dist = d1 + d2;
					if(min == -1 || min > dist) {
						min = dist;
					}
				}
				sum += min;
			}
			if(ans == -1 || ans > sum) {
				ans = sum;
			}
			
		}while(next_permutation(d));
		System.out.println(ans);
	}

	public static boolean next_permutation(int[] a) { // 순열구하기 > 암기하기 
		int i = a.length-1;
		while (i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}

		if (i <= 0) return false;

		int j = a.length-1;
		while (a[j] <= a[i-1]) {
			j -= 1;
		}

		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;

		j = a.length-1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}
}