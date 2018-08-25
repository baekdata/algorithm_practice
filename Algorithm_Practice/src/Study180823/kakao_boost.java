package Study180823;
import java.util.ArrayList;
import java.util.Scanner;
public class kakao_boost {
	static ArrayList<kakao1> map1;
	static ArrayList<kakao2> map2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			map1.add(new kakao1(sc.nextInt(), sc.nextInt()));
		}
		
		for(int i=0; i<m; i++) {
			map2.add(new kakao2(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		while(true) {
			
			
			
			
			
			
//			if(flag) {
//				System.out.println();
//			}
		}
	}
}

class kakao1{ // 각 포인트 
	int x, y;
	
	kakao1(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class kakao2{ // 각 질의 
	int x, y, count;
	
	kakao2(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
