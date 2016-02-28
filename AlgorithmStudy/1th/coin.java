import java.util.Scanner;

public class Test0203_01 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int d[] = new int[64001];
		int coin[] = new int[10];
		int count=sc.nextInt();
		
		for(int i=0; i<count; i++)
			coin[i]=sc.nextInt();

		int money=sc.nextInt();
		
		for(int j=1; j<=money; j++){
			d[j]=64000;
		}
		
		d[0]=0;
		for(int j=0; j<count; j++){
			d[coin[j]]=1;
			for(int k=coin[j]; k<=money; k++){
				d[k]= min(d[k], d[k-coin[j]]+1);
			}
		}
		
		if(d[money]==10000){
			System.out.println("impossible");
		}else{
			System.out.println(d[money]);
		}
	}
	
	static int min(int a, int b){
		if(a<=b){
			return a;
		}else{
			return b;
		}
	}
}