import java.util.*;
public class MyDeque<T>{

    T[] data;
    int start;
    int end;
    private int size;

    @SuppressWarnings("unchecked")
	public MyDeque(){
	data=(T[]) new Object[10];
    } 

    @SuppressWarnings("unchecked")
	private void grow(){
	T[] x=(T[]) new Object[data.length*2];
	int n=start;	
	for(int i=0;i<data.length;i++){
	    x[i]=data[n];
	    n++;
	    if(n==data.length){
		n=0;
	    }
	}
	start=0;
	end=data.length-1;
	data=x;
    }

    public void addFirst(T value){
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

    public void addLast(T value){
	if(size==data.length){
	    grow();
	}
	if(size>0){
	    if(end==data.length-1){
		end=0;
	    }else{
		end++;
	    }
	}
	data[end]=value;
	size++;
    }

    public T removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T x=data[start];
	if(start==data.length-1){
	    start=0;
	}else{
	    start++;
	}
	size--;
	return x;
    }

    public T removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T x=data[end];
	if(end==0){
	    end=data.length-1;
	}else{
	    end--;
	}
	size--;
	return x;
    }

    public T getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    public String toString(){
	String s="";
	for(int i=start;i<=end;i++){
	    if(i==data.length){
		i=0;
	    }
	    s+=data[i]+" ";
	}
	return s;
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size==0;
    }

}

