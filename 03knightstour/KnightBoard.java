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

    public solvee(int i, int j, int step){
	if(step==board.length*board.length){
	    return true;
	}


