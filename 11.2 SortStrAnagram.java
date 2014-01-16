public class SortStrAnagram {
	
	public static void sort(String[]strArray){ 
		Arrays.sort(strArray, new AnagramComparator());
	}
	
	public static void sortBetter(String[]strArray){
		if(strArray==null) return;
		Hashtable<String, ArrayList<String>> ht = new Hashtable<String, ArrayList<String>>();
		
		for(String s: strArray){
			String key = AnagramComparator.sortChars(s);
			if(!ht.containsKey(key)){
				ArrayList<String> a = new ArrayList<String>();
				ht.put(key, a);
			}
			ht.get(key).add(s);
		}
		int index = 0;
		for(String key: ht.keySet()){
			for(String word: ht.get(key)){
				strArray[index] = word;
				index++;
			}
		}
	}
	
	public static void main(String[]args){
		String[]a = {"ahah", "ite", "abc","tie", "bac", "tei", "haha", "cab"};
		sortBetter(a);
		System.out.println(Arrays.toString(a));
	}

	/*
	public static void sortIntDescending(Integer []array){
		Arrays.sort(array, new myComparator());
	}*/
	
}

class AnagramComparator implements Comparator<String>{
	
	public static String sortChars(String str){
		char[] array = str.toCharArray();
		Arrays.sort(array); 
		
		//System.out.println(array); // print char [] works
		//Some facts:
		//If you want [a, b, c, d, e, f] you can use Arrays.toString(char[]). 
		//If you want abcdef you can use new String(char[]).
		
		return String.copyValueOf(array); // or new String(char[])... char[].toString() is wrong
	}

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return sortChars(arg0).compareTo(sortChars(arg1));
	}
	
}

/*
class myComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub	
		return o2-o1;
	}
	
}*/
