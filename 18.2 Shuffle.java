public class Shuffle {
	
	public static void shuffle(int[]cards){
		int temp;
		for(int i = 0; i < cards.length; i++){
			int random = (int) (Math.random()*(cards.length-i)) + i; // generate a number from i to n-1 
			// Math.random() [0, 1)
			temp = cards[i];
			cards[i] = cards[random];
			cards[random] = temp;
		}
	}
}
