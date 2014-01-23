public class CheckPermutation {
	
	public static String sort(String str){
		char[]array = str.toCharArray();
		Arrays.sort(array);
		return String.copyValueOf(array);
	}

	public static boolean checkPerm(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		return sort(s1).equals(sort(s2));
	}
	
	public static boolean checkPerm2(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		
		int [] letters = new int[256];
		
		for(int i = 0; i<s1.length(); i++){
			letters[s1.charAt(i)]++;
		}
		
		for(int i = 0; i<s2.length(); i++){
			if(--letters[s2.charAt(i)]<0) return false;
		}
		return true;
	}
}
