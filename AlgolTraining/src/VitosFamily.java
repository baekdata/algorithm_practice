import java.util.Scanner;
public class VitosFamily { // Chater04. 25�� ����  Vito's Family
	public static void main(String[] args){ // ��հ��� �Ÿ� üũ // ���밪
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] arr = new int[100];
		int[] average = new int[100];
		
		for(int i=0; i<count; i++){
			int inCount = sc.nextInt();
			int sum = 0;
			for(int j=0; j<inCount; j++){
				arr[j]=sc.nextInt();
				sum+=arr[j];
			}
			sum=sum/inCount;
			for(int k=0; k<inCount; k++)
				average[i] += Math.abs(sum-arr[k]);
		}
		for(int i=0; i<count; i++)
		System.out.println(average[i]);
	}
}