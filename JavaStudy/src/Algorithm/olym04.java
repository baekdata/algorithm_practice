package Algorithm;
import java.util.Scanner;
public class olym04 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String glass = input.nextLine();
		int length = glass.length();
		int height = 0;
		boolean flag = false;
		String [] a = new String [100];

		for(int i=0; i<length; i++){
			a[i]=glass.charAt(i)+"";
		}

		input.close();
		int j=0;

		if(length>=3&&length<=50){
			while(j<length){
				if((a[j].equals("("))&&(!flag)){
					height+=10;
					flag = true;
				}else if((a[j].equals("("))&&(flag)){
					height+=5;
				}else if((a[j].equals(")"))&&(flag)){
					height+=10;
					flag = false;
				}else if((a[j].equals(")"))&&(!flag)){
					height +=5;
				}
				j++;
			}
			System.out.println(height);
		}else{
			System.out.println("문자열의 길이가 잘못되었습니다.");
		}
	}
}