public class Board{

    int[][] board;

    public Board(int n){
	board=new int[n][n];
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
		board[i][j]=0;
	    }
	}
    }

    public boolean addQueen(int i, int j){
	if(board[i][j]!=0){
	    return false;
	}
	board[i][j]=1;
	for(int m=0;m<board.length;m++){
	    for(int n=0;n<board.length;n++){
		if(m==i || n==j || m-i==n-j){
		    if(!(m==i && n==j)){
			board[m][n]-=1;
		    }
		}
	    }
	}
	return true;
    }

    public boolean removeQueen(int i, int j){
	if(board[i][j]!=1){
	    return false;
	}
	board[i][j]=0;
	for(int m=0;m<board.length;m++){
	    for(int n=0;n<board.length;n++){
		if(m==i || n==j || m-i==n-j){
		    if(!(m==i && n==j)){
			board[m][n]+=1;
		    }
		}
	    }
	}
	return true;
    }

}



 
