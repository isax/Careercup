public class Indices {
	
	public static Res find(int []a){
		if(a==null||a.length==0) return null;
		
		int max = Integer.MIN_VALUE;
		int m = 0;
		int n = 0;

		int min = Integer.MAX_VALUE;
		
		for(int i =0; i<a.length;i++){
			
			if(a[i]<max){
				if(a[i]<min){
					m = i;
					min = a[i];
				}	
				n = i;
			}else{
				max = a[i];
			}
		}
		
		if(m==0) return new Res(0,0);
		
		int i;
		for( i = m-1; a[i]>a[m]; i--);
		m = i + 1;
		
		return new Res(m, n);
	}
	
	public static int leftEndIndex(int[]a){
		for(int i = 1; i<a.length; i++){
			if(a[i]<a[i-1]) return i-1;
		}
		
		return a.length-1;
	}
	
	public static int RightEndIndex(int[]a){
		for(int i = a.length - 2; i>=0; i--){
			if(a[i+1]<a[i]) return i+1;
		}
		
		return 0;
	}
	
	public static int shrinkLeft(int[]a, int min_mid, int start){
		int num = a[min_mid];
		for(int i = start-1; i>=0; i--){
			if(a[i]<=num) {
				return i+1;
			}
		}
		return 0;
	}
	
	public static int shrinkRight(int[]a, int max_mid, int start){
		int num = a[max_mid];
		for(int i = start; i<a.length; i++){
			if(a[i]>=num) return i-1;
		}
		return a.length-1;
	}
	
	public static void findSequence(int[]a){
		int endLeft = leftEndIndex(a);
		int startRight = RightEndIndex(a);
		
		if(endLeft==a.length-1) return;
		int min_mid = endLeft + 1;
		int max_mid = startRight - 1;
		
		// Start from endLeft, which is the max in left sub;
		// end in startRight, which is the min in right sub.
		// Cos at least the last one in mid > start right; first one in mid < end left
		// left.end>mid.start && right.start<mid.end
		// Have to include them
		for(int i = endLeft; i<=startRight; i++ ){
			if(a[i]<a[min_mid]) min_mid = i;
			if(a[i]>a[max_mid]) max_mid = i;
		}
		
		int leftShrink = shrinkLeft(a, min_mid, endLeft);
		int rightShrink = shrinkRight(a, max_mid, startRight);
		
		System.out.println(leftShrink+"---"+rightShrink);
	}
	
	public static void main(String[]args){
		int []a  = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		//int []a  = { 1, 2, 3, 4, 5, 11, 7, 12, 6, 7, 16, 18, 19 };
		Res r = find(a);
		System.out.println(r.toString());
		
		findSequence(a);
	}

}
