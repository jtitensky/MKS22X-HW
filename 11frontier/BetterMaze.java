import java.util.*;
import java.io.*;

public class BetterMaze{

    private class Node{
	public int x;
	public int y;
	public Node prev;
	public Node(int a, int b, Node c){
	    x=a;
	    y=b;
	    prev=c;
	}
    }
    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
	/** IMPLEMENT THIS **/
	//return new int[1];
	int[] s=new int[solution.length];
	for(int i=0;i<solution.length;i++){
	    s[i]=solution[i];
	}
	return s;

    }


    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){
	/** IMPLEMENT THIS **/
	//return false;

	placesToGo=new FrontierQueue<Node>();
	return solve();

    }


    /**initialize the frontier as a stack and call solve
     */
    public boolean solveDFS(){
	/** IMPLEMENT THIS **/
	//return false;

	placesToGo=new FrontierStack<Node>();
	return solve();

    }

    /**Search for the end of the maze using the frontier.
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
	/** IMPLEMENT THIS **/
	//return false;

	Node n,m;
	n=new Node(startRow,startCol,null);
	placesToGo.add(n);
	while(placesToGo.hasNext()){
	    if(animate){
		clearTerminal();
		System.out.println(toString());
		wait(20);
	    }
	    n=placesToGo.next();
	    if(maze[n.x+1][n.y]==' ' || maze[n.x+1][n.y]=='E'){
		m=new Node(n.x+1,n.y,n);
		placesToGo.add(m);
	    }
	    if(maze[n.x-1][n.y]==' ' || maze[n.x-1][n.y]=='E'){
		m=new Node(n.x-1,n.y,n);
		placesToGo.add(m);
	    }
	    if(maze[n.x][n.y+1]==' ' || maze[n.x][n.y+1]=='E'){
		m=new Node(n.x,n.y+1,n);
		placesToGo.add(m);
	    }
	    if(maze[n.x][n.y-1]==' ' || maze[n.x][n.y-1]=='E'){
		m=new Node(n.x,n.y-1,n);
		placesToGo.add(m);
	    }
	    if(maze[n.x][n.y]=='E'){
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(n.y);
		a.add(n.x);
		while(n.prev!=null){
		    n=n.prev;
		    a.add(n.y);
		    a.add(n.x);
		}
		solution=new int[a.size()];
		for(int i=0;i<a.size();i++){
		    solution[i]=a.get(a.size()-1-i);
		}
		return true;
	    }
	    if(maze[n.x][n.y]!='S'){
		maze[n.x][n.y]='.';
	    }
	}
	solution=new int[1];
	return false;
    }

	



    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/ 
	animate=b;
    }


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    }







}
