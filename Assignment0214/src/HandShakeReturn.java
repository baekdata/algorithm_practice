import java.util.Scanner;

public class HandShakeReturn { // ���� // ���̳��� ���α׷���
	static int[] brand = new int[1000];
	static int[][] memo = new int[1000][1000];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc. nextInt();
		for(int i=0; i<n; i++)
			brand[i] = sc.nextInt();
			
		for(int i=0; i<memo.length; i++){ // 2�� �迭 -1�� �ʱ�ȭ
			for(int j=0; j<memo.length; j++)
				memo[i][j] = -1;
		}
		System.out.println(solve(0, n-1));
	}
	
	static int solve(int s, int e){
		if(s>e) return 0;
		if(memo[s][e]!=-1)
			return memo[s][e];
		int aux = 0;
		for(int i=s+1; i<=e; i+=2) // �� �κ��� �� �߿�, �ٽ� Ȯ�� �ʿ�
			aux=Math.max(aux, ((brand[s]==brand[i] ? 1:0) + solve(s+1, i-1) + solve(i+1, e)));
			// ���� ��쿡 ���ؼ� ��ͷ� �Ǻ� �ϸ鼭 �ִ밪 ����
		memo[s][e] = aux;
		return aux;
	}
}