public class LongestWordMade {
	
	public static String longest(String[]a){
		Hashtable<String, Boolean> ht = new Hashtable<String, Boolean>();
		
		Arrays.sort(a, new MyComparator());
		
		for(String str : a){
			ht.put(str, true);
		}
		
		for(String s : a){
			if(canBuild(s, true, ht)){
				return s;
			}
		}
		return "";
	}
	
	public static boolean canBuild(String s, boolean isOriginalWord, Hashtable<String, Boolean> ht){
		if(ht.containsKey(s) && !isOriginalWord){
			return ht.get(s);
		}
		
		for(int i=1; i<s.length(); i++){
			String leftSub = s.substring(0, i);
			String rightSub = s.substring(i);
			if(ht.containsKey(leftSub)&& ht.get(leftSub)==true &&canBuild(rightSub, false, ht)){
				return true;
			}
		}
		ht.put(s, false);
		return false;
	}
	
	public static void main(String[] args) {
		String[] arr = createGiantArray();	
		System.out.println(longest(arr));
		/*for(String key: map.keySet()){
			System.out.println(key + " " + map.get(key));
		}*/
	}
	
	public static String[] createGiantArray() {
		String arr[] = {"a", 
				"able", 
				"about", 
				"account", "aable", };
		return arr;
	}
}

class MyComparator implements Comparator<String>{

	public int compare(String s1, String s2){
		if(s1.length()>s2.length()) return -1;
		if(s1.length()<s2.length()) return 1;
		return 0;
	}
	
}
