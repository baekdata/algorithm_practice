import java.util.StringTokenizer;


public class LottoAnalysis {
	public String[] getLottos(String s){
		String [] str = new String[10];
		StringTokenizer st = new StringTokenizer(s);
		for(int i=0; i<str.length; i++){
			str[i]=st.nextToken();
		}
		return str;
	}
	
	public int to10(String s){
		String ss = s;
		if(s.charAt(0)=='0'){
			ss = s.replace('0', ' ');
		}
		return Integer.parseInt(ss.trim());
	}
	
	public int[] toInt(String s){
		int [] aa = new int[6];
		StringTokenizer st = new StringTokenizer(s);
		st.nextToken();
		
		for(int i=0; i<aa.length; i++){
			aa[i]=to10(st.nextToken().trim());
		}
		return aa;
	}
}
