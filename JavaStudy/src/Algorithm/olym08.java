package Algorithm;
import java.util.Scanner;
public class olym08 { // 이슈 있음 고쳐야함 // 약수구하기
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int count = input.nextInt();
		int [] a = new int [num];
		int countNum=0;
		int countNum02=0;
		int result = 0;

		for(int i=1; i<=num; i++){
			if(num%i==0){
				a[i-1]=1;
				countNum++;
			}
		}
		if(countNum<count){
			System.out.println(0);
		}else{
			for(int i=0; i<num; i++){
				if(a[i]==1){
					countNum02++;
				}
				if(countNum02==count){
					result = i;
				}
			}
			System.out.println(result);
		}
	}
}