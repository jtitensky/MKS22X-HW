public class Driver{
    public static void main(String[] args){

	Median m=new Median();
	m.add(1);
	System.out.println(m.getMed());
	m.add(2);
	System.out.println(m.getMed());
	m.add(0);
	System.out.println(m.getMed());
	m.add(3);
	System.out.println(m.getMed());

    }
}
