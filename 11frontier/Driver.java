public class Driver{
    public static void main(String[]args){

	BetterMaze b=new BetterMaze("data3.dat");
	b.setAnimate(true);
	System.out.println(b.toString());
	System.out.println(b.solveDFS());
	System.out.println(b.toString());
	int[] x=b.solutionCoordinates();
	for(int i=0;i<x.length;i++){
	    System.out.print(" "+x[i]);
	}
	System.out.println();
	


	BetterMaze c=new BetterMaze("data3.dat");
	c.setAnimate(true);
	System.out.println(c.toString());
	System.out.println(c.solveBFS());
	System.out.println(c.toString());
	int[] y=c.solutionCoordinates();
	if(x.length>1){
	    for(int i=0;i<y.length;i+=2){
		System.out.println(""+y[i]+" "+y[i+1]);
	    }
	}
	

    }
}
