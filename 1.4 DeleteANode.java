public class DeleteANode {

	public static boolean delete(ListNode node){
		if(node==null||node.next==null) return false;
		
		node.data = node.next.data;
		node.next = node.next.next;
		
		return true;
		
	}
	
	public static void main(String[]args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		System.out.println(delete(n4));
		
		ListNode cur = n1;
		while(cur!=null){
			System.out.println(cur.data);
			cur = cur.next;
		}
		
	}
}
