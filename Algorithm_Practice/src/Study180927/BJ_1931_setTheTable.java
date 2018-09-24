package Study180927;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1931_setTheTable { // 회의실 같은 경우 체크 필요 
	static ArrayList<tableTime> table = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for(int i=0; i<testCase; i++) {
			table.add(new tableTime(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(table); // 정렬 
		
		int ans=0, now = 0;
		for(int i=0; i<testCase; i++) {
			if(now <= table.get(i).begin) {
				now = table.get(i).end;
				ans += 1;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}

class tableTime implements Comparable<tableTime>{
	int begin, end;

	public tableTime(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public int compareTo(tableTime s) { // 내가 원하는 대로 비교 가능 
		if (this.end < s.getEndTime()) {
			return -1;
		} else if (this.end > s.getEndTime()) {
			return 1;
		}
		return 0;
	}
	
	public int getEndTime() {
		return this.end;
	}
}
