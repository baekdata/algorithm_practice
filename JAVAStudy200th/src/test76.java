
public class test76 {
	public static void main(String args[]){
		int a[]	= { 8,4,3,2,5};
		int b[] = {4,3,2,5,4};
		
		int c[] = a;
		int []d = (int[])b.clone();
		
		System.out.println(a[1]);
		System.out.println(c[1]);
		System.out.println(d[1]);
		
		
	}
}
