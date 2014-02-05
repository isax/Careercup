public class TwoSum {
	
	/*
	 * O(nlogn)
	 */
	public static ArrayList<int[]> twoSums(int[]array,int sum){
		if(array==null) return null;
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		Arrays.sort(array);
		
		int low = 0;
		int high = array.length - 1;
		while(low<high){
			int curSum = array[low]+array[high];
			if(curSum==sum){
				int[] oneRes = new int[2];
				oneRes[0] = array[low];
				oneRes[1] = array[high];
				low++; high--;
				list.add(oneRes);
				System.out.println(oneRes[0]+" "+oneRes[1]);
			}else if(curSum<sum){
				low++;
			}else{
				high--;
			}
		}
		
		return list;	
	}
	
	public static void main(String[]args){
		int [] a = {0, 1, 2, 2, 3, 3, 4};
		twoSums(a, 5);
	}

}
