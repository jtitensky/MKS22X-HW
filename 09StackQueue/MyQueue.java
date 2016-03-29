import java.util.*;
public class MyQueue<T> {

    MyLinkedList<T> m;

    public MyQueue(){
	m=new MyLinkedList<T>();
    }

    public void enqueue(T item){
	m.add(item);
    }

    public T dequeue(){
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

