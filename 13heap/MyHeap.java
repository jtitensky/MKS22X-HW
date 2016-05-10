import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;
    private boolean max;

    public MyHeap(){
	data= (T[]) new Comparable[2];
	max=true;
	size=0;
    }

    public MyHeap(T[] array){
	data= (T[]) new Comparable[array.length+1];
	for(int i=0;i<array.length;i++){
	    data[i+1]=array[i];
	}
	max=true;
	size=array.length;
	heapify();
    }

    public MyHeap(boolean isMax){
	data= (T[]) new Comparable[2];
	max=isMax;
	size=0;
    }

    public MyHeap(T[] array, boolean isMax){
	data= (T[]) new Comparable[array.length+1];
	for(int i=0;i<array.length;i++){
	    data[i+1]=array[i];
	}
	max=isMax;
	size=array.length;
	heapify();
    }

    private void pushDown(int k){
	if(k*2<=size){
	    if(max){
		if(k*2+1>size){
		    if(data[k].compareTo(data[k*2])<0){
			T t=data[k];
			data[k]=data[k*2];
			data[k*2]=t;
			pushDown(k*2);
		    }
		}else{
		    if(data[k*2].compareTo(data[k*2+1])>=0){
			if(data[k].compareTo(data[k*2])<0){
			    T t=data[k];
			    data[k]=data[k*2];
			    data[k*2]=t;
			    pushDown(k*2);
			}
		    }
		    else{
			if(data[k].compareTo(data[k*2+1])<0){
			    T t=data[k];
			    data[k]=data[k*2+1];
			    data[k*2+1]=t;
			    pushDown(k*2+1);
			}
		    }
		}
	    }else{
		if(k*2+1>size){
		    if(data[k].compareTo(data[k*2])>0){
			T t=data[k];
			data[k]=data[k*2];
			data[k*2]=t;
			pushDown(k*2);
		    }
		}else{
		    if(data[k*2].compareTo(data[k*2+1])<=0){
			if(data[k].compareTo(data[k*2])>0){
			    T t=data[k];
			    data[k]=data[k*2];
			    data[k*2]=t;
			    pushDown(k*2);
			}
		    }
		    else{
			if(data[k].compareTo(data[k*2+1])>0){
			    T t=data[k];
			    data[k]=data[k*2+1];
			    data[k*2+1]=t;
			    pushDown(k*2+1);
			}
		    }
		}
	    }
	}
    }

    private void pushUp(int k){
	if(k>1){
	    if(max){
		if(data[k].compareTo(data[k/2])>0){
		    T t=data[k];
		    data[k]=data[k/2];
		    data[k/2]=t;
		    pushUp(k/2);
		}
	    }else{
		if(data[k].compareTo(data[k/2])<0){
		    T t=data[k];
		    data[k]=data[k/2];
		    data[k/2]=t;
		    pushUp(k/2);
		}
	    }
	}
    }

    public T delete(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T t=data[1];
	data[1]=data[size];
	data[size]=null;
	size--;
	pushDown(1);
	return t;
    }

    public T peek(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[1];
    }

    public void add(T x){
	if(data.length>=size){
	    doubleSize();
	}
	data[size+1]=x;
	size++;
	pushUp(size);
    }

    private void heapify(){
	for(int i=data.length/2;i>0;i--){
	    pushDown(i);
	}
    }

    public void doubleSize(){
	T[] ar=(T[]) new Comparable[data.length];
	for(int i=1;i<ar.length;i++){
	    ar[i]=data[i];
	}
	data=(T[]) new Comparable[data.length*2-1];
	for(int i=1;i<ar.length;i++){
	    data[i]=ar[i];
	}
    }

    public String toString(){
	String s="";
	for(int i=1;i<=size;i++){
	    s+=data[i]+" ";
	}
	return s;
    }


}
