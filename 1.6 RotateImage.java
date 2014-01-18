public class RotateImage {

	/*
	 * O(n^2)
	 */
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer<n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int index = first; index<last; index++){ //not index<=last !!
                int cur = index - first;
                int temp = matrix[first][index];
                
                //left->top
                matrix[first][index] = matrix[last-cur][first];
                
                //bottom->left
                matrix[last-cur][first] = matrix[last][last-cur];
                
                //right->bottom
                matrix[last][last-cur] = matrix[index][last];
                
                //top->right
                matrix[index][last] = temp;
            }
        }
    }
}
