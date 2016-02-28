package Algorithm;
import java.util.Scanner;
public class AntNew {
	public static void main(String[] args) {
		int a[] = new int[1000]; // 배열 생성 및 초기화
		int b[] = new int[1000];
		a[0] = 1; // 초기값 지정 // a[0]외에는 모두 0으로 자동 초기화
		b[0] = 0;
		int row, count, l, i, j, k;
		System.out.print("원하는 줄 갯수 입력 : ");

		Scanner input = new Scanner(System.in);
		row = input.nextInt(); // 원하는 input값 받기
		System.out.println("\n"+a[0]); // 초기 주어진 값 출력 // 1

		for (j = 1; j < row; ++j) { // 원하는 줄 수만큼 반복
			i = 0;
			l = 0;
			count = 1;
			while (a[i] != 0) {
				if (a[i] == a[i + 1]){ // 다음 항목과 같을 경우 count증가
					++count;
				}else {
					b[l] = a[i]; // 다를 경우, 다른 배열 b항목에 현재 배열값 넣기
					System.out.print(b[l]);
					++l;

					b[l] = count;
					System.out.print(b[l]);
					++l;
					count = 1;
				}
				++i;
			}
			for (k = 1; k < 100; ++k) {
				a[k] = b[k];
				b[k] = 0;
			}
			System.out.println();
		}
		System.out.println("\nThe End");
	}
}