
public class test68 { // ģȭ�� , �ڽ��� ������ ����� ��
	public static void main(String args[]){
		int range = 220;
		int sum =0;
		
		for(int i=1; i<220; i++){
			if(range%i==0){
				sum+=i;
			}
		}
		System.out.println(range+"�� ģȭ���� "+sum+"�Դϴ�.");
		
	}
}

//		for(int i=2; i<=range; i++){
//			for(int j=1; j<i; j++){
//				if(i%j==0){
//					sum+=j;
//				}
//			}
//			if(sum==i){
//				System.out.println(i);
//			}
//			sum=0;
//		}