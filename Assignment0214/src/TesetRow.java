import java.util.ArrayList;
import java.util.Scanner;
public class TesetRow {
	public static void main(String[] args){ // 줄세우기
		// 값 가져와서 넣을 때 그거 필요 // 삽입정렬 처럼 이용하면 될듯		

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		//		int arr[] = new int[row];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int select[] = new int[row];

		for(int i=0; i<row; i++){
			select[i] = sc.nextInt();
		}

		for(int i=0; i<row; i++){ // arraylist활용 시 밀릴 수 있다.
			int temp = 0;
			if(select[i]>0){// 삽입정렬처럼 넣는 방법 하도록 하자
				//				temp = arr[i-select[i]];
				//				for(int j=1; j<=select[i]; j++){
				//					arr[i-j]=arr[i];
				//				}
				//list로 add활용 
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