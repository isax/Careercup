public class BuildBinary {
	
	public static TreeNode buildHelper(int[]a, int left, int right){
		if(left>right) return null;
		int mid = (left+right)/2;
		
		TreeNode root = new TreeNode(a[mid]);
		root.left = buildHelper(a, left, mid-1);
		root.right = buildHelper(a, mid+1, right);
		
		return root;
	}
	
	public static TreeNode build(int[]a){
		if(a==null||a.length==0){
			return null;
		}
		return buildHelper(a, 0, a.length-1);
	}
	
	public static void main(String []args){
		int []a = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = build(a);
		preorder(root);
	}
	
	public static void preorder(TreeNode root){
		if(root!=null){
			System.out.println(root.value);
			preorder(root.left);
			preorder(root.right);
		}
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
