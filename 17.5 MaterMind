public class MaterMind {
	
	public static int getCode(char c){
		switch(c){
		case 'B': return 0;
		case 'G': return 1;
		case 'R': return 2;
		case 'Y': return 3;
		default: return -1;
		}
	}
	
	public static Res estimate(String guess, String sol){
		if(guess.length()!=sol.length()) return null;
		
		int length = guess.length();
		int hits = 0;
		int phits = 0;
		
		int []array = new int[4];
		
		for(int i = 0; i<length; i++){
			char s_c = sol.charAt(i);
			char g_c = guess.charAt(i);		
			if(s_c==g_c){
				hits++;
			}else{
				int code = getCode(sol.charAt(i));
				array[code]++;
			}
		}
		
		for(int i = 0; i<length; i++){
			int code = getCode(guess.charAt(i));
			if(code>=0 && guess.charAt(i)!=sol.charAt(i) && array[code]>0){
				phits++;
				array[code]--;
			}
		}
		return new Res(hits, phits);
	}
}
class Res{
	int hits = 0;
	int pseudoHits = 0;
	
	Res(int hits, int phits){
		this.hits = hits;
		this.pseudoHits = phits;
	}
	public String toString(){
		return hits+ " "+pseudoHits; 
	}
}
