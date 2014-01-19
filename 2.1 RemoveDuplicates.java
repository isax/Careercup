public class RemoveDuplicates {
	
	/*
	 * Time: O(n)
	 */
	public static void remove(ListNode head){
		
		Hashtable<Integer, Boolean> ht = new Hashtable<Integer, Boolean>();
		ListNode prev = null;
		
		while(head!=null){
			if(ht.containsKey(head.data)) {
				prev.next = head.next;
			}else{
				ht.put(head.data, true);
				prev = head; // made some mistake here
			}
			head = head.next;
		}
		
	}
	
	/*
	 * Time: O(n^2) Space: O(1)
	 */
	public static void remove2(ListNode head){
		ListNode cur = head;
		while(cur!=null){
			ListNode check = cur;
			int data = cur.data;	
			while(check.next!=null){
				if(data == check.next.data){
					check.next = check.next.next;
				}
				else check = check.next;
			}
			cur = cur.next;
		}
	}
	
	public static void main(String[]args){
		ListNode n = new ListNode(5);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		remove2(n);
		
		ListNode cur = n;
		while(cur!=null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
}
