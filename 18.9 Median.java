public class Median {
	
	public static Comparator <Integer> maxComparator;
	public static Comparator <Integer> minComparator;
	
	public static PriorityQueue <Integer> maxHeap; 
	public static PriorityQueue <Integer> minHeap;

	public static void insert(int i){
		double median = getMedian();
		System.out.println(getMedian());
		
		if(i>median){
			if(maxHeap.size() > minHeap.size()){
				minHeap.offer(i);
			}else{
				minHeap.offer(i);
				maxHeap.offer(minHeap.poll());
			}
		}else{
			if(maxHeap.size() > minHeap.size()){
				maxHeap.offer(i);
				minHeap.offer(maxHeap.poll());
			}else{
				maxHeap.offer(i);
			}
		}
		
	}
	
	public static double getMedian(){
		if(maxHeap.isEmpty()) return Integer.MAX_VALUE;
		
		if(maxHeap.size() > minHeap.size()){
			return maxHeap.peek();
		}else{
			return ((double)minHeap.peek() + (double) maxHeap.peek())/2;
		}
	}
	
	public static void main(String[]args){
		maxComparator = new MaxComparator();
		minComparator = new MinComparator();
		maxHeap = new PriorityQueue<Integer>(1, maxComparator);
		minHeap = new PriorityQueue<Integer>(1, minComparator);
		
		insert(3);
		System.out.println(getMedian() + " MaxSize:" + maxHeap.size() + " MinSize:" + minHeap.size() + " MaxPeek: " + maxHeap.peek() + " MinPeek: " + minHeap.peek());
		//insert(5);
		//System.out.println(getMedian() + " MaxSize:" + maxHeap.size() + " MinSize:" + minHeap.size() + " MaxPeek: " + maxHeap.peek() + " MinPeek: " + minHeap.peek());
		//insert(4);
		//System.out.println(getMedian() + " MaxSize:" + maxHeap.size() + " MinSize:" + minHeap.size() + " MaxPeek: " + maxHeap.peek() + " MinPeek: " + minHeap.peek());
	 
		//insert(4);
		//System.out.println(getMedian() + " MaxSize:" + maxHeap.size() + " MinSize:" + minHeap.size() + " MaxPeek: " + maxHeap.peek() + " MinPeek: " + minHeap.peek());
	
		//insert(0);
		//System.out.println(getMedian() + " MaxSize:" + maxHeap.size() + " MinSize:" + minHeap.size() + " MaxPeek: " + maxHeap.peek() + " MinPeek: " + minHeap.peek());
	
	}

}

class MaxComparator implements Comparator<Integer>{
	public int compare(Integer i1, Integer i2){
		if(i1 < i2) return 1;
		if(i1 > i2) return -1;
		return 0;
	}
}

class MinComparator implements Comparator<Integer>{
	public int compare(Integer i1, Integer i2){
		if(i1 < i2) return -1;
		if(i1 > i2) return 1;
		return 0;
	}
}
