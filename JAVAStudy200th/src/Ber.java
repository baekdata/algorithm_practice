public class Ber { // 베르나르베르르르
	public int toInt(String a){
		return Integer.parseInt(a.trim());
	}
	
	public String toString(int a){
		return (a+"");
	}
	
	public String toStrings(int m, int n){
		return (m+n+"");
	}
	
	public int toInt(String a, int n){
		return (a.charAt(n)-'0');
	}
	
	public int length(int a){
		return (a+"").length();
	}
	
	public int length(String a){
		return a.length();
	}
	
	public int[] toArray(String s){
		int count = s.length();
		int[] qui = new int[count];
		for(int i=0; i<count; i++){
			qui[i]=s.charAt(i)-'0';
		}
		return qui;
	}
	
	public String make(String s){
		int count = length(s);
		StringBuffer sb = new StringBuffer();
		int tcount = 0;
		while(count>tcount){
			String tes = make(s, tcount);
			sb.append(tes);
			tcount+=toInt(tes, 1);
		}
		return sb.toString();
	}
	
	public String make(String s, int n){
		int count = length(s);
		int tempCount = 0;
		StringBuffer sb = new StringBuffer();
		int []qui = toArray(s);
		int num = toInt(s,n);
		
		for(int i=n; i<count; i++){
			if(num==qui[i]){
				tempCount++;
			}else{
				sb.append(toStrings(num, tempCount));
				break;
			}
			if(i==count-1){
				sb.append(toStrings(num, tempCount));
				break;
			}
		}
		return sb.toString();
	}
	
	public void make(int n){
		String s = "1";
		for(int i=0; i<n; i++){
			s= make(s);
		}
		print(this.toArray(s));
		}
	
	public static void print(int []a){
		int m = a.length;
		for(int i=0; i<m; i++){
			System.out.print(a[i]);
		}
		System.out.print("\t\tcount:  "+m);
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
