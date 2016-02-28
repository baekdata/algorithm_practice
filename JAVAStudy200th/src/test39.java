import java.util.Scanner;
//키보드 문자 입력

public class test39 {
	public static void main(String args[]){
		String str = readString();
		char[] charStr = str.toCharArray();
		int count = charStr.length;
		
		System.out.println("글자수: "+count);
		for(int i =0; i<count; i++){
			System.out.print(charStr[i]+":");
		}
		System.out.println();
		int num = readInt();
		
	}
	
	public static int readInt(){
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	public static String readString(){
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
}
