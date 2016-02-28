package Algorithm;
import java.util.LinkedList;
public class stackcoupangenter {
	public static void main(String[] args){
		String input="(()()())";
		String[] a = new String[input.length()];
		LinkedList<String> lk = new LinkedList<String>();
		
		for(int i=0; i<input.length(); i++){
			a[i]=input.charAt(i)+"";
		}
		
		int count=0;
		while(count<input.length()){
			if(a[count].equals("(")){
				lk.add("(");
			}else if(a[count].equals(")")){
				lk.pop();
			}
			count++;
		}
		if(lk.isEmpty()){
			System.out.println("괄호가 정상입니다.");
		}else{
			System.out.println("괄호가 비정상입니다.");
		}
	}
}