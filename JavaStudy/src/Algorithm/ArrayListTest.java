package Algorithm;

import java.util.ArrayList;

public class ArrayListTest { // 순서가 있고, 중복이 허용
	public static void main(String[] args){
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("kim");
		list2.add("jong");
		ArrayList list = new ArrayList();
		list.add("lee");
		list.clear();
		list.addAll(list2);
		list.addAll(list2);
		
		int size = list.size();
		System.out.println(list.size());
		
		for(int i=0; i<size; i++){
			System.out.print(list.get(i)+" ");
		}
	}
}
