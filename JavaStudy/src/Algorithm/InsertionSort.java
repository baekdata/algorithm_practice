package Algorithm;

public class InsertionSort { // 선택 정렬
	public static void main(String[] args){
		int [] sort = {5,2,4,6,1,3};
		for(int i=0; i<sort.length; i++){
			for(int j = 0; j<i; j++){
				if(sort[i]<sort[j]){
					int tmp = sort[j];
					sort[j] = sort[i];
					sort[i] = tmp;
				}
			}
			for(int k=0; k<sort.length; k++)
				System.out.print(sort[k]+ " ");
			System.out.println();
		}
		
		for(int k=0; k<sort.length; k++)
			System.out.print(sort[k]+ " ");
	}
}
