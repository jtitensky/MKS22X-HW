import java.util.*;
import java.io.*;
public class Silver{

    public static void print(int[][] a){
	String st="";
	for(int i=0;i<a.length;i++){
	    st+="\n";
	    for(int j=0;j<a[0].length;j++){
		st+=a[i][j];
	    }
	}
	System.out.println(st);
    }

    public static void main(String[]args){

	try{
	    File file=new File("ctravel.in");
	    Scanner sc=new Scanner(file);
	    String line=sc.nextLine();
	    String[] split=line.split(" ");
	    int n=Integer.parseInt(split[0]);
	    int m=Integer.parseInt(split[1]);
	    int t=Integer.parseInt(split[2]);
	    char[][] field=new char[n+2][m+2];
	    for(int i=0;i<n;i++){
		line=sc.nextLine();
		for(int j=0;j<m;j++){
		    field[i+1][j+1]=line.charAt(j);
		}
	    }
	    for(int i=0;i<n+2;i++){
		field[i][0]='#';
		field[i][m+1]='#';
	    }
	    for(int i=0;i<m+2;i++){
		field[0][i]='#';
		field[n+1][i]='#';
	    }
	    int[][] nums= new int[n+2][m+2];
	    line=sc.nextLine();
	    split=line.split(" ");
	    int r1=Integer.parseInt(split[0]);
	    int c1=Integer.parseInt(split[1]);
	    int r2=Integer.parseInt(split[2]);
	    int c2=Integer.parseInt(split[3]);
	    nums[r1][c1]=1;
	    int[][] numss=new int[n+2][m+2];
	    for(int s=0;s<t;s++){
		for(int i=0;i<n+2;i++){
		    for(int j=0;j<m+2;j++){
			if(field[i][j]=='.'){
			    numss[i][j]=nums[i+1][j]+nums[i-1][j]+nums[i][j+1]+nums[i][j-1];
			}
		    }
		}
		for(int i=0;i<n+2;i++){
		    for(int j=0;j<m+2;j++){
			nums[i][j]=numss[i][j];
			numss[i][j]=0;
		    }
		}
	    }
	    System.out.println(""+nums[r2][c2]+",6,Titensky,Jessica");






	}catch(FileNotFoundException e){
	    System.out.println("no such file");
	}
    }
}

