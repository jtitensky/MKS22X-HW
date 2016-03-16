public class MyLinkedList{

    private class LNode{
	int data;
	LNode next;
	public LNode(int d, LNode n){
	    data=d;
	    next=n;
	}
	public int getData(){
	    return data;
	}
	public LNode getNext(){
	    return next;
	}
	public void setData(int d){
	    data=d;
	}
	public void setNext(LNode n){
	    next=n;
	}
    }

    LNode start;
    int size;

    public MyLinkedList(){
	start=null;
	size=0;
    }

    public boolean add(int value){
	if(start==null){
	    start=new LNode(value,null);
	}else{
	    LNode last=start;
	    for(int i=0;i<size-1;i++){
		last=last.getNext();
	    }
	    LNode x=new LNode(value,null);
	    last.setNext(x);
	}
	size++;
	return true;
    }

    public String toString(){
	String s="[ ";
	LNode x=start;
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

    public int get(int index){
	LNode x=start;
	for(int i=0;i<index;i++){
	    x=x.getNext();
	}
	return x.getData();
    }

    public int set(int index, int newValue){
	LNode x=start;
	for(int i=0;i<index;i++){
	    x=x.getNext();
	}
	int old=x.getData();
	x.setData(newValue);
	return old;
    }

    public int size(){
	return size;
    }

    public int remove(int index){
	int old=get(index);
	if(index==0){
	    start=start.getNext();
	}else{       
	    LNode x=start;
	    for(int i=0;i<index-1;i++){
		x=x.getNext();
	    }
	    x.setNext(x.getNext().getNext());
	}
	return old;
    }

    public boolean add(int index, int value){
	if(index==0){
	    LNode y=new LNode(value,start);
	    start=y;
	    size++;
	    return true;
	}
	LNode x=start;
	for(int i=0;i<index-1;i++){
	    x=x.getNext();
	}
	LNode y=new LNode(value,x.getNext());
	x.setNext(y);
	size++;
	return true;
    }

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



}
