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
	
	/*
	 * Solution 3:  More complex
	 */
	public static Res commonAncestorHelper2(TreeNode root, TreeNode p, TreeNode q){
		if(root==null) return new Res(null, false);
		
		if(root==p&&root==q) return new Res(root, true);
		
		Res left = commonAncestorHelper2(root.left, p, q);
		if(left.isAncestor) return left;
		
		Res right = commonAncestorHelper2(root.right, p, q);
		if(right.isAncestor) return right;
		
		if(left.root!=null&&right.root!=null){ //diff side
			return new Res(root, true); // common ancestor
		}else if(root==p||root==q){
			boolean isAncestor = left.root!=null||right.root!=null?true:false;
			return new Res(root, isAncestor);
		}else{
			return new Res(left.root!=null?left.root:right.root, false);
		}
	}
	public static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		Res res = commonAncestorHelper2(root, p, q);
		if(res.isAncestor) return res.root;
		else return null;
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
