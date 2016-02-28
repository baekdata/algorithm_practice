package Algorithm;
import java.util.ArrayList;
import java.util.Scanner;
public class olymCycle {
	public static void main(String[] args){ // Cycle ´Ù½Ã..
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		int k = 0, cN = 0;
		boolean flag = true;
		int[] c = new int[100];
		ArrayList<Integer> ar = new ArrayList<Integer>();

		for(int i=0; i<50; i++){
			if(flag){
				k = (N*N)%P;
				flag = false;
			}else{
				k = (k*N)%P;
			}
			ar.add(k);
			c[ar.get(i)]+=1;
		}
		
		for(int i=0; i<26; i++){
			if(c[i]>5)
				cN++;
		}
		System.out.println(cN);
		sc.close();
	}
}