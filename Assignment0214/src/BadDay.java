import java.util.Scanner;
public class BadDay { // 정올 불쾌한 날 // 자료구조2 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int ar[] = new int[input];
		long count=0; // int형으로 할 경우 최악의 경우 int범위를 넘어선다.

		for(int i=0; i<input; i++){
			ar[i]=sc.nextInt();
		}

		for(int i=0; i<input; i++){
				for(int j=i+1; j<input; j++){
					if(ar[i]<=ar[j]){
						break;
					}
					if(ar[i]>ar[j]){
						count++;
					}
				}
			}
		System.out.println(count);
	}
}