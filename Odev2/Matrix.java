
import java.util.Arrays;

/**
 * A class that models systems of linear equations (Matrices)
 * as used in linear algebra.
 * 
 * @author Hasan Hüseyin Niğdeli
 * @version initial version
 */
public class Matrix {
    
    // instance variable
	private int[][] matrix;
	
	public Matrix(){
        matrix = new int[1][1];
    }


    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public Matrix(int[][] mat) {
    	if ( mat == null ) {
    		throw new IllegalArgumentException("girilen matrix null olamaz!");
    	}
    	if(mat.length <= 0) {
    		throw new IllegalArgumentException("girilen matrix uzunluğu sıfır veya sıfırdan küçük olamaz!");
    	}
    	if(mat[0].length <= 0) {
    		throw new IllegalArgumentException("girilen matrix sütun sayısı sıfır veya sıfırdan küçük olamaz!");
    	}

    	matrix = new int[mat.length][mat[0].length];
    	for(int row = 0; row < mat.length; row++){
    		for(int column = 0; column < mat[0].length; column++){
    			matrix[row][column] = mat[row][column];
    		}
    	}
    	
        
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public Matrix(int numRows, int numCols, int initialVal) {
    	
    	if (( numRows <= 0 )) {
    		throw new IllegalArgumentException("sutün sayısı sıfırdan küçük olamaz");
    	}
    	if (( numCols <= 0 )) {
    		throw new IllegalArgumentException("kolon sayısı sıfırdan küçük olamaz");
    	}
    	
    	matrix = new int[numRows][numCols];
        for(int row = 0; row < numRows; row++){
        	for(int column = 0; column < numCols; column++){
        		matrix[row][column] = initialVal;
        	}
        }
       
    	
    }
    


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
    	return matrix.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns(){
    	return matrix[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {

    	
    	return matrix[row][col];
    }
    
    public void changeElement(int row, int col, int newValue){

    	matrix[row][col] = newValue;
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
     */
    public Matrix add(Matrix rightHandSide){
    	
        
    	Matrix tempMatrix2 = new Matrix(matrix.length, matrix[0].length, 0);
        for ( int row = 0; row < matrix.length; row++)
        {
        	for ( int col = 0; col < matrix[0].length; col++)
        	{
        		tempMatrix2.changeElement(row, col, matrix[row][col] + rightHandSide.getVal(row, col));
        	}
        }
        
        return tempMatrix2;
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
     */
    public Matrix subtract(Matrix rightHandSide){
    	Matrix tempMatrix2 = new Matrix(matrix.length, matrix[0].length, 0);

    	for ( int row = 0; row < matrix.length; row++)
    	{
    		for ( int col = 0; col < matrix[0].length; col++)
    		{
    			tempMatrix2.changeElement(row, col, matrix[row][col] - rightHandSide.getVal(row, col));
    		}
        }
        
        return tempMatrix2;
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
     */
    public Matrix multiply(Matrix rightHandSide){
    	Matrix tempMatrix3 = new Matrix(matrix.length, rightHandSide.getNumColumns(), 0);


    	for(int row = 0; row < matrix.length; row++){
    		for(int col = 0; col < rightHandSide.getNumColumns(); col++){
    			int count = 0;
    			for(int bump = 0; bump < matrix[0].length; bump++){
    				count += matrix[row][bump] * rightHandSide.getVal(bump, col);
    			}
    			tempMatrix3.changeElement(row, col, count);
    		}
    	}
    	return tempMatrix3;
    } 


    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix 
     * multiplied by factor. 
     * In other words after this method has been called 
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public Matrix getScaledMatrix(int factor) {
    	for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < matrix[0].length; col++){
        		matrix[row][col] *= factor;
        	}
        }
        return null;
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public Matrix getTranspose() {
    	Matrix transposedMatrix = new Matrix(matrix[0].length, matrix.length, 0);
        for (int row = 0; row < matrix.length; row++)
        {
        	for (int col = 0; col < matrix[0].length; col++)
        	{
        		transposedMatrix.changeElement(col, row, matrix[row][col]);
        	}
        }
        return null;
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
    	/* CS314 Students. The following is standard equals
    	 * method code. We will learn about in the coming weeks.
    	 */
    	boolean result = false;
    	if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){

    		Matrix otherMatrix = (Matrix)rightHandSide;
    		if(otherMatrix.getNumRows() != matrix.length || otherMatrix.getNumColumns() != matrix[0].length){
    			result = false;

    		}
    		for (int row = 0; result && row < matrix.length; row++)
    		{
    			for (int col = 0; result && col < matrix[0].length; col++)
    			{
    				if (matrix[row][col] != otherMatrix.getVal(row, col))
    				{
    					result = false;
    					break;
    				}
    			}
    		}

    	}
    	return result;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {
    	
  
		int maxNum = matrix[0][0];
		int minNum = matrix[0][0];
    	for (int t = 0; t < matrix.length; t++) {
    		for (int z = 0; z < matrix[t].length; z++) {
    			if(maxNum < matrix[t][z]){
    				maxNum = matrix[t][z];
    			}else if(minNum > matrix[t][z]){
    				minNum = matrix[t][z];
    			}
    		}
    	}
    	String sMax=String.valueOf(maxNum);
    	String sMin=String.valueOf(minNum);

    	int sMaxLength = sMax.length() + 2;
    	int sMinLength = sMin.length() + 2;
    	int sLeght = 0;
    	if(sMaxLength > sMinLength) {
    			sLeght = sMaxLength;
    	}else if(sMaxLength <= sMinLength) {
    			sLeght = sMinLength;
    	}

    	String output = "";
    	for (int i=0; i<getNumRows(); i++) {
    		output += "|";

    		for (int j=0; j<getNumColumns(); j++) {
    			String v=String.valueOf(matrix[i][j]);
    			int u = sLeght - v.length();
    			for (int z=0; z<u;z++) {
    				output += ".";
    			}
    			output += matrix[i][j];
    		}
    		output += "|";
    		output +="\n";
    	}
    	
    	return output;
    }
    	

    
	





    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular(){
    	int zeros = 0;
        int startingRow;
        boolean result = true;
        
        if(matrix.length == 1 && matrix[0].length == 1) return true;        
        
        if(matrix[0].length % 2 > 0) startingRow = matrix[0].length/2;
        else startingRow = (matrix[0].length/2) - 1;

    	for (;startingRow < matrix.length; startingRow++){
    		for(int column = 0; column <= zeros; column++){
    			if(matrix[startingRow][column] != 0){
    				result = false;
    				break;
    			}
    		
    		}
    		if(!result)break;
        	zeros++;
        }
        return result;  	
        
    }

    // method to ensure mat is rectangular. It is public so that
    // tester classes can use it. 
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("girilen matrix uygun değil!");
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length )
        {   isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }

}
