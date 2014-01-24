public class FindSumPaths {
	
	/*
	 * every node up
	 * Time: O(nlogn) n nodes, each go through average logn long up to root 
	 * Space: O(logn) depth of stack frames
	 */
	public static void findPathsHelper(TreeNode root, int value, TreeNode []path, int level){
		if(root==null) return;
		
		path[level] = root;
		
		int sum = 0;
		for(int i=level;i>=0;i--){
			sum +=path[i].value;
			if(sum==value) {
				print(path, i, level);
			}
		}
		
		findPathsHelper(root.left, value, path, level+1);
		findPathsHelper(root.right, value, path, level+1);
		
		path[level] = new TreeNode(Integer.MIN_VALUE);
	}
	
	public static void findPaths2(TreeNode root, int value){
		TreeNode [] path = new TreeNode[Depth(root)];
		findPathsHelper(root, value, path, 0);
	}
	
	static ArrayList<ArrayList<TreeNode>> paths2 = new ArrayList<ArrayList<TreeNode>>();
	public static void print(TreeNode []path, int index, int level){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		for(int i = index; i<=level;i++){
			list.add(path[i]);
		}
		paths2.add(list);
	}
	
	public static int Depth(TreeNode root){
		if(root==null){
			return 0;
		}else{
			return Math.max(Depth(root.left), Depth(root.right))+1;
		}
	}
	
	public static void main(String[]args){
		TreeNode n1 = new TreeNode(-1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		findPaths2(n1, 3);
		for(ArrayList<TreeNode> list: paths2){
			for(TreeNode t: list){
				System.out.print(t.value+" ");				
			}
			System.out.println();
		}
		
	}

}
