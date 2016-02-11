public class Driver{
    public static void main(String[]args){

	QueenBoard b = new QueenBoard(4);
	//System.out.println(b.toString());
        //System.out.println(b.solve());
	//System.out.println(b.toString());
	for(int i=0;i<9;i++){
	    b = new QueenBoard(i);
	    b.solve();
	    b.printSolution();
	}
    }
}
