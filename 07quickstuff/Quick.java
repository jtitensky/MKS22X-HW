import java.lang.Math;
import java.util.Arrays;
public class Quick{

    private static void swap(int[] data, int x, int y){
	int k=data[x];
	data[x]=data[y];
	data[y]=k;
    }

    public static void print(int[] data){
	String s="";
	for(int i=0;i<data.length;i++){
	    s+=" "+data[i];
	}
	System.out.println(s);
    }

    public static String name(){
	return "6,Titensky,Jesssica";
    }


    private static int partitionOld(int[] data, int left, int right){
	int r=left+(int)(Math.random()*(right-left+1));
	int pivot=data[r];
	swap(data,r,right);
	int or=right;
	int ol=left;
	right--;
	while(left<right){
	    if(data[left]>pivot){
		swap(data,left,right);
		right--;
	    }else{
		left++;
	    }
	}
	if(data[left]>=pivot || left==data.length-1){
	    swap(data,left,or);
	    return left;
	}else{
	    swap(data,left+1,or);
	    return left+1;
	}
    }

    public static int quickSelectOld(int[] data,int k, int left, int right){
	int div=partitionOld(data,left,right);
	if(div==k || left>=right){
	    return data[k];
	}
	if(div<k){
	    return quickSelectOld(data,k,div+1,right);
	}
	if(div>k){
	    return quickSelectOld(data,k,left,div-1);
	}
	return 10000;
    }

    public static int quickSelectOld(int[] data, int k){
	return quickSelectOld(data,k,0,data.length-1);
    } 

    public static void quickSortOld(int[] data, int left, int right){
	if(right-left>0){
	    int p=partitionOld(data,left,right);
	    quickSortOld(data,left,p-1);
	    quickSortOld(data,p+1,right);
	}
    }

    public static void quickSortOld(int[] data){
	quickSortOld(data,0,data.length-1);
    }


    public static int[] partition(int[] data, int left, int right){
	/*
	  int[] ar= new int[data.length];
	  for(int i=0;i<left;i++){
	  ar[i]=data[i];
	  }
	  for(int i=right+1;i<data.length;i++){
	  ar[i]=data[i];
	  }
	  int r=left+(int)(Math.random()*(right-left+1));
	  int pivot=data[r];
	  int ol=left;
	  int or=right;
	  for(int i=ol;i<=or;i++){
	  if(data[i]<pivot){
	  ar[left]=data[i];
	  left++;
	  }
	  if(data[i]>pivot){
	  ar[right]=data[i];
	  right--;
	  }
	  }
	  for(int i=left;i<=right;i++){
	  ar[i]=pivot;
	  }
	  for(int i=0;i<data.length;i++){
	  data[i]=ar[i];
	  }
	  int[] out=new int[2];
	  out[0]=left;
	  out[1]=right;
	  return out;
	*/

	int r=left+(int)(Math.random()*(right-left+1));
	int pivot=data[r];
	int c=1;
	int ol=left;
	int or=right;
	swap(data,r,right);
	right--;
	while(left<right){
	    if(data[left]>pivot){
		swap(data,left,right);
		right--;
	    }
	    if(data[left]<pivot){
		left++;
	    }
	    if(data[left]==pivot){
		c++;
		swap(data,right,left);
		swap(data,right,or-c+1);
		right--;
	    }
	}
	if(data[right]<pivot){
	    for(int i=0;i<c;i++){
		swap(data,or-i,right+1+i);
	    }
	}else{
	    for(int i=0;i<c;i++){
		swap(data,or-i,right+i);
	    }
	    right--;
	}
	int[] out=new int[2];
	out[0]=right+1;
	out[1]=right+c;
	return out;
    }


    public static void quickSort(int[] data, int left, int right){
	if(right-left>0){
	    int[] p=partition(data,left,right);
	    quickSort(data,left,p[0]-1);
	    quickSort(data,p[1]+1,right);
	}
    }

    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }

    public static boolean isSorted(int[] a, int[] b){
	/*
	int x=data[0];
	for(int i=0;i<data.length;i++){
	    if(data[i]<x){
		return false;
	    }
	    x=data[i];
	}
	return true;
	*/
	
	for(int i=0;i<a.length;i++){
	    if(a[i]!=b[i]){
		return false;
	    }
	}
	return true;
	
    }


    public static void main(String[]args){
	int[] a=new int[4000000];
	int[] c=new int[4000000];
	for(int i=0;i<a.length;i++){
	    c[i]=a[i]=(int)(Math.random()*4);
	}
	int[] b=new int[4000000];
	int[] d=new int[4000000];
	for(int i=0;i<b.length;i++){
	    d[i]=b[i]=(int)(Math.pow(-1,(int)(Math.random()*2)))*(int)(Math.random()*Integer.MAX_VALUE);
	}

	//Arrays.sort(c);
	//quickSortOld(a);
	//quickSort(a);
	//System.out.println(isSorted(a,c));
	//Arrays.sort(b);
	//quickSortOld(d);
	quickSort(d);
	//System.out.println(isSorted(b,d));



    }


}
