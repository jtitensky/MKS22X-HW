import java.util.*;
public class MyStack<T>{

    MyLinkedList<T> m;

    public MyStack(){
	m=new MyLinkedList<T>();
    }

    public void push(T item){
	m.add(0,item);
    }

    public T pop(){
	if(m.size()==0){
	    throw new NoSuchElementException();
	}
	return m.remove(0);
    }

    public T peek(){
	if(m.size()==0){
	    throw new NoSuchElementException();
	}
	return m.get(0);
    }

    public int size(){
	return m.size();
    }

    public boolean isEmpty(){
	return m.size()==0;
    }

}
