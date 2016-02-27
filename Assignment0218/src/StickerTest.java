import java.util.Scanner;


public class StickerTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;
		int count = 0;

		int[][] ar = new int[2][n];

		for(int i=0; i<2; i++){
			for(int j=0; j<n; j++){
				ar[i][j] = sc.nextInt();
			}
		}
		boolean check = false;
		while(true){
			int max = 0;
			int max2=0;
			int indexFirst=0;
			int indexFirst2=0;
			if(!check){
				for(int i=0; i<n; i++){
					if(max<ar[0][i]){
						max = ar[0][i];
						indexFirst = i;
					}
					check = true;
				} // 첫 줄에 대해 최대값 구함.
				if(count<=n+1){
					sum += max;
					max = 0;
					if((indexFirst-1)>=0){
						ar[0][indexFirst-1] = 0;
					}
					if((indexFirst+1)<n){
						ar[0][indexFirst+1] = 0;
					}
					ar[0][indexFirst] = 0;
					ar[1][indexFirst] =0;
					++count;
				}else{
					break;
				}
			}else{
				for(int i=0; i<n; i++){
					if(max<ar[0][i]){
						max2 = ar[1][i];
						indexFirst2 = i;
					}
					check = false;
				}
				if(count<=n+1){
					sum += max2;
					max2 = 0;
					if((indexFirst2-1)>=0){
						ar[1][indexFirst2-1] = 0;
					}
					if((indexFirst2+1)<n){
						ar[1][indexFirst2+1] = 0;
					}
					ar[1][indexFirst2] = 0;
					ar[0][indexFirst2] =0;
					count++;
				}else{
					break;
				}
			}
		}
		System.out.println(sum);
	}
}