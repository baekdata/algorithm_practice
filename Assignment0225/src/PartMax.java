import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; // �ð��ʰ�
public class PartMax { // ������ �ִ밪 ���ϱ� // �ڷᱸ��2 // �ð��ʰ� ��°� ���� // 30�� // 7�� �ð��ʰ�  // ������ �ִ��� , DP, ��������, �̺κ� Ȱ�� �ʿ��� 
	public static void main(String[] args){ // ���� �̿��غ���
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
				max = temp; // �ִ밪 ���ϱ�
		}

		for(int i=0; i<part; i++){
			numArrayTest.clear();
			int partA = sc.nextInt();
			int partB = Integer.parseInt(sc.next().trim()); // from�� �ϳ� ������ �ؾ���
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