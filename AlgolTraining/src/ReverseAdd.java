import java.util.Scanner;
public class ReverseAdd { // Chapter5. 34번 뒤집어서 더하기 // testcase집어 넣고, 성능 고민, 연달아 출력가능토록 수정
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuffer testA = new StringBuffer();
		boolean check = false;
		testA.append(sc.nextLine());
		int ts = Integer.parseInt(testA+""), count = 0, countWhole = 0, sum = 0;
		while(true){ //회문일 때까지 반복 돌려서, while문
			if(check){
				testA.append(sum);
				ts = Integer.parseInt(testA+"");
			} 
			countWhole++;
			StringBuffer reverseSt = testA.reverse();
			int ts2 = Integer.parseInt(reverseSt+"");
			sum = 0;
			sum += (ts+ts2);
			testA.delete(0, testA.length());
			check = true;
			
			String testSet = sum + "";
			for(int i=0; i<testSet.length()/2; i++){
				if(testSet.charAt(i)==testSet.charAt(testSet.length()-(i+1)))
					count++;
				else
					break;
			}
			if(count == (testSet.length()/2)){
				System.out.print(countWhole+" "+sum);
				break;
			}
		} sc.close();
	}
}