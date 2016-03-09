import java.lang.Math;
public class Quick{

    private static int partition(int[] data, int left, int right){
	int rp=left+(int)(Math.random()*(right-left));
	int re=data[rp];
	int or=right;
	data[rp]=data[right];
	data[right]=re;
	right--;
	int i=0;
	while(left<right){
	    if(data[left]>re){
		i=data[left];
		data[left]=data[right];
		data[right]=i;
		right--;
	    }
	    if(data[left]<=re){
		left++;
	    }
	}
	if(data[or]<data[left]){
	    data[or]=data[left];
	    data[left]=re;
	}
	return left;
    }

    private static int quickselect(int[] data, int k, int left, int right){
        int div=partition(data, left, right);
	if(div==k || left>=right){
	    return(data[k]);
	}
	if(div<k){
	    return(quickselect(data,k,div+1,right));
	}
	if(div>k){
	    return(quickselect(data,k,left,div-1));
	}
	return 10000;
    }

    public static int quickselect(int[] data, int k){
	return quickselect(data,k,0,data.length-1);
    }


    public static void print(int[] data){
	String s="";
	for(int i=0;i<data.length;i++){
	    s+=data[i]+" ";
	}
	System.out.println(s);
    }
    /*

    public static void main(String[]args){
	int[] ar= new int[] {15,16,14,17,13,18,12,19,10,11};
	System.out.println("A0"+quickselect(ar,0));
	System.out.println("A4"+quickselect(ar,4));
	System.out.println("A5"+quickselect(ar,5));
	System.out.println("AL"+quickselect(ar,ar.length-1));
    }

    */

}
