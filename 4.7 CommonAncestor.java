public class CommonAncestor {
	
	public static boolean covers(TreeNode root, TreeNode p){
		if(root==null)
			return false;
		if(root==p)
			return true;
		return covers(root.left, p)||covers(root.right, p);
	}
	
	/*
	 * O(n)  1 + 1/2 + 1/4 +.... < 2
	 *           logn recursive calls
	 * 
	 */
	public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if(root==null){
			return null;
		}
		if(root==p||root==q) 
			return root; // base case Attention.
		                 // e.g. When it reaches p, search left subtree, no q there return false; also return false for p.
		                //then it will search the right child side. Doesn't work.
		
		boolean pleft = covers(root.left, p);
		boolean qleft = covers(root.left,q);
		
		if(pleft!=qleft) return root;
		
		TreeNode childside = pleft?root.left:root.right;
		
		return commonAncestorHelper(childside, p, q);
		
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root, p)||!covers(root, q)){
			return null;
		}
		return commonAncestorHelper(root, p ,q);
		
	}
	
	public static void main(String[]args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		System.out.println(commonAncestor(n1, n4, n7).value);
		
	}

}

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value){
		this.value = value;
	}
}
