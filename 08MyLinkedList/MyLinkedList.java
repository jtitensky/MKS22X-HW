import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{

    private class LNode<T>{
	T data;
	LNode<T> next;
	public LNode(T d, LNode<T> n){
	    data=d;
	    next=n;
	}
	public T getData(){
	    return data;
	}
	public LNode<T> getNext(){
	    return next;
	}
	public void setData(T d){
	    data=d;
	}
	public void setNext(LNode<T> n){
	    next=n;
	}
    }

    private class Boop implements Iterator<T>{
	LNode<T> current;
	public boolean hasNext(){
	    return current.getNext()!=null;
	}
	public T next(){
	    if(hasNext()){
		current=current.getNext();
		return current.getData();
	    }else{
		throw new NoSuchElementException();
	    }
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public Iterator<T> iterator(){
	return new Boop();
    }

    LNode<T> start;
    int size;
    LNode<T> end;

    public MyLinkedList(){
	start=null;
	end=null;
	size=0;
    }

    public boolean add(T value){
	if(start==null){
	    start=end=new LNode<T>(value,null);
	}else{
	    LNode<T> x=new LNode<T>(value,null);
	    end.setNext(x);
	    end=x;
	}
	size++;
	return true;
    }

    public String toString(){
	String s="[ ";
	LNode<T> x=start;
	if(start==null){
	    return "[]";
	}
	s+=x.getData();
	while(x.getNext()!=null){
	    x=x.getNext();
	    s+=", "+x.getData();
	}
	s+=" ]";
	return s;
    }

    public T get(int index){
	if(index>size-1 ||index<0){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> x=start;
	for(int i=0;i<index;i++){
	    x=x.getNext();
	}
	return x.getData();
    }

    public T set(int index, T newValue){
	if(index>size-1 ||index<0){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> x=start;
	for(int i=0;i<index;i++){
	    x=x.getNext();
	}
	T old=x.getData();
	x.setData(newValue);
	return old;
    }

    public int size(){
	return size;
    }

    public T remove(int index){
	if(index>size-1 ||index<0){
	    throw new IndexOutOfBoundsException();
	}
	T old=get(index);
	if(index==0){
	    start=start.getNext();
	}else{       
	    LNode<T> x=start;
	    for(int i=0;i<index-1;i++){
		x=x.getNext();
	    }
	    x.setNext(x.getNext().getNext());
	    if(index==size-1){
		end=x;
	    }
	}
	size--;
	return old;
    }

    public boolean add(int index, T value){
	if(index>size ||index<0){
	    throw new IndexOutOfBoundsException();
	}
	if(index==0){
	    LNode<T> y=new LNode<T>(value,start);
	    start=y;
	    size++;
	    return true;
	}
	LNode<T> x=start;
	for(int i=0;i<index-1;i++){
	    x=x.getNext();
	}
	LNode<T> y=new LNode<T>(value,x.getNext());
	x.setNext(y);
	if(index==size){
	    end=y;
	}
	size++;
	return true;
    }

    public String toString(boolean b){
	if(b){
	    String s="";
	    s+=toString();
	    s+=" head:";
	    s+=start.getData();
	    s+=" tail:";
	    s+=end.getData();
	    return s;
	}
	return "false?";
    }

    /*
      public int indexOf(int value){
      if(size==0){
      return -1;
      }
      LNode x=start;
      int i=0;
      while(x.getNext()!=null){
      if(x.getData()==value){
      return i;
      }
      x=x.getNext();
      i++;
      }
      if(x.getData()==value){
      return size-1;
      }
      return -1;
      }
    */


}
