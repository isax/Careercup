public class ListAtEachDepth {

	public static ArrayList<LinkedList<TreeNode>> createLists(TreeNode root){
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		if(root==null) return res;
		
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		
		while(list.size()>0){
			res.add(list);
			LinkedList<TreeNode> parents = list;
			list = new LinkedList<TreeNode>();
			
			for(TreeNode parent: parents){
				if(parent.left!=null)
					list.add(parent.left);
				if(parent.right!=null)
					list.add(parent.right);
			}
		}
		return res;
	}
	
}
