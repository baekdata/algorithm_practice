import java.util.Scanner;

public class KnappingSet { // 정올 배낭채우기 // OK // 점화식 이해 //  다이나믹 //
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 보석 개수
		int W = sc.nextInt(); // 배낭 부피
		
		int[][] J = new int[N][2];
		
		for(int i=0; i<N; i++){
			J[i][0] = sc.nextInt();
			J[i][1] = sc.nextInt();
		}
		sc.close();
		
		int[] C = new int[W+1]; // dp같은 역할
		
		for(int i=1; i<W+1; i++){ // 하나씩 계산해서 dp구현
			int maxCost = 0; //최대값 지정
			
			for(int j=0; j<N; j++){
				if(i-J[j][0]>=0 && C[i-J[j][0]]+J[j][1]>maxCost){
					maxCost = C[i-J[j][0]] + J[j][1];
				}
			}
			C[i] = maxCost;
		}
		System.out.println(C[W]);
	}
}