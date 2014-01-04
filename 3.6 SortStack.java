import java.util.Stack;

public class SortStack {
	
	public static void main(String[]args){
		
		Stack<Integer> test = new Stack<Integer>();
		test.push(new Integer(1));
		test.push(new Integer(12));
		test.push(new Integer(30));
		test.push(new Integer(5));
		
		Stack<Integer> res = sortedStack(test);
		while(!res.isEmpty()){
			System.out.print(res.pop()+" ");
		}
	}
	
	public static Stack<Integer> sortedStack(Stack<Integer> myStack){
		Stack<Integer>newStack = new Stack<Integer>();
		//if(myStack.isEmpty()) return null;
	
		while(!myStack.isEmpty()){
			Integer temp = myStack.pop();
			
			while(!newStack.isEmpty() && newStack.peek()>temp){
				myStack.push(newStack.pop());
			}
			newStack.push(temp);			
		}	
		return newStack;
				
	}

}
