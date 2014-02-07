public class Addition {
	
	public static int add(int a, int b){
		
		int pureAdd = a ^ b;		
		int carry = (a & b) << 1;
		
		if(carry==0) 
			return pureAdd;	
		else 
			return add(carry, pureAdd);
			
	}
	
	/*
	 * test cases:
	 * 2 3
	 * 11 23
	 * 89 23
	 * 759 674
	 * 100 0
	 */
	public static void main(String[]args){
		System.out.println(add(759, 674));
	}

}
