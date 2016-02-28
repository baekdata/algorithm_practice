/*
 * 두 개의 배열을 선언하여 입력 받음.
 * 하나의 배열을 기준으로 오름차순으로 정렬하고.
 * 같은 값일 경우 나머지 배열을 기준으로 정렬.
 * 
 * 
 * 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input{
	int Num;
	static int [] SL;
	int [] SW;
	
	public void Input(int Num, int [] a, int[] b){
		this.Num=Num;
		this.SL=a;
		this.SW=b;
	}
	public void Sort(){
		int temp;
		for(int i=0; i<Num-1;i++){
			for(int j=i+1; j<Num;j++){	
				if(SW[i]==SW[j] & SL[i]>SL[j]){
					temp = SW[i];
					SW[i] = SW[j];
					SW[j] = temp;
					 temp = SL[i];
					 SL[i] = SL[j];
					 SL[j] = temp;
				}
				else if(SW[i]>SW[j]){
					 temp = SW[i];
					 SW[i] = SW[j];
					 SW[j] = temp;
					 temp = SL[i];
					 SL[i] = SL[j];
					 SL[j] = temp;
				
				}
			}
		}
	}
	
}

class Timecheck extends Input{
	
	static int count=0;
	public static void Fun2(){
		int tmp;
		while(true){
			tmp=Fun();
			if(tmp==1)
				count++;
			else
				break;
		}
		System.out.println(count);
	}
	
		
	public static int Fun(){
		System.out.println(1);
		int temp=0;
		int temp_val;
		
		for(int i=0;i<SL.length;i++	){
			if(SL[i]>0){
				temp=i;
				break;
			}	
		}
		temp_val=SL[temp];
		if(temp_val==0)
			return 0;
		
		
		
		for(int i=temp;i<SL.length;i++){
			if(temp_val<=SL[i]){
				SL[i]=0;
			}
		}
		return 1;
	}

	
}

public class Sausage2 {
	  
	 public static void main(String[] args)  {
		 
		 int Num;
		 Input data = new Input();
		 Scanner scan =new Scanner(System.in);
		 Num = scan.nextInt();
		 
		 int [] SL = new int [Num];
		 int [] SW = new int [Num];
		 
		 for (int i=0; i < Num;i++) {
			 SL[i] = scan.nextInt();
			 SW[i] = scan.nextInt();
		 }
		 data.Input(Num, SL,SW);
		 data.Sort();
		 
		 Timecheck time = new Timecheck();
		 Timecheck.Fun2();
		
	 }
}