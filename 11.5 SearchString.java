public class SearchString {
	
	/*
	 * Ask whether to search for an empty string
	 * compareTo doesn't work, "" could appear in any position
	 * but non-emptyString.compareTo()always>0, so always search for the left part.
	 */
	public static int searchHelper(String []a, String str, int left, int right){
		if(left>right) return -1;
		
		int mid = (left+right)/2;
		
		if("".equals(a[mid])) {
			int l = mid-1;
			int r = mid+1;
			while(true){
				/*
				if(l<left&&r>right) return -1;
				if(l>=left){
					if(!"".equals(a[l])) {
						mid = l;
						break;
					}else
						l--;
				}
				if(r<=right){
					if(!"".equals(a[r])){
						mid = r;
						break;
					}else
						r++;
				}*/
				if(l<left&&r>right) return -1;
				else if(l>=left&&!"".equals(a[l])) {
					mid = l;
					break;
				}
				else if(r<=right&&!"".equals(a[r])){
					mid = r;
					break;
				}
				l--;
				r++;
			}
		}
		
		//check string
		if(a[mid].equals(str)) 
			return mid;
		else if(a[mid].compareTo(str)<0)
			return searchHelper(a, str, mid+1, right);
		else
			return searchHelper(a, str, left, mid-1);

	}
	
	public static int search(String[]a, String str){
		if(a==null || a.length == 0) return -1;
		return searchHelper(a, str, 0, a.length-1);
	}
	
	public static void main(String[]args){
		String [] a = {"at","", "" ,"", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(search(a, "ball"));
	}

}
