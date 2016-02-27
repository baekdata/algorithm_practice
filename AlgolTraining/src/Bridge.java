import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Bridge { // Chapter4. 다리 // 2가지 case로 생각해서 풀어야 한다. // 4개 이상일 경우(A+2B+D / 2A+C+D) 둘 중 빠른 것 
	public static void main(String[] args){ // 출력도 따로 떼기 //Delete함수로 빼기
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> peopleList = new ArrayList<Integer>();
		ArrayList<String> tracking = new ArrayList<String>();
		int velA = 0, velB=0;
		int Cnt = sc.nextInt();
		int totalTime = 0;

		for(int j=0; j<Cnt; j++)
			peopleList.add(Integer.parseInt(sc.next().trim()));
		Collections.sort(peopleList);

		while(!peopleList.isEmpty()){
			if(peopleList.size()>=4){ //2가지 최적의 case존재 (A+2B+D) / (2A+C+D)
				velA = peopleList.get(0) + 2*peopleList.get(1) + peopleList.get(peopleList.size()-1); 
				velB = 2*peopleList.get(0) + peopleList.get(2) + peopleList.get(peopleList.size()-1);
				totalTime = (velA<velB)? totalTime+velA : totalTime+velB; // 3항연산자 분기
				
				tracking.add(peopleList.get(0)+" "+peopleList.get(1));
				tracking.add(peopleList.get(0)+"");
				tracking.add(peopleList.get(peopleList.size()-2)+" "+peopleList.get(peopleList.size()-1));
				tracking.add(peopleList.get(1)+"");
				peopleList.remove(peopleList.size()-1); // 삭제
				peopleList.remove(peopleList.size()-1); // 위에서 삭제되므로 이런식으로 해야 밀리지 않음/ arraylist특징
			}else if(peopleList.size()==3){
				totalTime += peopleList.get(0) + peopleList.get(1) + peopleList.get(peopleList.size()-1);
				tracking.add(peopleList.get(0)+" "+peopleList.get(1));
				tracking.add(peopleList.get(0)+"");
				tracking.add(peopleList.get(0)+" "+peopleList.get(peopleList.size()-1));
				peopleList.remove(2); // 삭제
				peopleList.remove(1);
				peopleList.remove(0);
			}else if(peopleList.size()==2){
				totalTime+= peopleList.get(1);
				tracking.add(peopleList.get(0)+" "+peopleList.get(1));
				peopleList.remove(1); // 삭제
				peopleList.remove(0);
			}else if(peopleList.size()==1){
				totalTime+=peopleList.get(0);
				tracking.add(peopleList.get(0)+"");
				peopleList.remove(0); // 삭제
			}
		}
		System.out.println(totalTime);
		for(int i=0; i<tracking.size(); i++)
			System.out.println(tracking.get(i));
		sc.close();
	}
}