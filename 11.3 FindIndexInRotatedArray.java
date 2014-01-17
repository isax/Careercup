public class FindIndexInRotatedArray {
	
	public int search(int[] A, int target) {
                if(A==null) return -1;
                return search(A, target, 0, A.length-1);
        }
	
	/*
	 * if the left most one is less than the mid, the left part is in ascending order,
	 * if the left most one is larger than the mid, the right part is in descending order.
	 * At least a half is in ascending order.
	 */
	public int search(int []a, int x, int left, int right){
		if(left>right) return -1;
		
		int mid = (left+right)/2;
		if(a[mid]==x) return mid;

		if(a[left]<a[mid]){ //left part is ascending
			if(x<a[mid]&&x>=a[left]) 
				return search(a, x, left, mid-1);
			else 
				return search(a, x, mid+1, right);	
		}else if(a[left]>a[mid]){ //right part is ascending	
			if(x<=a[right]&&x>a[mid]) 
				return search(a,x, mid+1, right);
			else 
				return search(a,x, left, mid-1);
		}else{ 
			if(a[mid]!=a[right]) //right is different, left part must be all repeats. e.g. 2 2 2 3 4 or 2 2 2 2 1
				return search(a, x, mid+1, right);
			else{//have to search both halves  e.g. 2 3 2 2 2 or 2 2 2 2 3 4 2
				int index = search(a,x, left, mid-1);
				if(index!=-1)  
					return index;
				else
					return search(a, x, mid+1, right);
			}
		}
	}

}
