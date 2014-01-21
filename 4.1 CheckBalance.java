public class CheckBalance {
	
	/*
	 * O(n^2)
	 */
	public static boolean check(TreeNode root){
		if(root==null) return true;
		int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
		
		if(diff<=1) return check(root.left)&&check(root.right);
		else return false;
	}
	
	public static int getHeight(TreeNode root){
		if(root==null) return 0;	
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	/*
	 * Time: O(n) Space: O(logn)
	 */
	public static int checkHeight(TreeNode root){
		if(root==null) return 0;
		
		int lefth = checkHeight(root.left);
		if(lefth==-1) return -1;
		
		int righth = checkHeight(root.right);
		if(righth==-1) return -1;
		
		if(Math.abs(lefth-righth)>1) 
			return -1;	
		else {
			return Math.max(lefth, righth) + 1;
		}		
	}
	public static boolean check2(TreeNode root){
		if(checkHeight(root)==-1)
			return false;
		else
			return true;
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
		
		System.out.println(check2(n1));
		
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
