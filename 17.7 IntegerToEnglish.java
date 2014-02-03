public class IntegerToEnglish {
	
	public static String [] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String[] bigs = {"", "Thousand", "Million"};

	public static String numberToString(int n){
		if(n==0) return "zero";
		if(n<0) return "negative "+ numberToString(-1*n);
		
		String s = "";
		int count = 0;
		while(n>0){
			if(n%1000!=0){
				s = numberToString100(n%1000) + bigs[count] + " "+s;
			}
			n = n/1000;
			count++;
		}
		
		return s;
	}
	
	public static String numberToString100(int n){
		String s = "";
		if(n>=100){
			s = digits[n/100-1] + " hundred ";
			n = n%100;
		}
			
		if(n>=11&&n<=19){
			s += teens[n-11] + " ";
			return s;
		}else if(n==10||n>=20){
			s += tens[n/10-1] + " ";
			n = n%10;
		}
		
		if(n>=1&&n<=9){ // have to add n>=1, exception: 0 
			s += digits[n-1] + " ";
		}
		
		return s;
		
	}
	
	public static void main(String[]args){
		int i = 10100111;
		System.out.println(numberToString(i));
	}

}
