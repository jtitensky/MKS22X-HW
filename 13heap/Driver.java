public class Driver{
    public static void main(String[]args){

	/*
	  MyHeap<Integer> h=new MyHeap<Integer>();
	  h.add(3);
	  System.out.println(h.toString());
	  h.add(4);
	  System.out.println(h.toString());
	  h.add(1);
	  System.out.println(h.toString());
	  h.add(5);
	  System.out.println(h.toString());
	  h.add(2);
	  System.out.println(h.toString());
	  h.add(6);
	  System.out.println(h.toString());
	  h.delete();
	  System.out.println(h.toString());
	*/

	
	Integer[] ar=new Integer[] {3,4,1,5,2,6};
	MyHeap<Integer> g=new MyHeap<Integer>(ar);
	System.out.println(g.toString());
	g.add(7);
	System.out.println(g.toString());
	g.delete();
	System.out.println(g.toString());
	System.out.println(g.peek());

    }
}
