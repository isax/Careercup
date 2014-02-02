public class LargestSum {
	
	public static int largest(int []array){
		int maxSum = 0;
		int curSum = 0;
		
		for(int i = 0; i<array.length; i++){
			curSum += array[i];
			
			if(curSum>maxSum){
				maxSum = curSum;
			}else if(curSum<0){
				curSum = 0;
			}
		}
		return maxSum;
	}
}
