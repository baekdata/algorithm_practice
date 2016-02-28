
public class test127 {
	public static void main(String[] args){
		for(int i=1; i<14; i++){
			System.out.print(fact(i)+ " ");
		}
	}
	
	public static int fact(int m){
		int temp=0;
		
		if(m==1||m==0){
			temp = 1;
		}else if(m>1){
			temp = m*fact(m-1);
		}
		
		return temp;
	}
}
