public class BST2DLinkedList {
	
	public static BiNode convertToCircular(BiNode root) {
		if (root == null) {
			return null;
		}

		BiNode part1 = convertToCircular(root.node1);
		BiNode part3 = convertToCircular(root.node2);

		if (part1 == null && part3 == null) {
			root.node1 = root;
			return root;
		}
		
		BiNode tail3 = part3 == null ? null : part3.node1;
	
		if (part1 == null) { // part3!=null	
			concat(root, part3);
			root.node1 = tail3;
		} 
		
		if (part3 == null){ // part1!=null
			concat(part1.node1, root);
			part1.node1 = root;
		}
		
		if (part1 != null && part3 != null) {
			concat(root, part3);
			concat(part1.node1, root);
			part1.node1 = tail3;
		}
		
		return part1 == null ? root : part1;
	}
	

	public static BiNode convert(BiNode root) {
		BiNode head = convertToCircular(root);
		//head.node1.node2 = null;
		head.node1 = null;
		return head;
	}
	
	public static void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}
}
