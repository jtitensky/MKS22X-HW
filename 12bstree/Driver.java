public class Driver{
    public static void main(String[]args){

	BSTree<Integer> t=new BSTree<Integer>();
	System.out.println(t.toString());
	t.add(3);
	System.out.println(t.toString());
	t.add(1);
	System.out.println(t.toString());
	t.add(4);
	System.out.println(t.toString());
	t.add(5);
	System.out.println(t.toString());
	t.add(2);
	System.out.println(t.toString());
	System.out.println(t.height());
	for(int i=0;i<8;i++){
	    System.out.println(""+i+" "+t.contains(i));
	}





    }
}

				       
