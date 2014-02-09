public class ShortestDistance {
	
	public static int shortest(String[]s, String w1, String w2){
		
		if(s==null) return -1;
		
		int min = Integer.MAX_VALUE;
		int lastIndex1 = -1;
		int lastIndex2 = -1;
		
		for(int i = 0; i<s.length; i++){
			if(s[i].equals(w1)){
				lastIndex1 = i;
				
				int distance = lastIndex1 - lastIndex2;
				if(lastIndex2>=0 && distance<min){	
					min = distance;
					
				}
			}else if(s[i].equals(w2)){
				lastIndex2 = i;
				int distance = lastIndex2 - lastIndex1;
				if(lastIndex1>=0 && distance<min){
					min = distance;
					
				}
			}
		}
		return min;
	}

	public static void main(String[]args){
		String[] s = {"a", "c", "d", "r", "b", "a"};
		System.out.println(shortest(s, "a", "d"));
	}
}
