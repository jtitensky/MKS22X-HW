public class Driver{
    public static void main(String[]args){

	MyLinkedList l=new MyLinkedList();
	l.add(3);
	l.add(4);
	l.add(5);
	l.add(6);
	System.out.println(l.toString());
	System.out.println(l.indexOf(3));
	System.out.println(l.indexOf(4));
	System.out.println(l.indexOf(6));
	System.out.println(l.indexOf(7));




    }
}
