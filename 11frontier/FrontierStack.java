import java.util.*;
public class FrontierStack<T> implements Frontier<T>{

    Stack<T> m;

    public FrontierStack(){
	m=new Stack<T>();
    }

    public void add(T element){
	m.push(element);
    }

    public T next(){
	return m.pop();
    }

    public boolean hasNext(){
	return !m.isEmpty();
    }


}
