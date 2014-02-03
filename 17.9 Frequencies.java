public class Frequencies {

	public static Hashtable<String, Integer> setDic(String[]book){
		if(book==null) return null;
		Hashtable<String, Integer> res = new Hashtable<String, Integer>();
		
		for(String s: book){
			s = s.toLowerCase();
			String trim_s = s.trim();
			if(!trim_s.equals("")){
				if(res.containsKey(trim_s)){
					int occ = res.get(trim_s) + 1;
					res.put(trim_s, occ);
				}else{
					res.put(trim_s, 1);
				}
			}
		}
		return res;
	}
	
	public static int getFrequency(Hashtable<String, Integer>dic, String word){
		if(word==null||dic==null) return -1;
		word = word.toLowerCase();
		
		if(dic.containsKey(word)){
			return dic.get(word);
		}
		return 0;
	}
	
	public static void main(String []args){
		String[] words = {"the  ", "Lara", "and  ", "   ", "career", "it"};
		Hashtable<String, Integer> dic = setDic(words);
		
		System.out.println(dic.keySet());
		System.out.println("and" + ": " + getFrequency(dic, "and"));
	}
}
