import java.util.Stack;

public class QueueBy2Stacks<T> {
	Stack<T>stack1, stack2;
	
	public QueueBy2Stacks(){
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();	
	}
	public int size(){
		return stack1.size() + stack2.size();
	}
	
	public void enqueue(T i){
		stack1.push(i);	
	}
	
	public void shiftStacks(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}		
		}
	}
	
	public T dequeue(){
		shiftStacks();
		if(!stack2.isEmpty()){
			return stack2.pop();
		}else{
			return null;
		}
	}
	
	public T peek(){
		shiftStacks();
		if(!stack2.isEmpty()){
			return stack2.peek();
		}else{
			return null;
		}
	}	

}
