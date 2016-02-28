package Algorithm;

public class Multiple3and5 { // 1000미만의 3 또는 5의 배수 총합 구하라

	
	public static void main(String[] args){
		int sum = 0;
		int MAX = 1000;
		
		for(int i=1; i<MAX; i++){
			if(i%3==0 || i%5==0){
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}
