import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyQueue<Integer> m=new MyQueue<Integer>();
	Queue<Integer> n=new Queue<Integer>();
	for(int i=0;i<100;i++){
	    m.enqueue(i);
	    //n.enqueue(i);
	}
	for(int i=0;i<50;i++){
	    System.out.println(m.dequeue());
	    //System.out.println(n.dequeue());
	}
	//System.out.println(n.size()==m.size());

    }
}

