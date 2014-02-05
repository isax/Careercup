public class Random {
	
	public static int ran7(){
			
		int num = Integer.MAX_VALUE;
		while(num>21){
			num = 5*ran5()+ran5();
		}
		return num%7;
		
	}

}
