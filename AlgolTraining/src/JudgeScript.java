import java.util.Scanner;
class JudgeScript{ // Chapter03. 자동심사스크립트
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int run = 0;
		while(true){
			run++; // 각 case숫자
			String line = sc.nextLine();
			int n = Integer.parseInt(line); // 숫자 받고 enter하면 nextInt일때는 자꾸 에러 이런식 처리 필요
			if (n == 0) break; // 0입력 시 종료

			StringBuilder goodLines = new StringBuilder(); //stringbuilder
			StringBuilder goodNums = new StringBuilder(); // String말고 StringBuilder사용
			calculateInput(sc, n, goodLines, goodNums); // Scanner, 돌릴 count, 각 string 변수 넘김

			int m = Integer.parseInt(sc.nextLine());
			StringBuilder inLines = new StringBuilder();
			StringBuilder inNums = new StringBuilder();
			calculateInput(sc, m, inLines, inNums);

			System.out.print("Run #"+run+": ");
			if (goodLines.toString().compareTo(inLines.toString()) == 0) {
				System.out.println("Accepted"); // 문자, 숫자 모두 일치
			} else if (goodNums.toString().compareTo(inNums.toString()) == 0) {
				System.out.println("Presentation Error"); // 숫자만 일치, 나머지는 상관없음
			} else {
				System.out.println("Wrong Answer"); //그 외 결과
			}
		}
	}
	static void calculateInput(Scanner sc, int numberOfLines, StringBuilder lines, StringBuilder nums) throws Exception {
		String line; // Scanner값을 이런식으로 넘겨서 함수에서도 입력받기
		for (int i = 0; i < numberOfLines; i++){
			line = sc.nextLine();
			lines.append(line + '\n');
			for (int j = 0; j < line.length(); j++) {
				if (Character.isDigit(line.charAt(j)))  // nums에 숫자만 따로 append  
					nums.append(line.charAt(j)); // Stringbuilder는 string과 달리 가변적, string은 상수
			}
		}
	}
}