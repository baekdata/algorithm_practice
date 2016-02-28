package Algorithm;

import java.util.Arrays;
public class InsertionSort02 { //»ğÀÔÁ¤·Ä
	public static void main(String[] args){
		int[] arr = {6,5,4,3,2,1};
		insert(arr);
	}
	
	public static void insert(int[] arr){
		int temp=0;
		for(int i=0; i<arr.length; i++){
			for(int j=i; j>0; j--){
				if(arr[j]<arr[j-1]){
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
