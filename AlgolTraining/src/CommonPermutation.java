import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class CommonPermutation { // Chater3. �˰��� Ʈ���̴� �� 19��
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String trash = sc.nextLine();
		String[] output = new String[100];
		ArrayList<String> sameWord = new ArrayList<String>();

		for(int k=0; k<count; k++){
			sameWord.clear();
			String a = sc.nextLine();
			String b = sc.nextLine();
			for(int i=0; i<a.length(); i++){
				for(int j=0; j<b.length(); j++){
					if((a.charAt(i)==b.charAt(j))&&!(sameWord.contains(a.charAt(i)+""))) //���ڿ��̹Ƿ� ""
						sameWord.add(a.charAt(i)+""); // ������ �̹� �� �ִ� �ߺ��� ��� üũ�Ѵ�. arraylist�� ��� �ߺ� ���
				}
			}
			Collections.sort(sameWord); //���ĺ� ������ ����
			output[k]=""; // ���ڿ��迭 �ʱⰪ null�̹Ƿ� 
			for(int i=0; i<sameWord.size(); i++)
				output[k]+=sameWord.get(i); // �� ��츶�� ���ڿ��迭�� ����
		}
		for(int i=0; i<count; i++)
			System.out.println(output[i]);
	}
}