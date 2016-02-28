
public class test58 { //소수판별 // 
	//1. 1과 n을 제외한다.
	//2. n을 2부터 n-1까지의 수로 나눈다.
	//3. 나누어 떨어지는 수가 있다면 소수가 아니다.
	
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
			System.out.println(total+"은 소수이다.");
		}else{
			System.out.println(total+"은 소수가 아니다.");
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
			System.out.println(num+"은 소수입니다.");
		}else{
			System.out.println(num+"은 소수가 아닙니다.");
		}
	}
}
