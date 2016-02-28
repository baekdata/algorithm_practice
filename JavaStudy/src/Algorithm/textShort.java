package Algorithm;

public class textShort {
	public static void main(String[] args){
		String input = "aaabbcccccca";
		char tmp; int t=0, s=0;
		tmp = input.charAt(0);
		int count =1, is=0; int [] a = new int[20];
		String [] b = new String[20];

		for(int i=0; i<input.length()-1; i++){
			if(tmp==input.charAt(i)){
				count++;
			}else{
				tmp = input.charAt(i);
				System.out.println(tmp);
				a[is]=count;
				b[is]=input.charAt(i-1)+"";
				count=1;
				is++;
			}
		}
		
		for(int p=0; p<a.length-1; p++){
			if(a[p]==0){
				break;
			}
			System.out.print(b[p]);
			System.out.print(a[p]);
			if(p==a.length-1){
				System.out.println(a[p]+b[p]);
			}
		}
	}
}