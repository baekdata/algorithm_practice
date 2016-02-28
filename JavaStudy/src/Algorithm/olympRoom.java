package Algorithm;
import java.util.ArrayList;
import java.util.Scanner;

public class olympRoom {
	public static void main(String[] args){
		ArrayList<Integer> ar = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		if(Integer.parseInt(num)>=1&&Integer.parseInt(num)<=1000000){
			double sixnineC=0, extraNum=0;

			for(int i=0; i<num.length(); i++){
				ar.add((int)(num.charAt(i)-'0'));
			}

			for(int i=0; i<ar.size(); i++){
				if(ar.get(i)==6||ar.get(i)==9){
					sixnineC++;
				}else{
					extraNum++;
				}
			}

			if((sixnineC/2.0)>extraNum){
				if(sixnineC%2==0){
					System.out.println((int)sixnineC/2);
				}else{
					System.out.println((int)(sixnineC/2)+1);
				}
			}else{
				System.out.println((int)extraNum);
			}
		}else{
			System.out.println("N을 잘못 입력함");
		}
	}
}