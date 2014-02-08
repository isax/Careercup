public class KlargestInN {
	
	public static int partition(int []a, int pivot, int left, int right){
		while(true){
			while(left<=right&&a[left]<=pivot){
				left++;
			}
			while(left<=right&&a[right]>pivot){
				right--;
			}
			
			if(left>right){
				return left - 1;
			}
			swap(a, left, right);
		}
	}
	
	public static int rank(int[]a, int rank, int left, int right){
		int pivot = a[randomInRange(left,right)];
		
		// 2 parts: left - leftEnd    leftEnd+1 - right
		int leftEnd = partition(a, pivot, left, right);
		
		int leftSize = leftEnd - left + 1; 
		
		if(leftSize==rank+1){
			return max(a, left, leftEnd);
		}else if(leftSize>rank+1){
			return rank(a, rank, left, leftEnd);
		}else{
			return rank(a, rank-leftSize, leftEnd+1, right);
		}
	}
	public static int max(int[]a, int left, int right){
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(a[i], max);
		}
		return max;
	}
	
	public static int randomInRange(int left, int right){
		return left + (int)( Math.random()*(right-left+1));
	}

	public static void swap(int []a, int left, int right){
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	public static void main(String[]args){
		int [] a = {71, 23, 6, 25, 39, 38, 7};
		for(int i = 0;i<a.length; i++){
			System.out.println(rank(a, 6, 0, a.length-1));
			for(int j = 0; j<6+1; j++){
				System.out.print(a[j] +" ");
			}
		}
	}
}

