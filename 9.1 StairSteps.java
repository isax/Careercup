import java.util.*;

class StairSteps{
  public static HashMap<Integer, Integer>ways = new HashMap<Integer, Integer>();

  public static long ways(int n, long[]map){  
	  if(n<0) return 0;
	  else if(n==0) return 1;
	  else if(map[n]!=0) return map[n];
	  else{
	      map[n] = ways(n-1, map)+ways(n-2, map)+ways(n-3, map);
	      return map[n];
	  }
  }
  
  public static int climbStairs(int n) {
      if(n<0) return 0;
      else if(n==0) return 1;
      else {
          int n1, n2, n3;
          
          if(ways.containsKey(n-1)) n1 = ways.get(n-1);
          else n1 = climbStairs(n-1);
          if(ways.containsKey(n-2)) n2 = ways.get(n-2);
          else n2 = climbStairs(n-2);
          if(ways.containsKey(n-3)) n3 = ways.get(n-3);
          else n3 = climbStairs(n-3);
          
          int res = n1 + n2 + n3;
          ways.put(n, res);
          return res;
      }
  }

  
  public static void main(String []args){
    int n = 5;
    long [] map = new long[200];
    System.out.println(ways(n, map));
    System.out.println(climbStairs(n));
  
  }

}
