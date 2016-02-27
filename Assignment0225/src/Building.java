import java.util.Scanner;

public class Building { // 자료구조1 // 0224 무조건 풀기 // 67점
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int numBuilding = Integer.parseInt(sc.next().trim());
		int[] tallBuilding = new int[numBuilding];
		int[] resultSet = new int[numBuilding];
		int max = 0;
		
		for(int i=0; i<numBuilding; i++){
			int temp = Integer.parseInt(sc.next().trim());
			tallBuilding[i] = temp;
			if(max<temp)
				max = temp;
		}
		
		for(int i=0; i<numBuilding; i++){
			if(tallBuilding[i]==max){
				resultSet[i]=0;
				continue;
			}
			for(int j=i; j<numBuilding; j++){
				if(tallBuilding[j]==max)
					resultSet[i] = j+1;
				if(i>=j){
					continue;
				}
				if((tallBuilding[i]<tallBuilding[j])&&(i<j)){
					resultSet[i] = j+1;
					break;
				}
			}
		}
		for(int i=0; i<numBuilding; i++)
		System.out.println(resultSet[i]);
	}
}
