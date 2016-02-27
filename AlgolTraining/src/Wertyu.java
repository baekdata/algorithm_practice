import java.util.ArrayList;
import java.util.Scanner;
public class Wertyu { // Charter03. 알고리즘 트레이닝북 17번 문제
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> keyFirst = new ArrayList<String>(); // String arraylist
		ArrayList<String> keySecond = new ArrayList<String>();
		ArrayList<String> keyThird = new ArrayList<String>();
		ArrayList<String> keyFourth = new ArrayList<String>();
		
		String strFirst = "1234567890-="; // 키보드 넣기 위해 
		String strSecond = "QWERTYUIOP[]\\";
		String strThird = "ASDFGHJKL;'";
		String strFourth = "ZXCVBNM,./";	
		String inputQuery = sc.nextLine();
		String[] compareArr = new String[1000];
		
		InputList(keyFirst, strFirst); //for문으로 string값 다 나눠서 넣기
		InputList(keySecond, strSecond);
		InputList(keyThird, strThird);
		InputList(keyFourth, strFourth);

		for(int i=0; i<inputQuery.length(); i++)
			compareArr[i] = inputQuery.charAt(i)+"";
		
		for(int i=0; i<inputQuery.length(); i++){
			if(keyFirst.contains(compareArr[i])){
				int tempIndex = keyFirst.indexOf(compareArr[i]);
				if(tempIndex-1>=0) // 맨 왼쪽의 키값일 때 예외처리
				compareArr[i] = keyFirst.get(tempIndex-1); // 왼쪽으로 한 칸 이동
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
		for(int i=0; i<strValue.length(); i++)// arraylist로 값 대입
			keyBoard.add(strValue.charAt(i)+"");
	}
}