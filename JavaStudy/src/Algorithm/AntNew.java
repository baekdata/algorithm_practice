package Algorithm;
import java.util.Scanner;
public class AntNew {
	public static void main(String[] args) {
		int a[] = new int[1000]; // �迭 ���� �� �ʱ�ȭ
		int b[] = new int[1000];
		a[0] = 1; // �ʱⰪ ���� // a[0]�ܿ��� ��� 0���� �ڵ� �ʱ�ȭ
		b[0] = 0;
		int row, count, l, i, j, k;
		System.out.print("���ϴ� �� ���� �Է� : ");

		Scanner input = new Scanner(System.in);
		row = input.nextInt(); // ���ϴ� input�� �ޱ�
		System.out.println("\n"+a[0]); // �ʱ� �־��� �� ��� // 1

		for (j = 1; j < row; ++j) { // ���ϴ� �� ����ŭ �ݺ�
			i = 0;
			l = 0;
			count = 1;
			while (a[i] != 0) {
				if (a[i] == a[i + 1]){ // ���� �׸�� ���� ��� count����
					++count;
				}else {
					b[l] = a[i]; // �ٸ� ���, �ٸ� �迭 b�׸� ���� �迭�� �ֱ�
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