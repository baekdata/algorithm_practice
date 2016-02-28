package Algorithm;

import java.util.Scanner;

public class JollyJumperT {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        System.out.print("수열 수 입력:");
	        String temp =in.nextLine();
	        String[] t= temp.split(" ");
	        int[] arr= new int[t.length];
	        for(int i=0;i<t.length;i++){
	            arr[i]=Integer.parseInt(t[i]);
	        }

	        int base=arr[0]-1;
	        String result="jolly";
	        for(int i=1;i<arr.length-1;i++){
	            int cal = 0;
	            if(arr[i]>arr[i+1]){
	                cal=arr[i]-arr[i+1];
	            }else{
	                cal=arr[i+1]-arr[i];
	            }
	            if(base!=cal){
	                result="Not jolly";
	            }
	            base-=1;
	        }

	        System.out.println(result);

	    }
}
