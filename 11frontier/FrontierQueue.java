import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{

    MyQueue<T> m;

    public FrontierQueue(){
	m=new MyQueue<T>();
    }

    public void add(T element){
	m.enqueue(element);
    }

    public T next(){
	return m.dequeue();
    }

    public boolean hasNext(){
	return !m.isEmpty();
    }


}
