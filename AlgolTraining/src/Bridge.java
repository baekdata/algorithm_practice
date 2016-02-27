import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Bridge { // Chapter4. �ٸ� // 2���� case�� �����ؼ� Ǯ��� �Ѵ�. // 4�� �̻��� ���(A+2B+D / 2A+C+D) �� �� ���� �� 
	public static void main(String[] args){ // ��µ� ���� ���� //Delete�Լ��� ����
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
			if(peopleList.size()>=4){ //2���� ������ case���� (A+2B+D) / (2A+C+D)
				velA = peopleList.get(0) + 2*peopleList.get(1) + peopleList.get(peopleList.size()-1); 
				velB = 2*peopleList.get(0) + peopleList.get(2) + peopleList.get(peopleList.size()-1);
				totalTime = (velA<velB)? totalTime+velA : totalTime+velB; // 3�׿����� �б�
				
				tracking.add(peopleList.get(0)+" "+peopleList.get(1));
				tracking.add(peopleList.get(0)+"");
				tracking.add(peopleList.get(peopleList.size()-2)+" "+peopleList.get(peopleList.size()-1));
				tracking.add(peopleList.get(1)+"");
				peopleList.remove(peopleList.size()-1); // ����
				peopleList.remove(peopleList.size()-1); // ������ �����ǹǷ� �̷������� �ؾ� �и��� ����/ arraylistƯ¡
			}else if(peopleList.size()==3){
				totalTime += peopleList.get(0) + peopleList.get(1) + peopleList.get(peopleList.size()-1);
				tracking.add(peopleList.get(0)+" "+peopleList.get(1));
				tracking.add(peopleList.get(0)+"");
				tracking.add(peopleList.get(0)+" "+peopleList.get(peopleList.size()-1));
				peopleList.remove(2); // ����
				peopleList.remove(1);
				peopleList.remove(0);
			}else if(peopleList.size()==2){
				totalTime+= peopleList.get(1);
				tracking.add(peopleList.get(0)+" "+peopleList.get(1));
				peopleList.remove(1); // ����
				peopleList.remove(0);
			}else if(peopleList.size()==1){
				totalTime+=peopleList.get(0);
				tracking.add(peopleList.get(0)+"");
				peopleList.remove(0); // ����
			}
		}
		System.out.println(totalTime);
		for(int i=0; i<tracking.size(); i++)
			System.out.println(tracking.get(i));
		sc.close();
	}
}