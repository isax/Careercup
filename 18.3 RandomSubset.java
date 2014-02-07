public class RandomSubset {
	
	public static int [] getSubset(int[]original, int m){
		
		int [] subset = new int[m];
		int [] set = original.clone();
		
		for(int i = 0; i<m; i++){
			int random = (int)(Math.random()*(set.length-i)) + i;
			subset[i] = set[random];
			set[random] = set[i];
			
		}
		return subset;
	}

}
