import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class tEstETest33{
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			String line = in.nextLine();
			System.out.println(line);
			Scanner sc = new Scanner(line);
			
			List<Integer> arrStack = new ArrayList<Integer>(); // arraylist 생성, stack
			while (sc.hasNextInt()) {
				arrStack.add(sc.nextInt());
			} // 숫자 input

			int i = arrStack.size()-1;
			while (!isSorted(arrStack) && i >= 0) {//제 자리에 있지 않은 최대값 찾기
				int maxIndex = i;
				for (int j = i - 1; j >= 0; j--) {
					if (arrStack.get(j) > arrStack.get(maxIndex)) {
						maxIndex = j;
					}
				}

				if (maxIndex != i) {
					int maxPos = arrStack.size() - maxIndex;
					int iPos   = arrStack.size() - i;
					if (maxIndex != 0) {
						flip(arrStack, maxPos);
					}
					if (!isSorted(arrStack)) {
						flip(arrStack, iPos);
					}
				}
				i--;
			}
			System.out.println(0);
			sc.close();
		}
		in.close();
	}
	
	public static void flip(List<Integer> stack, int position) {
		int index = stack.size() - position;
		Collections.reverse(stack.subList(0, index + 1));
		System.out.print(position + " ");
	}
	
	public static boolean isSorted(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i+1)) {
				return false;
			}
		}
		return true;
	}
}