package Algorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Combination {//난쟁이 문제 // 조합 활용 // 2309
	static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] combinationOfChar = new int[9];
		for(int i=0; i<9; i++)
			combinationOfChar[i] = sc.nextInt();
		solve(7, combinationOfChar);
	}

	public static void solve(int n, int[] combinationOfChar) {
		int[] selected = new int[n];
		sum = print(n, combinationOfChar, 0, selected);
	}

	public static int print(int n, int[] a, int from, int[] selected) {
		ArrayList<Integer> ar= new ArrayList<Integer>();
		if(n == 0){ 
			sum=0;
			for(int i = 0; i < selected.length; ++i)
				sum+= a[selected[i]];

			if(sum==100){
				for (int i = 0; i < selected.length; ++i) 
					ar.add(a[selected[i]]);
				Collections.sort(ar);
				for (int i = 0; i < selected.length; ++i) 
					System.out.println(ar.get(i));
			} 
			return sum;
		}

		for(int i = from; i < a.length; ++i) {
			selected[selected.length - n] = i;
			print(n-1, a, i+1, selected);
		}
		return sum;
	}
}