import java.util.Scanner;


public class test122 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int in = input.nextInt();
		int a,b,c = 0;
		
		a = in/100;
		b = (in%100)/10;
		c = ((in%100)%10);
		
		System.out.println(a+b+c);
		
	}
}
