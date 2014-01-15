public class MagicIndex {
	
	public static int findMagicIndex(int [] array){
		if(array.length==0) return -1;
		return helper(array, 0, array.length-1);
	}

	public static int helper(int [] array, int start, int end){
		if(start>end||end>array.length-1||start<0) return -1;
		int mid = (start+end)/2;
		
		if(array[mid]==mid) return mid;
		else if(array[mid]<mid) return helper(array, mid+1, end);
		else return helper(array, start, mid-1);
	}
	
	public static void main(String[]args){
		int[]array = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println(followupFindMagicIndex(array));
	}
	
	public static int followupFindMagicIndex(int [] array){
		if(array.length==0) return -1;
		return followupHelper(array, 0, array.length-1);
	}
	
	public static int followupHelper(int[]array, int start, int end){
		if(start>end||end>array.length-1||start<0) return -1;
		int mid = (start+end)/2;
		if(array[mid]==mid) return mid;		
		
		//search left
		int leftIndex = Math.min(array[mid], mid-1);			
		int res = followupHelper(array, start, leftIndex);
		if(res!=-1) return res;	
	
		//search right
		int rightIndex = Math.max(array[mid], mid+1);
		return followupHelper(array, rightIndex, end);
	}
}
