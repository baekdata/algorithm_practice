public class test35 { // 최대공약수, 유클리드 호제법, 최대공약수를 구하는 법으로 같은 수가 될 때까지 큰 수에서 작은 수를 빼는 과정 반복
	public static void main(String[] args){
		int m = 150;
		int n = 350;
		
		while(m!=n){
			System.out.print((m)+"과  "+(n)+"입니다.");
			if(m>n)
				m-=n;
			else if(n>m)
				n-=m;
		}
		System.out.println();
		System.out.println("최대 공약수 "+m+"입니다.");
	}
}
