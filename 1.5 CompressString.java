public class CompressString {
	
	public static String compress(String str){
		if(str==null||str.isEmpty()) return str;
		
		//check length after compression
		if(countCompression(str)>=str.length())
			return str;	
		
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);	
		int count = 1; // initialize to 1 for first char
		for(int i = 1; i<str.length(); i++){
			char cur = str.charAt(i);
			if(last==cur){
				count++;	
			}
			else{
				sb.append(last);
				sb.append(count);
				last = cur;
				count = 1;
			}
		}
		
		//need to append things store in last and count into StringBuffer
		sb.append(last);
		sb.append(count);
		return sb.toString();
	}
	
	public static int countCompression(String str){
		char last = str.charAt(0);
		int length = 0;
		int count = 1;
		for(int i = 1; i<str.length(); i++){
			char cur = str.charAt(i);
			if(cur==last){
				count++;		
			}else{
				last = cur;
				length += 1 + String.valueOf(count).length(); // String.valueOf(int/double/char[]) return the string form
				count = 1;						
			}
		}
		length += 1 + String.valueOf(count).length();
		return length;
	}
	
	public static void main(String[]args){
		//String str = "aabcccccaaa";
		String str = "abcddddd";
		String res = compress(str);
		System.out.println(res);
	}
	
	/*
	 * StringBuffer not allowed
	 */
	public static String compressNoSB(String str){
		if(str==null||str.isEmpty()) return str;
		
		//check length after compression
		int compressedLength = countCompression(str);
		if(compressedLength>=str.length())
			return str;	
		
		char []res = new char[compressedLength];
		int index = 0;
		char last = str.charAt(0);	
		int count = 1; // initialize to 1 for first char
		for(int i = 1; i<str.length(); i++){
			char cur = str.charAt(i);
			if(last==cur){
				count++;	
			}
			else{
				index = setChar(res, index, last, count);
				last = cur;
				count = 1;
			}
		}
		
		//need to append things store in last and count into StringBuffer
		index = setChar(res, index, last, count);

		return String.valueOf(res);
	}
	
	public static int setChar(char[]c, int index, char last, int count){
		c[index] = last;
		index++;

		char[]countChars = String.valueOf(count).toCharArray();		
		for(char ch: countChars){
			c[index] = ch;
			index++;
		}
		return index;
	}

}
