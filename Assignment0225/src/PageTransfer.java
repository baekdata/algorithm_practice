import java.io.BufferedReader;
import java.io.InputStreamReader;
public class PageTransfer{ // �ִܰŸ� ���ͽ�Ʈ�� �̿�, �̰� ���ϸ� ���� �׾����// Ȯ���� ���� ������  // �ִܰŸ� //  ����� �ڵ� ã�Ƽ� ����� �����ϱ�
	public static void main(String[] arg) throws Exception { // �ϴ� ���ͽ�Ʈ�� ����� ���ذ� �� �߿��ϴ�
		int n = 4;
		int m = 5000;
		int i, j, k = 0, start=0, end, min;
		int[] vertex = new int[4];//������ Ž������
		int[] distance = new int[4];//����ġ 
		int[] via = new int[4];//������ ��������

		int[][] data = { { 0, 1, 1, m},
				{m,0,m,1},
				{1,m,0,m},
				{m,m,1,0}
		};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		System.out.print("\n����� : ");
		//		start = Integer.parseInt(br.readLine());
		//		System.out.print("\n������ : ");
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
			//		System.out.printf("�ִ� �Ÿ��� %d�Դϴ�.\n", distance[end]);
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
			//		System.out.print(" ��δ� : ");
			//		for (i = path_cnt - 1; i >= 1; i--) {
			//			System.out.printf("%d -> ", path[i]);
			//		}
			//		System.out.printf("%d�Դϴ�", path[i]);
			start++;
		}
		for(int x=0; x<4; x++){
			for(int q=0; q<4; q++){
				System.out.print(data[x][q]+" ");
			}System.out.println();
		}
	}
}