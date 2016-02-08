public class Recursion implements hw01{

    public String name(){
	return "Titensky,Jessica";
    }

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}
	return sqrtt(n,1);
    }

    public double sqrtt(double n, double g){
	if(-.00001<(g*g-n)/n && (g*g-n)/n<.00001){
	    return g;
	}
	return sqrtt(n,(n/g+g)/2);
    }

}
