import java.util.*;
public class ParenDemo{

    public static boolean isMatching(String s){
	MyStack<Character> m=new MyStack<Character>();
	for(int i=0;i<s.length();i++){
	    try{
		if(s.charAt(i)==']'){
		    if(m.peek()=='['){
			m.pop();
		    }else{
			return false;
		    }
		}
		if(s.charAt(i)=='}'){
		    if(m.peek()=='{'){
			m.pop();
		    }else{
			return false;
		    }
		}
		if(s.charAt(i)==')'){
		    if(m.peek()=='('){
			m.pop();
		    }else{
			return false;
		    }
		}
		if(s.charAt(i)=='>'){
		    if(m.peek()=='<'){
			m.pop();
		    }else{
			return false;
		    }
		}
	    }catch(NoSuchElementException e){
		return false;
	    }
	    if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='<'){
		m.push(s.charAt(i));
	    }
	}
	return m.isEmpty();
    }


    public static void main(String[]args){
	String input="";
	if(args.length>0){
	    input=args[0];
	    System.out.println(isMatching(input));
	}
	else{
	    System.out.println("Usage:");
	    System.out.println("java ParenDemo \"text\""); 
	}
    }

}
