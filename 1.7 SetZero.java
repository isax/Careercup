public class SetZero {
	
	public void setZero(int[][]matrix){
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		boolean [] row = new boolean[rowNum];
		boolean [] col = new boolean[colNum];
		
		for(int i = 0; i<rowNum; i++){
			for(int j = 0; j<colNum; j++){
				if(matrix[i][j]==0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i = 0; i<rowNum; i++){
			for(int j = 0; j<colNum; j++){
				if(row[i]==true || row[j]==true){
					matrix[i][j] = 0;
				}
			}
		}	
		
	}

}
