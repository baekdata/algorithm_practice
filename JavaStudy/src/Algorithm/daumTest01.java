package Algorithm;

public class daumTest01 { // °¡Àå °Å¸® ÂªÀº ½Ö
	public static void main(String[] args){
		int [] a = {1, 3, 4, 8, 13, 17, 20};
		int minX = 0, minY=0; 
		minX = a[1]-a[0];
		int result =0;
		
		for(int i = 0; i<a.length-1; i++){
			minY = a[i+1] - a[i];
			if(minY<minX){
				result = i;
			}
		}
		System.out.println("("+a[result]+", "+a[result+1]+")");
	}
}
