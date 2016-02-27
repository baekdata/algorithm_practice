import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; // 시간초과
public class PartMax { // 구간의 최대값 구하기 // 자료구조2 // 시간초과 잡는게 관건 // 30점 // 7개 시간초과  // 구간의 최대합 , DP, 분할정복, 이부분 활용 필요할 
	public static void main(String[] args){ // 스택 이용해보기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int part = Integer.parseInt(sc.next().trim());
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		ArrayList<Integer> numArrayTest = new ArrayList<Integer>();
		int[] resultSet = new int[part];

		int max = 0;
		for(int i=0; i<num; i++){
			int temp = Integer.parseInt(sc.next().trim());
			numArray.add(temp);
			if(max<temp)
				max = temp; // 최대값 구하기
		}

		for(int i=0; i<part; i++){
			numArrayTest.clear();
			int partA = sc.nextInt();
			int partB = Integer.parseInt(sc.next().trim()); // from은 하나 전으로 해야함
			if(numArray.subList(partA-1, partB).contains(max)){
				resultSet[i] = max;
			}else{
				numArrayTest.addAll(numArray.subList(partA-1, partB)); //sublist(from, to) 
				Collections.sort(numArrayTest);
				resultSet[i]=numArrayTest.get(numArrayTest.size()-1);
			}
		}

		for(int i=0; i<part; i++)
			System.out.println(resultSet[i]);
		sc.close();
	}
}