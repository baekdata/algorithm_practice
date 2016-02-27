import java.util.Scanner;
public class Train { // �ִܰŸ�, Floyd// �������� // �˰��� �� �� ���
	static int[][] trainMap = new int[101][101]; // ��庰 �ɸ��� �ð�
	static int[][] midSpot = new int[101][101]; // �߰����
	static int subNum, trainObjNum;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		subNum = sc.nextInt();
		trainObjNum = sc.nextInt();
		
		for(int i=1; i<=subNum; i++){
			for(int j=1; j<=subNum; j++)
				trainMap[i][j] = sc.nextInt();
		}
		floyd();
	}

	static void floyd(){ //3�� for������ ���������� �ٸ� ���� �ɸ��� �ִܰŸ� ����
		for(int k=1; k<=subNum; k++){
			for(int j=1; j<=subNum; j++){
				for(int i=1; i<=subNum; i++){
					if(i==j)
						continue;
					if((trainMap[i][k] + trainMap[k][j]<trainMap[i][j])){
						trainMap[i][j] = trainMap[i][k] + trainMap[k][j];
						midSpot[i][j] = k; // ���ǿ� ���� ��� ������ ���� ����
					}
				}
			}
		}
		System.out.println(trainMap[1][trainObjNum]);
		System.out.print(1);
		tracking(1, trainObjNum);
		System.out.print(" "+trainObjNum);
		System.out.println();
		System.out.println();
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(trainMap[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void tracking(int start, int end){
		if(midSpot[start][end]!=0){ // ó��->������, �� ������ �߰����� ��� ��ͷ� Ȯ��
			tracking(start, midSpot[start][end]);
			System.out.print(" "+midSpot[start][end]); // �߰����� ���
			tracking(midSpot[start][end], end);
		}
	}
}