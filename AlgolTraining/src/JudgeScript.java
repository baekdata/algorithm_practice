import java.util.Scanner;
class JudgeScript{ // Chapter03. �ڵ��ɻ罺ũ��Ʈ
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int run = 0;
		while(true){
			run++; // �� case����
			String line = sc.nextLine();
			int n = Integer.parseInt(line); // ���� �ް� enter�ϸ� nextInt�϶��� �ڲ� ���� �̷��� ó�� �ʿ�
			if (n == 0) break; // 0�Է� �� ����

			StringBuilder goodLines = new StringBuilder(); //stringbuilder
			StringBuilder goodNums = new StringBuilder(); // String���� StringBuilder���
			calculateInput(sc, n, goodLines, goodNums); // Scanner, ���� count, �� string ���� �ѱ�

			int m = Integer.parseInt(sc.nextLine());
			StringBuilder inLines = new StringBuilder();
			StringBuilder inNums = new StringBuilder();
			calculateInput(sc, m, inLines, inNums);

			System.out.print("Run #"+run+": ");
			if (goodLines.toString().compareTo(inLines.toString()) == 0) {
				System.out.println("Accepted"); // ����, ���� ��� ��ġ
			} else if (goodNums.toString().compareTo(inNums.toString()) == 0) {
				System.out.println("Presentation Error"); // ���ڸ� ��ġ, �������� �������
			} else {
				System.out.println("Wrong Answer"); //�� �� ���
			}
		}
	}
	static void calculateInput(Scanner sc, int numberOfLines, StringBuilder lines, StringBuilder nums) throws Exception {
		String line; // Scanner���� �̷������� �Ѱܼ� �Լ������� �Է¹ޱ�
		for (int i = 0; i < numberOfLines; i++){
			line = sc.nextLine();
			lines.append(line + '\n');
			for (int j = 0; j < line.length(); j++) {
				if (Character.isDigit(line.charAt(j)))  // nums�� ���ڸ� ���� append  
					nums.append(line.charAt(j)); // Stringbuilder�� string�� �޸� ������, string�� ���
			}
		}
	}
}