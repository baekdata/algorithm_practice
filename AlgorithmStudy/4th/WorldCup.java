import java.util.Scanner;

public class WorldCup {
	
	
	private static void Game_Calc(Game_data[] world) {
		
		for(int i=0; i<4;i++){
			Game_data test_data = world[i];
				if(wold_comp(test_data.Mat)==1&Game_Calc_sum(test_data.Mat)==1 & Draw_test(test_data.Mat)==1){
					System.out.print(1+" ");
				}
				else
					System.out.print(0+" ");
		}
	}
	static int wold_comp(int[][] mat){
		int temp;
		int res=1;
		int j=0;
		int sumtepm=0;
		for(int i=0; i<6;i++){
			temp= mat[i][0];
			j=0;
			while(temp>0&j<6){
				for(int k=0;k<6;k++){
					sumtepm+=mat[k][2];
				}
				if(sumtepm<=0)
					break;
				else if(mat[j][2]>0 & i!=j){
					mat[j][2]--;
					temp--;
				}
				j++;
			}
		}
		for(int k=0;k<6;k++){
			sumtepm+=mat[k][0];
			sumtepm+=mat[k][2];
		}
		if(sumtepm>0)
			return 0;
		else
			return 1;
			
		
		
	}
		
	static int Game_Calc_sum(int[][] mat){
		int win_sum=0;
		int lose_sum=0;
		int draw_sum=0;
		int sum=0;
		for(int j=0;j<6;j++){
			win_sum+=mat[j][0];  // 승리 합.
			draw_sum+=mat[j][1];
			lose_sum+=mat[j][2];  // 승리 합.
		}
		sum=win_sum+draw_sum+lose_sum;
		
		
		if(sum!=30| win_sum !=lose_sum){
			return 0;
		}
		else{
			for(int k=0;k<win_sum;k++){
				for(int i=0;i<6;i++){
					for(int j=0;j<6;j++){
						if(mat[i][0]>0&mat[j][2]>0){
							mat[i][0]--;
							mat[j][2]--;
						}
					}
				}
			}
		win_sum=0;
		lose_sum=0;
			for(int j=0;j<6;j++){
				win_sum+=mat[j][0];  // 승리 합.
				lose_sum+=mat[j][2];  // 승리 합.
			}
		if(win_sum!=0 | lose_sum!=0)
			return 0;
		else 
			return 1;
		}
			
	}

		static int Draw_test(int[][] draw){
			int sum=0;
			for(int i=0; i<draw.length;i++)
				sum+=draw[i][1];
			for(int i=0; i<sum/2;i++){
				for(int j=0;j<5;j++){
					for(int k=j+1;k<6;k++){
						if(draw[j][1]>0 & draw[k][1]>0){
							draw[j][1]--;
							draw[k][1]--;
						}
						
					}
				}
			}
			int res=0;
			for(int i=0; i<draw.length;i++)
				res+=draw[i][1];
			if(res==0)
				return 1;
			else
				return 0;
		}

	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		Game_data[] world = new Game_data[4];
		
		for(int k=0; k<4;k++){
			world[k]= new Game_data();
			for(int i=0; i<6; i++){
				for(int j=0; j<3;j++){
					world[k].Game_add(i, j, scan.nextInt());
				}
			}
			//System.out.println(world.Mat[0][0]);
			
		}
		Game_Calc(world);
	}
}
class Game_data{
	
	int [][] Mat =  new int[6][3];
	
	protected void Game_add(int i, int j, int val){
		
		this.Mat[i][j]=val;
		//System.out.println(this.Mat[i][j]);
		
	}	
}
4 0 1 
4 0 1 
3 2 0 
1 1 3 
1 1 3 
0 0 5
