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

    public int getHeight(){
	if(root==null){
	    return 0;
	}else{
	    return root.height();
	}
    }

    public boolean contains(T value){
	if(root==null){
	    return false;
	}else{
	    return root.contains(value);
	}
    }

    public T remove(T value){
	if(root==null || !contains(value)){
	    return null;
	}
	T x=root.remove(value);
	root.f();
	return x;
    }

    private void replace(Node a, Node b){
	a.setData(b.getData());
	a.setLeft(b.getLeft());
	a.setRight(b.getRight());
    }



    private class Node{

	Node left,right;
	T data;

	public Node(T d,Node l,Node r){
	    data=d;
	    left=l;
	    right=r;
	}

	public void f(){
	    if(left!=null){
		if(left.data==null){
		    left=null;
		}else{
		    left.f();
		}
	    }
	    if(right!=null){
		if(right.data==null){
		    right=null;
		}else{
		    right.f();
		}
	    }
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
       		//if(right!=null){
		s+="_ ";
		//}
	    }
	    if(right!=null){
		s+=right.toString();
	    }else{
		//if(left!=null){
		s+="_ ";
		//}
	    }
	    return s;
	}

	public void add(T value){
	    boolean b=false;
	    Node x=new Node(value,null,null);
	    if(left==null && data.compareTo(value)>=0){
		left=x;
		b=true;
	    }
	    if(right==null && data.compareTo(value)<=0){
		right=x;
		b=true;
	    }
	    if(data.compareTo(value)>=0 && !b){
		left.add(value);
		b=true;
	    }
	    if(data.compareTo(value)<0 && !b){
		right.add(value);
		b=true;
	    }
	}

	public int height(){
	    if(left==null){
		if(right==null){
		    return 1;
		}else{
		    return 1+right.height();
		}
	    }else{
		if(right==null){
		    return 1+left.height();
		}else{
		    int l=left.height();
		    int r=right.height();
		    if(l>r){
			return 1+l;
		    }else{
			return 1+r;
		    }
		}
	    }
	}
	     
	public boolean contains(T value){
	    boolean x=(value.compareTo(data)==0);
	    boolean y=false;
	    boolean z=false;
	    if(left!=null){
		y=left.contains(value);
	    }
	    if(right!=null){
		z=right.contains(value);
	    }
	    return x||y||z;
	}

	public T min(Node x){
	    if(x.left==null){
		return x.data;
	    }else{
		return min(x.left);
	    }
	}

	public T remove(T value){
	    if(data.compareTo(value)<0){
		return right.remove(value);
	    }else if(data.compareTo(value)>0){
		return left.remove(value);
	    }else{
		if(left==null){
		    if(right==null){
			data=null;
			return data;
		    }else{
			//left=right.left;
			//right=right.right;
			//data=right.data;
			//return data;
			T x=right.data;
			replace(this,right);
			return data;
		    }
		}else{
		    if(right==null){
			//left=left.left;
			//right=left.right;
			//data=left.data;
			//return data;
			T x=left.data;
			replace(this,left);
			return data;
		    }else{
			data=min(right);
			right.remove(data);
			return data;
		    }
		}
	    }
	}




    }

}

