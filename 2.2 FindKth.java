public class FindKth {
	
	public static ListNode findkth(ListNode head, int k){
		if(k<=0) return null;
		
		ListNode left = head;
		ListNode right = head;
		
		int index = 0;
		while(index!=k-1&&right!=null){			
			right = right.next;
			index++;		
		}
		
		if(right==null) return null;
		
		while(right.next!=null){
			right = right.next;
			left = left.next;
		}
		
		return left;
		
	}
	
	public static void main(String[]args){
		ListNode n = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		System.out.println(findkth(n, 2).data);
		

	}

}
