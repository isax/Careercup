public class ZeroesInFactorial {
	
	public static int count(int n){
		if(n<0) return -1;
		int sum = 0;
		while((n/=5) > 0){
			//n = n/5;
			sum += n;
		}
		return sum;
	}
	
	
	public static int check(int i){
		int count = 0;
		while(i%5==0){
			count++;
			i = i/5;
		}
		return count;
	}

}
