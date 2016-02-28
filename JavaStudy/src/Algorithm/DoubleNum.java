package Algorithm;
import java.util.ArrayList;
class DoubleNum{
	public static void main(String[] args){
		int[] a = {1, 2, 3, 5, 7, 10};
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int s=0;
		int target =0;
		int numCount=0;

		ar.add(a[0]);
		for(int i=1; i<a.length; i++){
			target=a[i];
			ar.add(a[i]);
			s = ar.size();
			if(isTest(s, ar, target)){
				numCount++;
			}
		}
		System.out.println(numCount);
	}

	public static boolean isTest(int t, ArrayList<Integer> a, int s){
		for(int i=0; i<t; i++){
			for(int j=0; j<t; j++){
				for(int k=0; k<t; k++){
					if((a.get(i)+a.get(j)+a.get(k))==s){
						System.out.println("5¹ß°ß");
						return true;
					}
				}
			}
		}
		return false;
	}
}