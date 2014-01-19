public class PalindromeLinkedList {
	
	/*
	 * Iterative: Runner fast and slow pointers
	 * Time: O(n) Space: O(n)
	 */
	public static boolean check(ListNode head){
		
		ListNode slow = head;
		ListNode fast = slow;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast!=null&&fast.next!=null){
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast!=null){//fast.next==null: odd 
			slow = slow.next;
		}
		
		while(slow!=null){
			if(stack.pop()!=slow.data) return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	
	/*
	 * Recursive
	 * 
	 * Time: O(n) Space: O(n)
	 * 
	 * head               returned node
	 *  |                       |
	 *  1       2       2       1
	 */
	public static Wrapper checkRHelper(ListNode head, int length){
		//Base case: length==0 or 1
		/* 
		if(length==0) {		
			return new Wrapper(head,true);
		}		
		if(length==1) return new Wrapper(head.next, true);*/
		
		
		//Base case: length==1 or 2; length==0 or head==null just check.
		if(length==0||head==null) return new Wrapper(null, true);
		else if(length==1) return new Wrapper(head.next, true);
		else if(length==2) return new Wrapper(head.next.next, head.data==head.next.data);
		
		Wrapper w = checkRHelper(head.next, length-2);
		
		if(!w.result||w.node==null) {
			//w.node==null duplicate check: 
			//but better keep it.	
			return w;
		}
		else {
			w.result = (head.data==w.node.data);
			w.node = w.node.next;
			return w;
			
		}	
	}
	
	public static boolean checkR(ListNode head){
		ListNode cur = head;
		int count = 0;
		while(cur!=null){
			cur = cur.next;
			count++;
		}
		
		//System.out.println(count);
		return checkRHelper(head, count).result;
	}
	
	
	public static void main(String[]args){
		ListNode n = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		System.out.println(check(n));	
		System.out.println(checkR(n));

	}

}

class Wrapper{
	ListNode node;
	boolean result;
	
	Wrapper(ListNode node, boolean result){
		this.node = node;
		this.result = result;
	}
}
