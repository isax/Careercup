public class FindInOrderSuccessor {
	
	public static TreeNode findSuccessor(TreeNode node){
		if(node==null) return null;
		
		if(node.parent==null||node.right!=null){ //remember node.parent==null
			return leftMost(node.right);
		}
		else{
			TreeNode q = node;
			TreeNode p = node.parent;
			while(p!=null&&p.left != q){
				q = p;
				p = p.parent;
			}
			return p;
		}
	}
	
	public static TreeNode leftMost(TreeNode node){
		if(node==null) return null;
		while(node.left!=null){
			node = node.left;
		}
		return node;
	}

}
