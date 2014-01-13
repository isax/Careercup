import java.util.*;

public class Subsets {
	
	/*
	 * Subsets of ArrayList which starts from index to end
	 */
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S, int index){
		if(S==null) return null;
		
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
}
