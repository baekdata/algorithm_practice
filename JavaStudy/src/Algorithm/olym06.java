package Algorithm;
import java.util.Scanner;
public class olym06{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[][] a = new int[10][10];
		int[] result = new int[3];
		
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
                if(a[i][j]==0||a[i][j]==1){
                    a[i][j] = input.nextInt();    
                }else{
                     System.out.println("잘못된 입력입니다.");
                     continue;
                }				
			}
		}
        		input.close();

		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
				result[i]+=a[i][j];
			}
		}
		
		for(int k=0; k<3; k++){
			if(result[k]==0){
				System.out.println("D");
			}else if(result[k]==1){
				System.out.println("C");
			}else if(result[k]==2){
				System.out.println("B");
			}else if(result[k]==3){
				System.out.println("A");
			}else{
				System.out.println("E");
			}
		}
	}
}