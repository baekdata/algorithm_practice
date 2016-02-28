
public class test67 { // 완전수 , 자신을 제외한 약수의 합과 자신이 같아야함
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
