import java.util.HashMap;


public class TwoSum {
	
	/*
	 * O(n^2)
	 */
	public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int len = numbers.length;
        
        for(int i = 0; i<len; i++){
            for (int j = i + 1; j<len; j++){
                if(numbers[i]+numbers[j]==target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
        
    }
	
	
	/*
	 * O(nlogn)
	 */
	public static int[] twoSum2(int[] numbers, int target) {
        int [] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int len = numbers.length;
        
        for(int i = 0; i<len; i++){
            hm.put(numbers[i], i);
        }
        for(int i = 0; i<len; i++){
            int expect = target - numbers[i];
            if(hm.containsKey(expect)&&hm.get(expect)!=i){
                if(i<hm.get(expect)){
                    res[0] = i + 1;
                    res[1] = hm.get(expect) + 1;
                }else{
                    res[0] = hm.get(expect) + 1;
                    res[1] = i + 1;
                }
                return res;
            }
        }       
        return res;
    }
	
	public static void main(String []args){
		int [] t = {3,2,4};
		int [] res = twoSum2(t,6);
		
		System.out.println(res[0] +" " + res[1]);
	}
	

}
