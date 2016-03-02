import java.math.BigInteger;
import java.util.Scanner;
public class Fibonacci{ // Chapter 06. 조합론. 문제 41번. 피보나치의 개수 / BigInteger활용
	static int MAX = 501; // 큰 수 사용할 때 자주 사용, BigInteger
	static BigInteger fibonaci[] = new BigInteger[MAX];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fibo();
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		int index=0, begin = 0, end = 0;
		while(true){
			if(a.compareTo(fibonaci[index])==1) // BigInteger는 compareTo로 비교
				begin = index;
			if(b.compareTo(fibonaci[index])==-1){ //1, 0, -1 return value
				end = index-1; 
				break;
			}index++;
		}
		System.out.println(end-begin);
		sc.close();
	}
	public static void Fibo() {
		fibonaci[0] = BigInteger.ONE; // 숫자 1이라는 상수값을 BigInteger로 표현
		fibonaci[1] = new BigInteger("2"); // 2라는 값 표현
		for (int i = 2; i < MAX; i++) // 피보나치 배열 생성
			fibonaci[i] = fibonaci[i - 1].add(fibonaci[i - 2]); 
	} // fib(i-1) + fib(i-2)값을 BigInteger로 나타낸다.
}