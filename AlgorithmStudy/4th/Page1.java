import java.util.Scanner;

public class Page1 {

	public static void main(String[] args) {
		int N;
		int row, col;
		Scanner scan =new Scanner(System.in);
		N=scan.nextInt();
		
		Distance M =new Distance(N);
		for(int i=0; i<N; i++){
			row=scan.nextInt();
			col=scan.nextInt();
			M.addEdge(row-1, col-1);
		}
		M.aPrint();
		
	}
}

class Input{
	protected int N;
	protected int[][] Mat;
	
	public Input(){}
	public Input(int N){
		this.N=N;
		this.Mat = new int[N][N];
	}
	protected void addEdge(int row, int col){
		Mat[row][col] = 1;
	}
	protected void Mat_Zero_9999(){
		for(int i=0; i<Mat.length;i++){
			for(int j=0;j<Mat[i].length;j++){
				if(Mat[i][j]==0 & i!=j){
					Mat[i][j]=9999;
				}
				
			}
		}
	}
	
}

class Distance extends Input{
	int Sum=0;
	public Distance(){}
	public Distance(int n) {
		super(n);
	}
	void Calcul(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<N; k++){
					if(Mat[j][k] > Mat[j][i]+Mat[i][k] ){
						if(Mat[j][i]!=9999 &Mat[i][k]!=9999)
						Mat[j][k]=Mat[j][i]+Mat[i][k];
					}
				}
			}
		}
	}
	public void aPrint(){
		Mat_Zero_9999();
		Calcul();
		
		int Count=0;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				//System.out.print(Mat[i][j]+" ");
				if(Mat[i][j]>0 &Mat[i][j]<9999){
					Sum+=Mat[i][j];
					Count++;
				}
			}//System.out.println();
		}
		System.out.println(Double.parseDouble( String.format( "%.3f" , (double)Sum/Count))); 

	}
}
