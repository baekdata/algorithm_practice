import java.util.Scanner;
public class Steps { // Chapter6. 48�� ���� Steps
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt(); // tc
		for(int i=0; i<length; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(solve(y-x));
		}
	}
	public static int solve(int n){ // ���
		int i=0;
		long sum =1;
		if(n==0) return 0;
		if(n==1) return 1;
		for(i=2; sum<n; i++)
			sum+=(i+1)/2;
		return i-1;
	}
}
