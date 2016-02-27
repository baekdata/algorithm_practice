import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
public class LastTest { // Chater04. 26번 문제  팬케이크 // arraylist 부분 배열 전환 sublist // Collections.reverse 해당 배열 그대로 반대 //
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		Vector<Integer> inArr = new Vector<Integer>();

		while(sc.hasNext()){ // 다음 입력값이 있다면 true 없으면 false
			inArr.clear(); // 각 arraylist 초기화
			arr.clear();
			int innerIndex=0; // 내부 index

			for(int j=0; j<5; j++){
				arr.add(sc.next());
				System.out.print(arr.get(j)+" ");
			} System.out.println();

			for(int i=0; i<5; i++){
				if(!(arr.get(4-i).equals((5-i)+""))){
					int index = arr.indexOf((5-i)+""); //제 자리에 있지 않은 최대값의 index 찾기
					Collections.reverse(arr.subList(0, (5-index)-innerIndex)); // sublist 구간만 뒤집는다.
					inArr.add((index+1)+innerIndex); // 뒤집는 부분 vector에 저장
				}
				innerIndex++; 
			}
			for(int i=0; i<inArr.size(); i++)
				System.out.print(inArr.get(i)+" "); // 뒤집는 부분 출력

			System.out.print(0); //마지막 항상 0출력
			System.out.println();
		}
		sc.close(); // 메모리 해소
	}
}