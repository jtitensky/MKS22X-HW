public class KnightBoard{

    int[][] board;

    public KnightBoard(int n){
	board=new int[n+4][n+4];
	for(int i=0;i<n+4;i++){
	    for(int j=0;j<n+4;j++){
		if(i==0 || i==1 || i==n+2 || i==n+3 || j==0 || j==1 || j==n+2 || j==n+3){
		    board[i][j]=-1;
		}else{
		    board[i][j]=0;
		}
	    }
	}
    }

    public KnightBoard(int cols, int rows){
	board=new int[rows+4][cols+4];
	for(int i=0;i<rows+4;i++){
	    for(int j=0;j<cols+4;j++){
		if(i==0 || i==1 || i==rows+2 || i==rows+3 || j==0 || j==1 || j==cols+2 || j==cols+3){
		    board[i][j]=-1;
		}else{
		    board[i][j]=0;
		}
	    }
	}
    }

    public boolean solvee(int i, int j, int step){
	if(step==board.length*board.length){
	    return true;
	}
	if(board[i][j]!=0){
	    return false;
	}
	for(int m=0;m<board.length;m++){
	    for(int n=0;n<board[0].length;n++){
		if(board[m][n]>=step){
		    board[m][n]=0;
		}
	    }
	}
	board[i][j]=step;
	return 
	    solvee(i+1,j+2,step+1)||
	    solvee(i+2,j+1,step+1)||
	    solvee(i-1,j-2,step+1)||
	    solvee(i-2,j-1,step+1)||
	    solvee(i+1,j-2,step+1)||
	    solvee(i-1,j+2,step+1)||
	    solvee(i+2,j-1,step+1)||
	    solvee(i-2,j+1,step+1);
    }

    public boolean solve(){
	return solvee(2,2,1);
    }

    public void printSolution(){
	String s="";
	for(int i=2;i<board.length-2;i++){
	    for(int j=2;j<board[0].length-2;j++){
		if(board[i][j]<10){
		    s+="0";
		}
		s+=board[i][j]+" ";
	    }
	    s+="\n";
	}
	System.out.println(s);
    }


}





