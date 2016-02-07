public class Recursion implements hw01{

    public String name(){
	return "Titensky,Jessica";
    }

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrtt(n,n/2);
    }

    public double sqrtt(double n, double g){
	if(-.0000000001<(g*g-n)/n && (g*g-n)/n<.0000000001){
	    return g;
	}
	return sqrtt(n,(n/g+g)/2);
    }

}
