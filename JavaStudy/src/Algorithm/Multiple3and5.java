package Algorithm;

public class Multiple3and5 { // 1000�̸��� 3 �Ǵ� 5�� ��� ���� ���϶�

	
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
