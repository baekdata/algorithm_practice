package Algorithm;

public class SelectionSort {
	public static void main(String[] args){
		int []a = {11,14,3,2,5,4,6,9,8,10,15};
		int []b = new int[10];
		int min = a[0];
		int k=0;
		
		for(int i=0; i<10; i++){
			if(min>a[i]){
				int tmp = min;
				a[k]=a[i];
				a[i] = tmp;
			}
			k++;
			min = a[k];
		}
		
		for(int j=0; j<10; j++){
			System.out.print(a[j]+" ");
		}
	}
}
