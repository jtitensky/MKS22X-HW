public class Median{

    private MyHeap<Integer> small;
    private MyHeap<Integer> big;

    public Median(){
	small=new MyHeap<Integer>(true);
	big=new MyHeap<Integer>(false);
    }

    public void add(int x){
	if(small.size()==0){
	    if(big.size()==0){
		small.add(x);
	    }else{
		if(x<=big.peek()){
		    small.add(x);
		}else{
		    small.add(big.delete());
		    big.add(x);
		}
	    }
	}else{
	    if(small.size()==big.size()){
		if(x>=big.peek()){
		    big.add(x);
		}else{
		    small.add(x);
		}
	    }else if(small.size()>big.size()){
		if(x>=small.peek()){
		    big.add(x);
		}else{
		    big.add(small.delete());
		    small.add(x);
		}
	    }else{
		if(x<=big.peek()){
		    small.add(x);
		}else{
		    small.add(big.delete());
		    big.add(x);
		}
	    }
	}
    }

    public double getMed(){
	if(small.size()==big.size()){
	    return 1.0*(small.peek()+big.peek())/2;
	}
	if(small.size()>big.size()){
	    return small.peek();
	}
	return big.peek();
    }


}
