public class ListAtEachDepth {

	/*
	 * BFS Time: O(N) Space: O(N)
	 */
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
	
	
	/*
	 * DFS Time: O(N) Space: O(N+logN) = O(N)
	 */
	public static void dfsCreateLists(TreeNode root, ArrayList<LinkedList<TreeNode>>lists, int level){
		if(root==null) return;
			
		LinkedList<TreeNode>list;
		if(lists.size()==level){	
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		list.add(root);
		
		dfsCreateLists(root.left, lists, level+1);
		dfsCreateLists(root.right, lists, level+1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> dfsCreate(TreeNode root){
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		dfsCreateLists(root, res, 0);
		return res;
	}
	
}
