import java.math.BigInteger;
import java.util.Scanner;
public class Fibonacci{ // Chapter 06. ���շ�. ���� 41��. �Ǻ���ġ�� ���� / BigIntegerȰ��
	static int MAX = 501; // ū �� ����� �� ���� ���, BigInteger
	static BigInteger fibonaci[] = new BigInteger[MAX];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fibo();
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		int index=0, begin = 0, end = 0;
		while(true){
			if(a.compareTo(fibonaci[index])==1) // BigInteger�� compareTo�� ��
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
		fibonaci[0] = BigInteger.ONE; // ���� 1�̶�� ������� BigInteger�� ǥ��
		fibonaci[1] = new BigInteger("2"); // 2��� �� ǥ��
		for (int i = 2; i < MAX; i++) // �Ǻ���ġ �迭 ����
			fibonaci[i] = fibonaci[i - 1].add(fibonaci[i - 2]); 
	} // fib(i-1) + fib(i-2)���� BigInteger�� ��Ÿ����.
}