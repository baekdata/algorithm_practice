package Algorithm;
import java.util.Scanner;
public class olym07 { // 시간초과 뜸, 다시 해보기 // 09 초등부 수열
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		int [] a = new int[count];
		int Alength=1, Alength02=1;
		int Blength=0, Blength02=0;
		boolean flag = false;
		boolean flag02 = false;

		for(int i=0; i<count; i++){
			a[i]=input.nextInt();
		}
		for(int i=1; i<count; i++){
			int j = i;
			while(a[j-1] <= a[j]){
				if(flag){
					Alength++;
					j++;
				}else{
					Alength02++;
					j++;
				}
				if(j>=count){
					break;
				}
			}
			if(!flag){
				flag = true;
			}
			if(Alength>Alength02){
				Alength02 = Alength;
			}
			Alength=1;
		}

		for(int i=1; i<count; i++){
			int j = i;
			while(a[j-1] >= a[j]&&j<count){
					if(flag02){
						Blength++;
						j++;
					}else{
						Blength02++;
						j++;
					}
				if(j>=count){
					break;
				}
			}
			if(!flag02){
				flag02 = true;
			}
			if(Blength>Blength02){
				Blength02 = Blength;
			}
			Blength=1;
		}

		if(Alength02>=Blength02&&Alength02>=3){
			System.out.println(Alength02);
		}else if(Blength02>=Alength02&&Blength02>=3){
			System.out.println(Blength02);
		}else{
			System.out.println(2);
		}
	}
}