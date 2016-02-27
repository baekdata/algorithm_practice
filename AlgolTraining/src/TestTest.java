import java.util.ArrayList;
import java.util.Scanner;
public class TestTest { // Chater04. 26번 문제  팬케이크
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arrCount = new ArrayList<String>();

		StringBuilder arb = new StringBuilder();
		for(int j=0; j<5; j++)
			arb.append(sc.next());
		int inCount=0;
		
		for(int i=0; i<5; i++){
			System.out.print(arb.charAt(i)+" ");
		}
		System.out.println();

		exitFor:
			for(int j=4; j>=0; j--){///////////////////////////////////////////////////다시, 제대로 안됨
				if(!((arb.charAt(j)+"").equals(j+1+"")) && (j==4)){
					arb.reverse();
					arrCount.add("1");
					System.out.println(arb.charAt(j));
					System.out.println("e1");
					
					System.out.println();
					for(int i=0; i<5; i++){
						System.out.print(arb.charAt(i)+" ");
					}
					System.out.println();
					
				}else if(!((arb.charAt(j)+"").equals(j+1+""))){
					char temp = arb.charAt(j);
					arb.deleteCharAt(j);
					arb.reverse();
					arb.append(temp);
					System.out.println("e2");
				}else{
					System.out.println("e3");
					arrCount.add("0");
					break;
				}

				for(int k=4; k>=0; k--){
					if(arb.charAt(k)==(k+1)){ // 문자열 비교 주의
						++inCount;
					}
					if(inCount==5){
						arrCount.add("0");
						break exitFor;
					}
				}
			}

		System.out.println();
		for(int i=0; i<5; i++){
			System.out.print(arb.charAt(i)+" ");
		}
		System.out.println();
		for(int i=0; i<arrCount.size(); i++){
			System.out.print(arrCount.get(i)+" ");
		}
	}
}