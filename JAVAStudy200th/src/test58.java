
public class test58 { //�Ҽ��Ǻ� // 
	//1. 1�� n�� �����Ѵ�.
	//2. n�� 2���� n-1������ ���� ������.
	//3. ������ �������� ���� �ִٸ� �Ҽ��� �ƴϴ�.
	
	public static void main(String args[]){
		int total = 18;
		boolean isP = true;
		for(int j=2; j<total; j++){
			if(total%j==0){
				isP = false;
				break;
			}else{
				isP = true;
			}
		}
		if(isP){
			System.out.println(total+"�� �Ҽ��̴�.");
		}else{
			System.out.println(total+"�� �Ҽ��� �ƴϴ�.");
		}
		printPrime(total);
	}
	
	public static boolean isPrime(int num){
		boolean isP = true;
		for(int j=2; j<num; j++){
			if(num%j==0){
				isP=false;
				break;
			}else{
				isP = true;
			}
		}
		return isP;
	}
	
	public static void printPrime(int num){
		if(isPrime(num)){
			System.out.println(num+"�� �Ҽ��Դϴ�.");
		}else{
			System.out.println(num+"�� �Ҽ��� �ƴմϴ�.");
		}
	}
}
