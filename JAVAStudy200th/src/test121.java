
public class test121 {

	public static void main(String[] args){
		int a = 100;
		int []b = new int[100]; //
		int count =0;
		
		for(int i=0; i<a; i++){
				if(100%(i+1)==0){
					b[i]=i;
				}
		}
		
		System.out.print(1+" ");
		for(int j=0; j<a; j++){
			if(b[j]!=0){
				System.out.print((b[j]+1) + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println("count : "+(count+1));
	}
}
