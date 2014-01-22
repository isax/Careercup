public class CheckBST {
    /*
     * Time: O(n) Space: O(n+logn) = O(n)
     */
    public boolean isValidBST(TreeNode root) {
                ArrayList<Integer>a = new ArrayList<Integer>();
                inorder(root, a);
                
                for(int i = 1; i<a.size(); i++){
                        if(a.get(i-1)>a.get(i)) return false;
                }
                return true;
    }
    
    public static void inorder(TreeNode root, ArrayList<Integer>a){
                if(root==null) return;
                inorder(root.left, a);        
                a.add(root.val);
                inorder(root.right, a);        
    }
    
 
    /*
     * 34 / 54 test cases passed...Have no idea!!
     */
    static int lastCheck = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
                if(root==null) return true;
                
                if(!isValidBST(root.left)) return false;
                
                if(root.val<lastCheck){
                    lastCheck = root.val;
                        return false;
                }
                lastCheck = root.val;
                if(!isValidBST(root.right)) return false;
                
                return true;
    }
    
    /*
     * Wrapper Class
     */
    public static boolean checkBST3(TreeNode root, Wrapper wr){
                if(root==null) return true;
                
                if(!checkBST3(root.left, wr)) return false;
                
                if(root.val<wr.value){
                        return false;
                }
                wr.value = root.val;
                if(!checkBST3(root.right, wr)) return false;
                
                return true;
    }
    public boolean isValidBST(TreeNode root) {
                Wrapper wr = new Wrapper(Integer.MIN_VALUE);
                return checkBST3(root, wr);
    }
  
    /*
	   * Min/Max Solution Time: O(n) Space: O(logn)
	   *      20
	   * 
	   * 10       30 ----------20 needs to be <= its max; 30 needs to be > its min.
	   */
    public static boolean checkMinMax(TreeNode root, int min, int max){
                if(root==null) return true;
                
                if(root.val>max||root.val<=min){
                        return false;
                }
                
                if(!checkMinMax(root.left, min, root.val))
                        return false;
                
                if(!checkMinMax(root.right, root.val, max))
                        return false;
                
                return true;
    }
    public boolean isValidBST(TreeNode root) {
        return checkMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
}

class Wrapper{
        int value;
        Wrapper(int value){
                this.value = value;
        }
}
