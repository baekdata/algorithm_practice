
public class test117 { //로또 만들기 // 2차원 배열
	public static void main(String args[]){

		int a[][] = new int[2][10];
		int flag = 0;
		int lotto = 0;
		int i=0;


		while(a[0][9]==0){
			lotto = (int)(Math.random()*10)+1;

			for(int j=0; j<a.length; j++){
				if((a[0][j]!=lotto)&&(a[1][i]!=2)){
					a[1][i]++;
					a[0][i]=lotto;
					i++;
				}
			}
		}

		for(int e=0; e<10; e++){
			System.out.print(a[0][e]+" ");
		}
	}	
}

//int b =(int)(Math.random()*45)+1;