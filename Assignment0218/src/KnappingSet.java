import java.util.Scanner;

public class KnappingSet { // ���� �賶ä��� // OK // ��ȭ�� ���� //  ���̳��� //
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ���� ����
		int W = sc.nextInt(); // �賶 ����
		
		int[][] J = new int[N][2];
		
		for(int i=0; i<N; i++){
			J[i][0] = sc.nextInt();
			J[i][1] = sc.nextInt();
		}
		sc.close();
		
		int[] C = new int[W+1]; // dp���� ����
		
		for(int i=1; i<W+1; i++){ // �ϳ��� ����ؼ� dp����
			int maxCost = 0; //�ִ밪 ����
			
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