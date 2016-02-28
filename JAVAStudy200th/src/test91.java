import java.util.Arrays;


public class test91 {
	public static void main(String[] args){
		int []a = {5,4,3,6,2,9};
		int []b = {1,5,3,2,6,7};
		int []c = new int[a.length];
		
		System.arraycopy(a, 0, c, 0, a.length);
		System.out.println(Arrays.equals(a, c));
		Arrays.fill(a,-5);
		Arrays.sort(c);
		
		for(int i=0; i<c.length; i++){
			System.out.print(c[i]);
		}
		System.out.println();
	}

}
