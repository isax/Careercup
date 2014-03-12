public class Merge2SortedArrays {
        
        public static void merge(int A[], int m, int B[], int n) {
                if(A==null||B==null) return;
                
                int indexLast = m + n - 1;
                int lastA = m-1;
                int lastB = n-1;
                
                while(lastA>=0 && lastB>=0){
                        if(A[lastA]>=B[lastB]) {
                                A[indexLast]=A[lastA];
                                lastA--;
                        }else{
                                A[indexLast]=B[lastB];
                                lastB--;
                        }
                        indexLast--;
                }
                
                while(lastB>=0){
                        A[indexLast] = B[lastB];
                        lastB--;
                        indexLast--;
                }
                assert(indexLast==0):"lastindex!=0";
    }

}
