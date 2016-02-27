import java.util.Scanner;
public class Train { // 최단거리, Floyd// 문제이해 // 알고리즘 좀 더 고민
	static int[][] trainMap = new int[101][101]; // 노드별 걸리는 시간
	static int[][] midSpot = new int[101][101]; // 중간경로
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

	static void floyd(){ //3중 for문으로 각지역에서 다른 노드로 걸리는 최단거리 저장
		for(int k=1; k<=subNum; k++){
			for(int j=1; j<=subNum; j++){
				for(int i=1; i<=subNum; i++){
					if(i==j)
						continue;
					if((trainMap[i][k] + trainMap[k][j]<trainMap[i][j])){
						trainMap[i][j] = trainMap[i][k] + trainMap[k][j];
						midSpot[i][j] = k; // 조건에 맞을 경우 경유지 따로 저장
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
		if(midSpot[start][end]!=0){ // 처음->도착지, 그 사이의 중간지역 계속 재귀로 확인
			tracking(start, midSpot[start][end]);
			System.out.print(" "+midSpot[start][end]); // 중간지역 출력
			tracking(midSpot[start][end], end);
		}
	}
}