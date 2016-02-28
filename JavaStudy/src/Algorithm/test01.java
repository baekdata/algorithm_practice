package Algorithm;
import java.util.Scanner;
public class test01 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		if(A>0&&B>0&&A<10&&B<10){
			System.out.println(A+B);
		}
	}
}
