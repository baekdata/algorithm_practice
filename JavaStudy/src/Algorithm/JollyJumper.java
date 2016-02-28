package Algorithm;
import java.util.Scanner;

public class JollyJumper{ // JollyJumper
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] a = new int[100]; // 배열
		Boolean flag = true;
		int size = 1;
		int i=0, interval =0, interval2=0;

		while(size != 0){
			i=0; flag = true; // 초기화
			size = input.nextInt(); // size입력
			if(size ==0)
				break;
			
			for(int is=0; is<size; is++)
				a[is]=input.nextInt();

			interval = (a[i+1]-a[i]);
			interval2 = interval-1;  
			i++;

			while(i<size-1){ //size만큼 loop 
				interval = Math.abs(a[i+1]-a[i]); // 차를 절대값으로
				if(interval!=interval2){ // 2 != 2
					System.out.println("Not jolly");
					flag = false; break;
				}
				interval2 = interval-1;
				i++;
			}
			if(flag)
				System.out.println("Jolly");
		} 
		System.out.println("The End");
	}
}