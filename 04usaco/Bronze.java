import java.util.*;
import java.io.*;
public class Bronze{
    public static void main(String[]args){

	try{
	    File file=new File("makelake.in");
	    Scanner sc=new Scanner(file);
	    String first=sc.nextLine();
	    String[] split=first.split(" ");
	    int r=Integer.parseInt(split[0]);
	    int c=Integer.parseInt(split[1]);
	    int e=Integer.parseInt(split[2]);
	    int n=Integer.parseInt(split[3]);
	    int[][] lake=new int[r][c];
	    for(int i=0;i<r;i++){
		first=sc.nextLine();
		split=first.split(" ");
		for(int j=0;j<c;j++){
		    lake[i][j]=Integer.parseInt(split[j]);
		}
	    }
	    int max=0;
	    for(int i=0;i<n;i++){
		max=0;
		first=sc.nextLine();
		split=first.split(" ");
		for(int j=Integer.parseInt(split[0]);j<Integer.parseInt(split[0])+3;j++){
		    for(int k=Integer.parseInt(split[1]);k<Integer.parseInt(split[1])+3;k++){
			if(lake[j-1][k-1]>max){
			    max=lake[j-1][k-1];
			}
		    }
		}
		max=max-Integer.parseInt(split[2]);
		for(int j=Integer.parseInt(split[0]);j<Integer.parseInt(split[0])+3;j++){
		    for(int k=Integer.parseInt(split[1]);k<Integer.parseInt(split[1])+3;k++){
			if(lake[j-1][k-1]>max){
			    lake[j-1][k-1]=max;
			}
		    }
		}
	    }
	    int sum=0;
	    for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){
		    if(lake[i][j]<e){
			sum+=e-lake[i][j];
		    }
		}
	    }
	    System.out.println(""+sum*72*72+",6,Titensky,Jessica");
	
	}catch(FileNotFoundException e){
	    System.out.println(e);
	}
    }
}



