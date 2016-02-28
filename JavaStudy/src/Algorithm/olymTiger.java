package Algorithm;

import java.util.Scanner;

public class olymTiger {
	public static void main(String[] args){
		 int first = 1; 
	      int second = 1; 
	      int third = 0; 
	      Scanner in = new Scanner(System.in); 
	      int i = 0; 
	      int n = in.nextInt(); 
	      while (i < n) { 
	         if (i == 0 || i == 1) 
	         third = 1; 
	         else { 
	            third = first + second; 
	            first = second; 
	            second = third;     
	         } 
	         i++; 
	      } 
	      System.out.println(third); 
	      in.close(); 
	}
}
