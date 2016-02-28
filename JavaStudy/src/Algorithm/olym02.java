package Algorithm;
import java.util.Scanner;
public class olym02 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String a,b,c,d,e;

		String []ArrayA = new String[15];
		String []ArrayB = new String[15];
		String []ArrayC = new String[15];
		String []ArrayD = new String[15];
		String []ArrayE = new String[15];

		a=input.nextLine();
		b=input.nextLine();
		c=input.nextLine();
		d=input.nextLine();
		e=input.nextLine();
		
		input.close();

		int al=0, bl=0, cl=0, dl=0, el=0;

		al = a.length();
		bl = b.length();
		cl = c.length();
		dl = d.length();
		el = e.length();

		if(al>0&&al<=15&&bl>0&&bl<=15&&cl>0&&cl<=15&&dl>0&&dl<=15&&el>0&&el<=15){

			SortMake(al, ArrayA, a);
			SortMake(bl, ArrayB, b);
			SortMake(cl, ArrayC, c);
			SortMake(dl, ArrayD, d);
			SortMake(el, ArrayE, e);

			for(int k=0; k<5; k++){
				if(ArrayA[k]==null){
					ArrayA[k]="";
				}
				if(ArrayB[k]==null){
					ArrayB[k]="";
				}
				if(ArrayC[k]==null){
					ArrayC[k]="";
				}
				if(ArrayD[k]==null){
					ArrayD[k]="";
				}
				if(ArrayE[k]==null){
					ArrayE[k]="";
				}
				System.out.print(ArrayA[k]+ArrayB[k]+ArrayC[k]+ArrayD[k]+ArrayE[k]);
			}
			System.out.println();
		}else{
			System.out.println("입력 값의 범위가 잘못되었습니다.");
		}
	}

	public static void SortMake(int length, String [] Array, String a){
		for(int i=0; i<length; i++){
			Array[i]=a.charAt(i)+"";
		}
	}
}