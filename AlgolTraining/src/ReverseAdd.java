import java.util.Scanner;
public class ReverseAdd { // Chapter5. 34�� ����� ���ϱ� // testcase���� �ְ�, ���� ���, ���޾� ��°������ ����
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuffer testA = new StringBuffer();
		boolean check = false;
		testA.append(sc.nextLine());
		int ts = Integer.parseInt(testA+""), count = 0, countWhole = 0, sum = 0;
		while(true){ //ȸ���� ������ �ݺ� ������, while��
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