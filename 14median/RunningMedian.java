import java.util.*;
public class RunningMedian{

    private MyHeap<Integer> small;
    private MyHeap<Integer> big;

    public RunningMedian(){
	small=new MyHeap<Integer>(true);
	big=new MyHeap<Integer>(false);
    }

    public double getMedian(){
	if(small.size()==0 && big.size()==0){
	    throw new NoSuchElementException();
	}
	if(small.size()>big.size()){
	    return small.peek();
	}
	if(big.size()>small.size()){
	    return big.peek();
	}
	return (small.peek()+big.peek())/2.0;
    }

    public void add(Integer x){
	try{
	    if(x<getMedian()){
		small.add(x);
	    }else{
		big.add(x);
	    }
	}
	catch(NoSuchElementException e){
	    small.add(x);
	}
	if(small.size()-big.size()>1){
	    big.add(small.delete());
	}
	if(big.size()-small.size()>1){
	    small.add(big.delete());
	}
    }
}
