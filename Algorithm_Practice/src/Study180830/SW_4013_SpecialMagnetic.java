package Study180830;
import java.util.ArrayList;
import java.util.Scanner;

public class SW_4013_SpecialMagnetic { // 특이한 자석
	static int testCase, k; // 테스트케이스, 명령문 수 
	static ArrayList<Integer> magnetic[] = new ArrayList[4]; // 8개 길이의 자석 4개 // arraylist 배열 
	static ArrayList<Instruction> instruct = new ArrayList<>(); //TODO stack은 뒤에서부터이다. 명심.
	static int[] score = {1, 2, 4, 8}; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for(int s =0; s<testCase; s++) {
			k = sc.nextInt();
			for(int i=0; i<4; i++) {
				magnetic[i] = new ArrayList<Integer>(); // 각각 생성 필요 
			}

			for(int i=0; i<4; i++) { // 자석 모양 입력 
				for(int j=0; j<8; j++) {
					magnetic[i].add(sc.nextInt());
				}
			}

			for(int i=0; i<k; i++) { // 명령어 입력 순서대로 
				instruct.add(new Instruction(sc.nextInt(), sc.nextInt()));
			}

			while(instruct.size()>0) {
				Instruction now = instruct.remove(0);
				int nowMagnetic = now.chainNum;
				int nowCount = now.count;
				moveMagnetic(nowMagnetic, nowCount);
			}

			int result = 0;
			for(int i=0; i<4; i++) {
				if(magnetic[i].get(0) == 1) {
					result += score[i];
				}
			}
			System.out.println("#"+(s+1)+" "+result);
		}
		sc.close();
	}

	public static void moveMagnetic(int mag, int count) { // 완전탐색 
		boolean a = false, b = false, c = false, d = false; // 각 자석 움직일지 체크 변수 
		int countA = 1, countB = -1, countC = 1, countD = -1; // 각 자석 방향 변화 체크 변수 

		switch(mag) {
		case 1: // 2, 3, 4랑 비교 // 2움직이면 3, 3움직이면 4 순차적 //
			a = true; 
			if(count!=1) {
				countA = -1; countB = 1; countC = -1; countD = 1;
			}
			if(magnetic[0].get(2) != magnetic[1].get(6)) b = true;
			if(b && (magnetic[1].get(2) != magnetic[2].get(6))) c = true;
			if(c && (magnetic[2].get(2) != magnetic[3].get(6))) d = true;

			break;
		case 2: // 1, 3, 4랑 비교 // 1 체크, 3 체크 후 움직이면 4 순차적 //
			if(count==1) {
				countA = -1; countB = 1; countC = -1; countD = 1;
			}
			b = true;
			if(magnetic[1].get(6) != magnetic[0].get(2)) a = true;
			if(magnetic[1].get(2) != magnetic[2].get(6)) c = true;
			if(c && (magnetic[2].get(2) != magnetic[3].get(6))) d = true;
			break;
		case 3: // 1, 2, 4랑 비교 // 4 체크,  체크 후 움직이면 1 순차적 //
			if(count!=1) {
				countA = -1; countB = 1; countC = -1; countD = 1;
			}
			c = true;
			if(magnetic[2].get(2) != magnetic[3].get(6)) d = true;
			if(magnetic[2].get(6) != magnetic[1].get(2)) b = true;
			if(b && (magnetic[1].get(6) != magnetic[0].get(2))) a = true;
			break;
		case 4: // 3, 2, 1랑 비교 // 3 움직이면 2, 2움직이면 1 순차적 // 
			if(count==1) {
				countA = -1; countB = 1; countC = -1; countD = 1;
			}
			d = true;
			if(magnetic[3].get(6) != magnetic[2].get(2)) c = true;
			if(c && (magnetic[2].get(6) != magnetic[1].get(2))) b = true;
			if(b && (magnetic[1].get(6) != magnetic[0].get(2))) a = true;
			break;
		}

		if(d) goMagnetic(magnetic[3], countD);
		if(c) goMagnetic(magnetic[2], countC);
		if(b) goMagnetic(magnetic[1], countB); //반대방향 
		if(a) goMagnetic(magnetic[0], countA);
	}

	public static void goMagnetic(ArrayList<Integer> mag, int count) {
		if(count == 1) { // 시계방향 
			int temp = mag.get(7);
			mag.remove(7);
			mag.add(0, temp);
		}else { // 반시계방향 
			int temp = mag.get(0);
			mag.remove(0);
			mag.add(temp);
		}
	}
}

class Instruction{ // 체인 명령어 
	int chainNum;
	int count;

	public Instruction(int x, int y) {
		chainNum = x;
		count = y;
	}
}