
public class test67 { // ������ , �ڽ��� ������ ����� �հ� �ڽ��� ���ƾ���
	public static void main(String args[]){
		int range = 1000;
		int sum =0;
		
		for(int i=2; i<=range; i++){
			for(int j=1; j<i; j++){
				if(i%j==0){
					sum+=j;
				}
			}
			if(sum==i){
				System.out.println(i);
			}
			sum=0;
		}
	}
}
