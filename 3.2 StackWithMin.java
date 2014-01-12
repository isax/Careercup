import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {

	Stack<Integer>min;
	
	public StackWithMin2(){
		min = new Stack<Integer>();
	}
	
	public void push(int i){
		if(i<=min()) {
			min.push(i);			
		}
		super.push(i);		
	}
	
	public int min(){
		if(min.isEmpty()) return Integer.MAX_VALUE;
		else return min.peek();
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value==min())
			min.pop();
		
		return value;
	}
	
}
