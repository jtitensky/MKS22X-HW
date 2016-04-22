public class BSTree<T extends Comparable<T>>{

    private Node root;

    public BSTree(){
	root=null;
    }

    public void add(T value){
	if(root==null){
	    root=new Node(value,null,null);
	}else{
	    root.add(value);
	}
    }

    public String toString(){
	if(root==null){
	    return "";
	}else{
	    return root.toString();
	}
    }

    private class Node{

	Node left,right;
	T data;

	public Node(T d,Node l,Node r){
	    data=d;
	    left=l;
	    right=r;
	}

	public T getData(){
	    return data;
	}
	public void setData(T d){
	    data=d;
	}
	public Node getLeft(){
	    return left;
	}
	public void setLeft(Node l){
	    left=l;
	}
	public Node getRight(){
	    return right;
	}
	public void setRight(Node r){
	    right=r;
	}

	public String toString(){
	    String s="";
	    s+=data+" ";
	    if(left!=null){
		s+=left.toString();
	    }else{
		if(right!=null){
		    s+="_";
		}
	    }
	    if(right!=null){
		s+=right.toString();
	    }else{
		if(left!=null){
		    s+="_";
		}
	    }
	    return s;
	}

	public void add(T value){
	    boolean b=false;
	    Node x=new Node(value,null,null);
	    if(left==null && data.compareTo(value)>=0){
		left=x;
		b=true;
		System.out.println("1");
	    }
	    if(right==null && data.compareTo(value)<=0){
		right=x;
		b=true;
		System.out.println("2");
	    }
	    if(data.compareTo(value)>=0 && !b){
		left.add(value);
		b=true;
		System.out.println("3");
	    }
	    if(data.compareTo(value)<0 && !b){
		right.add(value);
		b=true;
		System.out.println("4");
	    }
	}
	     
		




    }

}

