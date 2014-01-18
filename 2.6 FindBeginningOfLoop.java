public class FindBeginningOfLoop {
	
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) break;
        }
        
        if(fast==null||fast.next==null) return null;
        
        while(fast!=slow){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        while(slow!=fast){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;   
    }

}
