import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyLinkedList m=new MyLinkedList();
	ArrayList<Integer> n=new ArrayList<Integer>();
	long start,end;
	start=System.currentTimeMillis();

	//
	for(int i=0;i<100;i++){
	    n.add(i);
	}
	for(int i=0;i<200;i++){
	    n.add(5,5);
	}
	for(int i=0;i<250;i++){
	    n.get(i);
	    n.set(i,i);
	}

	end=System.currentTimeMillis();
	System.out.println("Time: "+(end-start)/1000.0+" seconds for ArrayList");
	start=System.currentTimeMillis();

	//
	for(int i=0;i<100;i++){
	    m.add(i);
	}
	for(int i=0;i<200;i++){
	    m.add(5,5);
	    m.get(5);
	}
	for(int i=0;i<250;i++){
	    m.get(i);
	    m.set(i,i);
	}

	end=System.currentTimeMillis();
	System.out.println("Time: "+(end-start)/1000.0+" seconds for MyLinkedList");

    }
}
