import java.util.*;
public class MyDeque{

    Object[] data;
    int start;
    int end;
    private int size;

    private void grow(){
	Object[] x=new Object[data.length*2];
	int n=start;	
	for(int i=0;i<data.length;i++){
	    x[i]=n;
	    n++;
	    if(n>=data.length){
		n=0;
	    }
	}
	start=0;
	end=data.length-1;
    }

    public void addFirst(Object value){
	if(size==data.length){
	    grow();
	}
	if(start==0){
	    start=data.length-1;
	}else{
	    start--;
	}
	data[start]=value;
	size++;
    }

    public void addLast(Object value){
	if(size==data.length){
	    grow();
	}
	if(end==data.length-1){
	    end=0;
	}else{
	    end++;
	}
	data[end]=value;
	size++;
    }

    public Object removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	Object x=data[start];
	if(start==data.length-1){
	    start=0;
	}else{
	    start++;
	}
	size--;
	return x;
    }

    public Object removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	Object x=data[end];
	if(end==0){
	    end=data.length-1;
	}else{
	    end--;
	}
	size--;
	return x;
    }

    public Object getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public Object getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

}

