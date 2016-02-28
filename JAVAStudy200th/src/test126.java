
public class test126 { // for문으로 팩토리얼
	public static void main(String[] args){
		for(int i=1; i<14; i++){
			System.out.print(fact(i)+ " ");
		}
	}
	
	public static int fact(int m){
		int temp =1;
		for(int i=m; i>0; i--){
			temp*=i;
		}
		return temp;
	}

}
