import java.util.ArrayList;
import java.util.Scanner;
public class Wertyu { // Charter03. �˰��� Ʈ���̴׺� 17�� ����
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> keyFirst = new ArrayList<String>(); // String arraylist
		ArrayList<String> keySecond = new ArrayList<String>();
		ArrayList<String> keyThird = new ArrayList<String>();
		ArrayList<String> keyFourth = new ArrayList<String>();
		
		String strFirst = "1234567890-="; // Ű���� �ֱ� ���� 
		String strSecond = "QWERTYUIOP[]\\";
		String strThird = "ASDFGHJKL;'";
		String strFourth = "ZXCVBNM,./";	
		String inputQuery = sc.nextLine();
		String[] compareArr = new String[1000];
		
		InputList(keyFirst, strFirst); //for������ string�� �� ������ �ֱ�
		InputList(keySecond, strSecond);
		InputList(keyThird, strThird);
		InputList(keyFourth, strFourth);

		for(int i=0; i<inputQuery.length(); i++)
			compareArr[i] = inputQuery.charAt(i)+"";
		
		for(int i=0; i<inputQuery.length(); i++){
			if(keyFirst.contains(compareArr[i])){
				int tempIndex = keyFirst.indexOf(compareArr[i]);
				if(tempIndex-1>=0) // �� ������ Ű���� �� ����ó��
				compareArr[i] = keyFirst.get(tempIndex-1); // �������� �� ĭ �̵�
			}else if(keySecond.contains(compareArr[i])){
				int tempIndex = keySecond.indexOf(compareArr[i]);
				if(tempIndex-1>=0)
				compareArr[i] = keySecond.get(tempIndex-1);
			}else if(keyThird.contains(compareArr[i])){
				int tempIndex = keyThird.indexOf(compareArr[i]);
				if(tempIndex-1>=0)
				compareArr[i] = keyThird.get(tempIndex-1);
			}else if(keyFourth.contains(compareArr[i])){
				int tempIndex = keyFourth.indexOf(compareArr[i]);
				if(tempIndex-1>=0)
				compareArr[i] = keyFourth.get(tempIndex-1);
			}
		}
		for(int i=0; i<inputQuery.length(); i++)
			System.out.print(compareArr[i]);
	}
	static public void InputList(ArrayList<String> keyBoard, String strValue){
		for(int i=0; i<strValue.length(); i++)// arraylist�� �� ����
			keyBoard.add(strValue.charAt(i)+"");
	}
}