import java.util.Scanner;


public class test43 {

	public static void main(String[] args){
		
		
		int toNum = readInt();
		
		int sum = sumAn(toNum, 1,2);
		System.out.println("sum = "+ sum); // 등차수열

		int sum1 = sumBn(toNum, 1,2);
		System.out.println("sum = "+ sum1); // 등비수열

		int sum3 = sumCn(toNum, 2, 3, -2); // 점화식
		System.out.println("sum = "+sum3);
	}

	public static int readInt(){
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	public static int numAn(int start, int n, int d){
		return(start+n*d);
	}

	public static int sumAn(int start, int n, int d){ // 등차수열 합
		int sum=0;
		for(int i=0; i<n; i++){
			System.out.print("["+numAn(start, i, d)+"]");
			sum+=numAn(start, i, d);
		}
		return sum;
	}

	public static int numBn(int start, int n, int r){ // 등비수열 합
		int nums=1;

		for(int i=0; i<n; i++){
			nums*= start*r;
		}
		return nums;
	}

	public static int sumBn(int n, int start, int r){
		int sum =0; 
		for(int i=0; i<n; i++){
			System.out.print("["+numBn(start, i, r)+"]");
			sum+=numBn(start, i, r);
		}
		return sum;
	}

	public static int numCn(int n, int start, int a, int d){
		for(int i=0; i<n; i++){
			start=a*start + d;
		}
		return start;
	}

	public static int sumCn(int n, int start, int a, int d){
		int sum=0;
		for(int i=0; i<n; i++){
			System.out.print("["+numCn(i,start, a, d)+"]");
			sum+=numCn(i,start, a, d);
		}
		return sum;
	}
}



