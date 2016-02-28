package Algorithm;
import java.util.Scanner;
public class olym01 { // 백준 패키지명 빼고, scanner close해주기
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int carNum = 0;
		carNum = input.nextInt();
		int a[] = new int[5];
		int count=0, result = 0;

		for(int i =0; i<5; i++){
			a[i]=input.nextInt();
		}
		input.close();

		while(count<5){
			if(carNum==a[count]){
				result++;
			}
			count++;
		}
		System.out.println(result);
	}
}