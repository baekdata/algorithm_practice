package Algorithm;

public class sdsInternTest {
	public static void main(String[] args){
		String input = "1122431220";
		int length = input.length();
		char ch;
		
		for(int i=0; i<length; i++){
			ch = input.charAt(i);
			for(int j=i+1; j<length; j++){
				if(ch==input.charAt(j)){
					System.out.print(j+" ");
					if(++ch == input.charAt(j+1)){
						System.out.println("일치");
						if(++ch == input.charAt(j+1)){
							System.out.println("일치2");
						}
					}
				}
			}
			System.out.println();
		}
	}
}