public class SwapNumber {
	
	public static void swap(int a, int b){
		a = a - b;
		b = a + b;
		a = b - a;
	}
	
	public static void swap_bit(int a, int b){
		a = a^b;
		b = a^b;
		a = a^b;
	}

}
