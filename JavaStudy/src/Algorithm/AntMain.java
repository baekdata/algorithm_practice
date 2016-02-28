package Algorithm;

public class AntMain {
	public static void main(String[] args){
		
		AntAntAnt ant = new AntAntAnt();
		long a = System.currentTimeMillis();
		ant.make(10);
		
//		for(int i=0; i<12; i++){
//			ant.make(i);
//		}
		long b = System.currentTimeMillis();
		System.out.println((b-a)+"mmsec------------------");
	}
}
