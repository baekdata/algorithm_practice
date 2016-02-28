import java.util.*;


public class Building {
	public static class Build {
	    public int Ind;
	    public int Val;
	    public Build nextBuild;

	    public Build(int number, int height) {
	        this.Ind = number;
	        this.Val = height;
	    }

	    
	}
	private static void clacBuild(Build[] builds){
		Stack<Build> stack = new Stack<>();
		stack.push(builds[0]);
		
		for(int i=1; i<builds.length;i++){
			Build build = builds[i];
			Build Top = stack.peek(); 
			while(Top.Val<build.Val){
				builds[Top.Ind-1].nextBuild=build;
				stack.pop();
				 if (stack.isEmpty() == true)
	                    break;
	                Top = stack.peek();
	
			}
			stack.push(build);
		}
		for (Build building : builds) {
            if (building.nextBuild != null)
                System.out.println(building.nextBuild.Ind);
            else
                System.out.println(0);
        }

	}

	
	
	
	public static void main(String[] args) {
		
		int N;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		
		Build[] builds = new Build[N];
		for (int i=0; i<N; i++){
			builds[i] = new Build(i + 1, scan.nextInt());
	        
	    }
		scan.close();
		
		clacBuild(builds);
		
		
	}
}
	