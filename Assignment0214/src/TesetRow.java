import java.util.ArrayList;
import java.util.Scanner;
public class TesetRow {
	public static void main(String[] args){ // �ټ����
		// �� �����ͼ� ���� �� �װ� �ʿ� // �������� ó�� �̿��ϸ� �ɵ�		

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		//		int arr[] = new int[row];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int select[] = new int[row];

		for(int i=0; i<row; i++){
			select[i] = sc.nextInt();
		}

		for(int i=0; i<row; i++){ // arraylistȰ�� �� �и� �� �ִ�.
			int temp = 0;
			if(select[i]>0){// ��������ó�� �ִ� ��� �ϵ��� ����
				//				temp = arr[i-select[i]];
				//				for(int j=1; j<=select[i]; j++){
				//					arr[i-j]=arr[i];
				//				}
				//list�� addȰ�� 
				arr.add((i)-select[i], i+1);
			}else{
				arr.add(i+1);
			}
		}
		for(int i=0; i<row; i++){
			System.out.print(arr.get(i)+ " ");
		}
	}
}