public class CheckRotation {
	
	public boolean check(String s1, String s2){
		if(s1.length()==s2.length()&&s1.length()>0){//check length and not empty
			String s = s1 + s2;
			return isSubstring(s, s2);
		}
		return false;
	}

}
