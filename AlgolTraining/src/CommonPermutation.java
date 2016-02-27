import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class CommonPermutation { // Chater3. 알고리즘 트레이닝 북 19번
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
					if((a.charAt(i)==b.charAt(j))&&!(sameWord.contains(a.charAt(i)+""))) //문자열이므로 ""
						sameWord.add(a.charAt(i)+""); // 위에서 이미 들어가 있는 중복의 경우 체크한다. arraylist의 경우 중복 허용
				}
			}
			Collections.sort(sameWord); //알파벳 순으로 정렬
			output[k]=""; // 문자열배열 초기값 null이므로 
			for(int i=0; i<sameWord.size(); i++)
				output[k]+=sameWord.get(i); // 각 경우마다 문자열배열에 지정
		}
		for(int i=0; i<count; i++)
			System.out.println(output[i]);
	}
}