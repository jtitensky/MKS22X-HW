public class Nodee{

    Coordinate c;
    Nodee prev;

    public Nodee(Coordinate x,Nodee last){
	c=x;
	prev=last;
    }

    public Nodee getPrev(){
	return prev;
    }

    public Coordinate getCoord(){
	return c;
    }

}
