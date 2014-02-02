package Q17_4;

public class Max {
	
	public static int flipBit(int i){
		return i^1;
	}
	
	public static int sign(int i){
		return flipBit((i>>31)&1);
	}

	/*
	 * if a and b have diff signs,
	 * use sign(a).
	 * a>0, b<0, sign(a) = 1
	 * a<0, b>0, sign(a) = 0
	 * 
	 * else use sign(a-b)
	 */
	public static int getMax(int a, int b){
		int signa = sign(a);
		int signb = sign(b);
		int signc = sign(a-b);
		
		int use_sign_a = signa ^ signb;
		int use_sign_diff = flipBit(signa^signb);
		
		int use = signa*use_sign_a + signc*use_sign_diff;
		
		return a*use+flipBit(use)*b;
	}
	
	public static void main(String[]args){
		int res = getMax(-45, Integer.MAX_VALUE);
		System.out.println(res);
	}
}
