import java.util.Scanner;

public class HandShake { //���� �Ǽ�// ���̳���2 // �ٽ�
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int ar[] = new int[input];
		boolean firstck=true;
		int count =0;

		for(int i=0; i<input; i++){
			ar[i] = sc.nextInt();
		}

		for(int j=0; j<input/2; j++){
			if(firstck){
				for(int k=0; k<input; k+=2){
					if(ar[j+k] == ar[input-(k+1)]){
						count++;
						ar[j+k]=0; ar[input-(k+1)]=0;
					}else{
						break;
					}
				}
				for(int k=0; k<input/2; k++){
					if(ar[j+1+k] == ar[input-(k+1)]){

						//						if(��� �ִ� ���� �ϳ��� �迭�� ���� �� )
						count++;
						ar[j+1+k] = 0; ar[input-(k+1)]=0;
					}else{
						break;
					}
				}

				for(int k=0; k<input/2; k++){
					if(ar[j+k] == ar[input-(k+2)]){
						//						if(��� �ִ� ���� �ϳ��� �迭�� ���� �� )

						ar[j+k]=0; ar[input-(k+2)]=0;
						count++;
					}else{
						break;
					}
				}
			}

			firstck = false;

			if(!firstck){
				for(int k=1; k<input/2; k++){
					if(ar[j] == ar[j+k]){
						ar[j]=0; ar[j+k]=0;
						count++;
					}else{
						break;
					}
				}

				for(int k=1; k<input/2; k++){
					//				if(��� �ִ� ���� �ϳ��� �迭�� ���� �� )

					if(ar[j] == ar[j+1+k]){
						ar[j]=0; ar[j+1+k]=0;
						count++;
					}else{
						break;
					}
				}
			}
		}
		System.out.println(count);
	}
}