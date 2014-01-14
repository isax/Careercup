import java.util.*;

public class Subsets {
	
	/*
	 * Subsets of ArrayList which starts from index to end
	 */
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S, int index){
		if(S==null) return null;
		
		Collections.sort(S, Collections.reverseOrder());// sort S in descending order
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();		
		if(S.size()==index){
			ArrayList<Integer>subset = new ArrayList<Integer>();
			res.add(subset); //empty set
			return res;
		}
		
		int first = S.get(index);
		ArrayList<ArrayList<Integer>> laterSubsets =  subsets(S, index+1);
		res.addAll(laterSubsets);
		for(ArrayList<Integer>list: laterSubsets){			
			//res.add(list);
			ArrayList<Integer>addition = new ArrayList<Integer>();
			addition.addAll(list);//addAll: clone an arraylist	
			addition.add(first);
			res.add(addition);
		}
		return res;	
	}
	
	/*
	 * Combinatorial Solution
	 * 
	 */
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Collections.sort(S);
		int max = (int) Math.pow(2,S.size()); //cast double to int 
		//max = 1 << S.size(); 
		for(int i = 0; i<max; i++){
			ArrayList<Integer>item = convertToSet(S, i);
			res.add(item);
			
		}
		return res;
	}
	
	public static ArrayList<Integer> convertToSet(ArrayList<Integer>S, int x){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int index = 0;
		for(int k = x; k>0; k>>=1){ //k>0 no more 1's in x, no need to add more numbers, just quit
			if((k&1)==1){ //put on parentheses (k&1)
				res.add(S.get(index));
			}
			index++;		
		}
		return res;
	}
}
