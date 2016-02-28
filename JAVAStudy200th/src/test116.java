
public class test116 { //로또 만들기
	public static void main(String args[]){
		int lotto = 0; //초기화
		int i =0; 
		boolean flag = true;

		int a[] = {0,0,0,0,0,0};

		while(a[5]==0){
			flag = true;
			lotto = (int)(Math.random()*45)+1;
			for(int j=0; j<i+1; j++){
				if(a[j]==lotto){
					flag = false;
				}
			}

			if(flag){
				a[i]=lotto;
				i++;
			}
		}

		for(int k=0; k<a.length; k++){
			System.out.print(a[k]+" ");
		}
	}
}

//int b =(int)(Math.random()*45)+1;