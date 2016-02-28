import java.util.Scanner;

public class Lecture{ // 회의실 배정 // 정올 // Greedy 01번 //
	static int num;
	static Scanner sc = new Scanner(System.in);
	static int cnt;
	static int[] lecture = new int[501];
	static data[] k = new data[501];

	public static void main(String[] args){
		input();
		greedy();
		output();
	}

	static void input(){
		data temp = new data();
		num = Integer.parseInt(sc.nextLine());
		for(int i=0; i<=num; i++){
			k[i]=new data();
		}

		for(int i=1; i<=num; i++){
			k[i].num = sc.nextInt();
			k[i].starttime = sc.nextInt();
			k[i].stoptime = sc.nextInt();
		}

		for(int i=1; i<=num-1; i++){
			for(int j=i+1; j<=num; j++){
				if(k[i].stoptime>k[j].stoptime)
					temp = k[i]; k[i]=k[j]; k[j]=temp;
			}
		}
	}

	static void greedy(){
		int finish =0;
		for(int i=1; i<=num; i++){
			if(k[i].starttime >= k[finish].stoptime)
				lecture[++cnt] = k[i].num; finish = i;
		}
	}

	static void output(){
		System.out.println(cnt);
		for(int i=1; i<=cnt; i++)
			System.out.print(lecture[i]+" ");
	}
}

class data{
	int num; 
	int starttime; 
	int stoptime;
}