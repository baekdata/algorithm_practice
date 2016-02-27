import java.io.BufferedReader;
import java.io.InputStreamReader;
public class PageTransfer{ // 최단거리 다익스트라 이용, 이거 못하면 나가 죽어야함// 확실히 유형 익히자  // 최단거리 //  비슷한 코드 찾아서 제대로 이해하기
	public static void main(String[] arg) throws Exception { // 일단 다익스트라 제대로 이해가 젤 중요하다
		int n = 4;
		int m = 5000;
		int i, j, k = 0, start=0, end, min;
		int[] vertex = new int[4];//정점의 탐색여부
		int[] distance = new int[4];//가중치 
		int[] via = new int[4];//정점의 엣지정보

		int[][] data = { { 0, 1, 1, m},
				{m,0,m,1},
				{1,m,0,m},
				{m,m,1,0}
		};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		System.out.print("\n출발점 : ");
		//		start = Integer.parseInt(br.readLine());
		//		System.out.print("\n도착점 : ");
		//		end = Integer.parseInt(br.readLine());


		for (j = 0; j < 4; j++) {
			vertex[j] = 0;
			distance[j] = m;
		}

		while(true){
			if(start==4)
				break;
			distance[start] = 0;
			for (i = 0; i < 4; i++) {
				min = m;
				for (j = 0; j < 4; j++) {
					if (vertex[j] == 0 && distance[j] < min) {
						k = j;
						min = distance[j];
					}
				}
				vertex[k] = 1;
				if (min == m)
					break;

				for (j = 0; j < 4; j++) {
					if (distance[j] > distance[k] + data[k][j]) {
						distance[j] = distance[k] + data[k][j];
						via[j] = k;
					}
				}
			}
			for(int id=0; id<4; id++){
				data[start][id] = distance[id];
			}
			//		System.out.printf("최단 거리는 %d입니다.\n", distance[end]);
			//		int path[] = new int[4];
			//		int path_cnt = 0;
			// 
			//		k = end;
			//		while (true) {
			//			path[path_cnt++] = k;
			//			if (k == start)
			//				break;
			//			k = via[k];
			//		}
			// 
			//		System.out.print(" 경로는 : ");
			//		for (i = path_cnt - 1; i >= 1; i--) {
			//			System.out.printf("%d -> ", path[i]);
			//		}
			//		System.out.printf("%d입니다", path[i]);
			start++;
		}
		for(int x=0; x<4; x++){
			for(int q=0; q<4; q++){
				System.out.print(data[x][q]+" ");
			}System.out.println();
		}
	}
}