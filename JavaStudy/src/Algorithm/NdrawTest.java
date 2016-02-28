package Algorithm;
import java.util.Scanner;

public class NdrawTest{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		for (int i=0;  i<num;  i++)
		{
			System.out.print("N");
			for (int j=1;  j<num-1;  j++)
			{
				if ( j == i && (i != 0 || i != (num-1)) )
					System.out.print("N");
				else
					System.out.print(" ");
			}
			if (num > 1)
				System.out.println("N");
		}
	}
}