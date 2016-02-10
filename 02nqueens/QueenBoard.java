public class QueenBoard{

    int[][] board;

    public QueenBoard(int n){
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

    public String toString(){
	String s="";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		if(board[i][j]==1){
		    s+=" Q";
		}else{
		    s+=" -";
		}
	    }
	    s+="\n";
	}
	return s;
    }

    public boolean solvee(int n){
	if(n==board.length){
	    for(int i=0;i<n;i++){
		if(board[n][i]==0){
		    addQueen(n,i);
		    return true;
		}
	    }
	    return false;
	}
	for(int i=0;i<board.length;i++){
	    if(board[n][i]==0){
		addQueen(n,i);
		if(solvee(n-1)){
		    return true;
		}
		removeQueen(n,i);
	    }
	}
	return false;
    }

    public boolean solve(){
	return solvee(0);
    }


}



 
