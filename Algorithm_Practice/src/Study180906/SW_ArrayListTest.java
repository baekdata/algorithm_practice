package Study180906;

import java.util.ArrayList;

public class SW_ArrayListTest { // 인접리스트 
	public static void main(String[] args) {
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[100]; // ArrayList 배열 
		a[0] = new ArrayList<Integer>(); // 각 ArrayList마다 생성 필요 
		a[0].add(1);
		a[0].add(3);
		a[0].add(5);

		for(int i=0; i<a[0].size(); i++) {
			System.out.println(a[0].get(i));
		}
	}
}