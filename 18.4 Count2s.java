public class Count2s {
	
	public static int countInRangeAtDigit(int num, int digit){
		
		int powOf10 = (int) Math.pow(10, digit);
		int nextPowerOf10 = powOf10*10;
		int right = num%powOf10;
		
		
		int roundDown = num - num%nextPowerOf10;
		int roundUp = roundDown + nextPowerOf10;
		
		int d = (num/powOf10)%10;
		
		if(d < 2){
			return roundDown/10; //02000-02999 12000-12999...52000-52999----------0~5
		}else if(d > 2){
			return roundUp/10;
		}else{
			return roundDown/10 + right + 1;
		}
		
	}

	public static int countInRange(int number){
		int count = 0;
		int length = String.valueOf(number).length();
		for(int digit = 0; digit<length; digit++){
			count = count + countInRangeAtDigit(number, digit);
		}
		return count;
	}
	
	public static void main(String[]args){
		System.out.println(countInRange(61523));
	}
}
