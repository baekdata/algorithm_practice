import java.util.Scanner;
public class BadHairDay {

	public static void main(String[] args) {
		
		int N; //역의 수.
		
		Scanner scan =new Scanner(System.in);
		N = scan.nextInt();
		
		long[] Long = new long [N]; //목적지.
		for(int i=0; i<N; i++){
				Long[i] = scan.nextInt();
		}
		
		
		long temp1=0L;
		long temp2=0L;
		long count=0L;
		for(int i=0; i< N-1; i++){
			temp1=Long[i];
			for(int j=i+1; j<N;j++){
				temp2=Long[j];
				if(temp1<=temp2)
					break;
				else
					count++;
			}
		}
		
		System.out.println(count);
		
		
	}
}

