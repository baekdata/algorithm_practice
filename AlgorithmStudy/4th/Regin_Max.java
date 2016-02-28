import java.util.Scanner;

class Region{
	int a;
	int b;
	void add(int a, int b){
		this.a=a;
		this.b=b;
	}
}

public class Regin_Max {	
	private static void Regin_Cal(){
		
	}
	public static void main(String[] args) {
		int N, Q;
		Scanner scan =new Scanner(System.in);
		N=scan.nextInt();
		Q=scan.nextInt();
		
		Region[] region = new Region[Q];
		int[] Max= new int[Q];
		
		int[] Arr = new int[N+1];
		for(int i=1; i<=N;i++){
			Arr[i]=scan.nextInt();
		}
		for(int i=0;i<Q;i++){
			region[i]= new Region();
			region[i].add(scan.nextInt(), scan.nextInt());
		}
		
		for(int i=0; i<Q; i++){
			for(int j= region[i].a; j<=region[i].b;j++){
				if(Max[i]<Arr[j]){
					Max[i]=Arr[j];
				}
			}
		}
		for(int i=0; i<Q;i++)
			System.out.println(Max[i]);
	}

}
