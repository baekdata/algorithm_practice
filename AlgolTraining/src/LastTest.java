import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
public class LastTest { // Chater04. 26�� ����  ������ũ // arraylist �κ� �迭 ��ȯ sublist // Collections.reverse �ش� �迭 �״�� �ݴ� //
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		Vector<Integer> inArr = new Vector<Integer>();

		while(sc.hasNext()){ // ���� �Է°��� �ִٸ� true ������ false
			inArr.clear(); // �� arraylist �ʱ�ȭ
			arr.clear();
			int innerIndex=0; // ���� index

			for(int j=0; j<5; j++){
				arr.add(sc.next());
				System.out.print(arr.get(j)+" ");
			} System.out.println();

			for(int i=0; i<5; i++){
				if(!(arr.get(4-i).equals((5-i)+""))){
					int index = arr.indexOf((5-i)+""); //�� �ڸ��� ���� ���� �ִ밪�� index ã��
					Collections.reverse(arr.subList(0, (5-index)-innerIndex)); // sublist ������ �����´�.
					inArr.add((index+1)+innerIndex); // ������ �κ� vector�� ����
				}
				innerIndex++; 
			}
			for(int i=0; i<inArr.size(); i++)
				System.out.print(inArr.get(i)+" "); // ������ �κ� ���

			System.out.print(0); //������ �׻� 0���
			System.out.println();
		}
		sc.close(); // �޸� �ؼ�
	}
}