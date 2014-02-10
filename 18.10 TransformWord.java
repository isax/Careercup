public class TransformWord {
	
	public static LinkedList<String> transform(String start, String stop, Set<String>dict){
		
		
		start = start.toUpperCase();
		stop = stop.toUpperCase();
	
		Queue <String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		
		HashMap<String, String>backTrackMap = new HashMap<String, String>();
		
		queue.add(start);
		visited.add(start);
		
		while(!queue.isEmpty()){
			String cur = queue.poll();
			for( String oneChangeWord: getOneEditWords(cur)){
				// find our word, stop.
				if(oneChangeWord.equals(stop)){
					LinkedList<String> res = new LinkedList<String>();
					
					res.add(0, oneChangeWord);
					while(cur !=null){
						res.add(cur);
						cur = backTrackMap.get(cur);
					}
					return res;
				}
				
				// not the stop word
				// enqueue and continue BFS
				if(dict.contains(oneChangeWord)){
					if(!visited.contains(oneChangeWord)){
						queue.add(oneChangeWord);
						visited.add(oneChangeWord);
						backTrackMap.put(oneChangeWord, cur);
					}
				}
			}
		}
	
		return null;
	}
	
	public static Set<String> getOneEditWords(String word){
		Set<String> words = new TreeSet<String>();
		for(int i = 0; i<word.length(); i++){
			char[]a = word.toCharArray();
			for(char c = 'A'; c<='Z'; c++){
				if( c != word.charAt(i)){
					a[i] = c;
					words.add(String.valueOf(a));
				}			
			}
		}
		return words;
	}
}
