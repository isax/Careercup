public class RankBST {
	public static Node root;
	
	public static void track(int value){
		if(root==null){
			root = new Node(value);
		}else{
			root.insert(value);
		}
	}
	
	public static int getRankOfNumber(int value){
		return root.getRank(value);
	}

	public static void main(String[]args){
		track(5);
		track(1);
		track(4);
		track(4);
		track(5);
		track(9);
		track(7);
		track(13);
		track(3);
		
		System.out.println(getRankOfNumber(14));
		System.out.println(getRankOfNumber(3));
		System.out.println(getRankOfNumber(4));
	}
}

class Node{
	int value;
	int leftSub=0;
	Node left;
	Node right;
	
	Node(int value){
		this.value = value;
	}
	
	void insert(int value){
		if(this.value>=value){
			if(left!=null) left.insert(value);
			else left = new Node(value);
			leftSub++;
		}else{
			if(right!=null) right.insert(value);
			else right = new Node(value);
		}
	}
	
	int getRank(int value){
		if(this.value==value){
			return leftSub;
		}
		else if(this.value>value){
			if(left==null) return -1;
			else return left.getRank(value);
		}else{
			if(right==null) return -1;
			else{
				int rightNumber = right.getRank(value);
				if(rightNumber==-1) return -1;
				else return 1+leftSub+rightNumber;
			}
				
		}
	}
}
