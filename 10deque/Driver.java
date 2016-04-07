import java.util.*;
import java.lang.Math;
public class Driver{
    public static void main(String[]args){

	MyDeque<Integer> m=new MyDeque<Integer>();
	ArrayDeque<Integer> n=new ArrayDeque<Integer>();
	boolean b=true;
	for(int i=0;i<10000;i++){
	    double x=Math.random();
	    if(x<.25){
		m.addFirst(i);
		n.addFirst(i);
	    }else if(x<.5){
		m.addLast(i);
		n.addLast(i);
	    }else if(x<.7){
		int y,z;
		try{
		    y=m.removeFirst();
		}catch(NoSuchElementException | NullPointerException e){
		    y=0;		
		}
		try{
		    z=n.removeFirst();
		}catch(NoSuchElementException | NullPointerException e){
		    z=0;
		}
		if(y!=z){
		    b=false;
		}
	    }else if(x<.9){
		int y,z;
		try{
		    y=m.removeLast();
		}catch(NoSuchElementException | NullPointerException e){
		    y=0;		
		}
		try{
		    z=n.removeLast();
		}catch(NoSuchElementException | NullPointerException e){
		    z=0;		
		}
		if(y!=z){
		    b=false;
		}
	    }else if(x<.95){
		int y,z;
		try{
		    y=m.getFirst();
		}catch(NoSuchElementException | NullPointerException e){
		    y=0;		
		}
		try{
		    z=n.getFirst();
		}catch(NoSuchElementException | NullPointerException e){
		    z=0;		
		}
		if(y!=z){
		    b=false;
		}
	    }else{
		int y,z;
		try{
		    y=m.getLast();
		}catch(NoSuchElementException | NullPointerException e){
		    y=0;		
		}
		try{
		    z=n.getLast();
		}catch(NoSuchElementException | NullPointerException e){
		    z=0;		
		}
		if(y!=z){
		    b=false;
		}
	    }
	}

	System.out.println(b);


    }
}
