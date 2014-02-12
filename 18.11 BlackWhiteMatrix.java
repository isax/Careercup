public class BlackWhiteMatrix {
	
	public static Subsquare findSquare(int[][]matrix){
		for(int i = matrix.length; i >= 1; i--){
			Subsquare square = findSquareWithSize(matrix, i);
			if(square!=null) return square;
		}
		return null;
	}
	
	public static Subsquare findSquareWithSize(int[][]matrix, int squareSize){
		int count = matrix.length + 1 - squareSize;
		
		for(int row = 0; row<count; row++){
			for(int col = 0; col<count; col++){
				if(isSquare(matrix, row, col, squareSize)){
					return new Subsquare(row, col, squareSize);
				}
			}
		}
		return null;
	}
	
	public static boolean isSquare(int[][] matrix, int row, int col, int size){
		//check top and bottom 
		// col -- col+size-1
		for(int i = 0; i<size; i++){
			if(matrix[row][col+i]==1){
				return false;
			}
			if(matrix[row+size-1][col+i]==1){
				return false;
			}
		}
		
		//check left and right
		for(int i = 1; i<size-1; i++){
			if(matrix[row+i][col]==1){
				return false;
			}
			if(matrix[row+i][col+size-1]==1){
				return false;
			}
		}
		return true;
	}

}

class Subsquare {
	public int row, column, size;
	public Subsquare(int r, int c, int sz) {
		row = r;
		column = c;
		size = sz;
	}

	public void print() {
		System.out.println("(" + row + ", " + column + ", " + size + ")");
	}
}
