package Algorithm;
import java.util.Scanner;
public class olymTrain {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int sumA=0, sumB=0, sumC=0;
		int tA=0, tB=0, tC=0;
		int[] a = new int[count];
		int[] b = new int[count];
		int[] c = new int[count];

		if(count>=3&&count<=1000){
			for(int i=0; i<count; i++){
				a[i]=sc.nextInt();
				b[i]=sc.nextInt();
				c[i]=sc.nextInt();
				sumA+=a[i];
				if(a[i]==3){
					tA++;
				}else if(b[i]==3){
					tB++;
				}else if(c[i]==3){
					tC++;
				}
				sumB+=b[i];
				sumC+=c[i];
			}

			if((sumA>sumB)&&(sumA>sumC)){
				System.out.println("1"+sumA);
			}else if((sumB>sumA)&&(sumB>sumC)){
				System.out.println("2"+sumB);
			}else if((sumC>sumA)&&(sumC>sumB)){
				System.out.println("3"+sumC);
			}else if((sumA==sumB)&&(sumB>sumC)){
				if(tA>tB){
					System.out.println("1 "+sumA);
				}else{
					System.out.println("2 "+sumB);
				}
			}else if((sumB==sumC)&&(sumB>sumA)){
				if(tC>tB){
					System.out.println("3 "+sumC);
				}else{
					System.out.println("2 "+sumB);
				}
			}else if((sumA==sumC)&&(sumA>sumB)){
				if(tA>tC){
					System.out.println("1 "+sumA);
				}else{
					System.out.println("3 "+sumC);
				}
			}
			sc.close();
		}else{
			System.out.println("count의 개수가 틀렸습니다.");
		}
	}
}