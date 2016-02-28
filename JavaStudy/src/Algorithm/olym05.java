package Algorithm;
import java.util.Scanner;
public class olym05 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int result = 0;
		int[] a = new int[5];
		
		for(int i=0; i<5; i++){
			a[i]=input.nextInt();
		}
		input.close();
		for(int j=0; j<5; j++){
			result += a[j]*a[j];
		}
		System.out.println(result%10);
	}
}
