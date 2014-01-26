public class InsertMIntoN {
	
	public static int insert(int M, int N, int i, int j){
		int allOnes = ~0;
		int s = (~allOnes)<<(j+1);
		
		int t = (1<<i)-1;
		
		int mask = s|t;
		
		int n_cleared = N & mask;
		int m_shifted = M<<i;	
		
		return n_cleared | m_shifted;	
	}
}
