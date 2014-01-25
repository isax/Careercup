public class Cents {
	
	/*
	 * Similar to 4.9
	 */
	public static int computeHelper(int cur, int sum){
		if(sum<0) return 0;
		if(sum==0) return 1;
		
		int res1 = 0;
		int res5 = 0;
		int res10 = 0;
		int res25 = 0;
		
		if(cur<=1) res1 = computeHelper(1, sum-1);	
		if(cur<=5) res5 = computeHelper(5, sum-5);	
		if(cur<=10) res10 = computeHelper(10, sum-10);		
		if(cur<=25) res25 = computeHelper(25, sum-25);
		
		return res1+res5+res10+res25;
	}
	
	public static int compute(int cur){
		return computeHelper(0, cur);
	}
	
	public static void main(String[] args) {
		System.out.println(compute(210));
		System.out.println(makeChange(210));
 
	}

	public static int makeChangeHelper(int n, int []denoms, int index, int [][]map){
		if(map[n][index]!=0) {
			System.out.println(n+" "+index);
			return map[n][index];
		}
		
		if(index>=denoms.length-1) return 1;
		
		int denom = denoms[index];
		int ways = 0;
		
		for(int i = 0; i*denom<=n; i++){
			ways += makeChangeHelper(n-i*denom, denoms, index+1, map); 
		}
		map[n][index] = ways;
				
		return ways;
	}
	
	
	public static int makeChange(int n){
		int []denoms = {25, 10, 5, 1};
		int[][] map = new int[n + 1][denoms.length];
		return makeChangeHelper(n, denoms, 0, map);
	}

}
