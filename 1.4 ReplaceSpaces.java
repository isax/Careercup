public class ReplaceSpaces {

	public static int replace(char[]a, int length){
		int count = 0;
		
		for(int i = 0; i<length; i++){
			if(a[i]==' '){
				count++;
			}
		}
		
		int newLength = length + 2*count;
		int cur = newLength-1;
		
		for(int i = length-1; i>=0; i--){
			if(count==0) break;
			
			if(a[i]!=' '){
				a[cur--] = a[i];
			}
			else{
				count--;
				a[cur--] = '%';
				a[cur--] = '0';
				a[cur--] = '2';
			}
		}
		
		return newLength;
	}

	public static void main(String[] args) {
		String str = "ch el s ea       ";
		char[] a = str.toCharArray();

		System.out.println(replace(a, 10));
		System.out.println(a);		
		
	}
}
