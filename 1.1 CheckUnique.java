public class CheckUnique {
	
	public static boolean check(String str){
		if(str==null) return true;
		if(str.length()>256) return false;
		
		boolean [] a = new boolean[256];
		
		for(int i = 0; i<str.length(); i++){
			char c = str.charAt(i);
			if(a[c]) return false;
			else a[c] = true;
		}
		return true;
	}

}
