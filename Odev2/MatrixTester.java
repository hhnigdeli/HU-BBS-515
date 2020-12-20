import java.util.Random;



/**
 * A class to run tests on the Matrix class
 * 
 * @author Hasan Hüseyin Niğdeli
 */
public class MatrixTester {
	
;

    /**
     * main method that runs simple test on the Matrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
    	

    	int[][] data1 = { {1, 2, 3},
    			{2, 3, 4}};
    	int[][] data2 = { {2, 1, 1},
    			{2, 3, 1}};
    	int[][] e1;

    	//test 1, oluşturucu testi
    	System.out.println("Test 1");   	
    	Matrix mat1 = new Matrix();
    	e1 = new int[][] {{0}};
    	printTestResult( get2DArray(mat1), e1, 1, "constructor");
    	System.out.println("");
    	
        //test2 matrix oluşturucu method testi
    	System.out.println("Test 2");
    	data1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    	mat1 = new Matrix(data1);
    	printTestResult( get2DArray(mat1), data1, 1, "Matrix(int[][] mat)");
    	System.out.println("");
    	
    	//test3 matrix oluşturucu method testi
    	System.out.println("Test 3"); 	
    	data1 = new int[][]{{16, 2324, 354, 44856}, {57, 643, 75, 85}, {97, 10, 11, 90}};
    	mat1 = new Matrix(data1);
    	printTestResult( get2DArray(mat1), data1, 2, "MathMatrix(int[][] mat)");
    	System.out.println("");
    	
    	//test4 istenen satır sutün sayısı ile matrix oluşturucu testi 
    	System.out.println("Test 4");
    	data1 = new int[][]{{12, 12, 12, 12}, {12, 12, 12, 12}, {12, 12, 12, 12}};
    	mat1 = new Matrix(3, 4, 12);
    	printTestResult( get2DArray(mat1), data1, 1, "Matrix(int numRows, int numCols, int initialVal)");
    	System.out.println("");
    	
    	//test5 istenen satır sutün sayısı ile matrix oluşturucu testi
    	System.out.println("Test 5");
    	data1 = new int[][]{{12, 12, 12, 12, 12}};
    	mat1 = new Matrix(1, 5, 12);
    	printTestResult( get2DArray(mat1), data1, 2, "Matrix(int numRows, int numCols, int initialVal)");
    	System.out.println("");

    	//test6 belirtilen matrix elemanın yeni değerle değiştirilmesi testi
    	System.out.println("Test 6");
    	data1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    	mat1 = new Matrix(data1);
    	mat1.changeElement(2, 3, 33);
    	e1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 33}};
    	printTestResult( get2DArray(mat1), e1, 1, "changeElement(int row, int col, int newValue)");
    	System.out.println("");
    	
    	//test7 belirtilen matrix elemanın yeni değerle değiştirilmesi testi
    	System.out.println("Test 7");
    	mat1.changeElement(0, 1, 101);
    	e1 = new int[][]{{1, 101, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 33}};
    	printTestResult( get2DArray(mat1), e1, 2, "changeElement(int row, int col, int newValue)");
    	System.out.println("");

    	//test8 satır sayısı bulma testi
    	System.out.println("Test 8");
    	mat1 = new Matrix(13, 1, 2);
    	if (mat1.getNumRows() == 13)
    		System.out.println( "Passed  numRows().");
    	else
    		System.out.println( "Failed  numRows().");
    	System.out.println("");
    	
       	//test9 satır sayısı bulma testi
    	System.out.println("Test 9");
    	mat1 = new Matrix(130012, 15, 2);
    	if (mat1.getNumRows() == 130012)
    		System.out.println( "Passed  numRows().");
    	else
    		System.out.println( "Failed  numRows().");
    	System.out.println("");
    	
    	
    	//test10 sütun sayısı bulma testi
    	System.out.println("Test 10");
    	mat1 = new Matrix(13, 1, 2);
    	if (mat1.getNumColumns() == 1)
    		System.out.println( "Passed  numCols().");
    	else
    		System.out.println( "Failed  numCols().");
    	System.out.println("");

    	//test11 sütun sayısı bulma testi
    	System.out.println("Test 11");
    	mat1 = new Matrix(130012, 15, 2);
    	if (mat1.getNumColumns() == 15)
    		System.out.println( "Passed  numCols().");
    	else
    		System.out.println( "Failed  numCols().");
    	System.out.println("");

    	//test12 istenen index  değeri getirme çapraz testi
    	System.out.println("Test 12");
    	data1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    	mat1 = new Matrix(data1);
    	if (mat1.getVal(2, 2) == 11)
    		System.out.println( "Passed  getVal(int row, int col).");
    	else
    		System.out.println( "Failed  getVal(int row, int col).");
    	if (mat1.getVal(0, 0) == 1)
    		System.out.println( "Passed  getVal(int row, int col).");
    	else
    		System.out.println( "Failed  getVal(int row, int col).");
    	System.out.println("");

    	//test13 matrix toplama testi
    	System.out.println("Test 13");
    	data1 = new int[][]{{1, 1, 1, 1}, {5, 4, 3, 2}, {2, 4, 6, 8}, {5, 5, 5, 5}, {10, 20, 30, 40}};
    	data2 = new int[][]{{99, 99, 99, 99}, {95, 96, 97, 98}, {98, 96, 94, 92}, {95, 95, 95, 95}, {90, 80, 70, 60}};
    	e1 = new int[][] {{100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}};
    	mat1 = new Matrix(data1);
    	Matrix mat2 = new Matrix(data2);
    	printTestResult( get2DArray(mat1.add(mat2)), e1, 1, "add(Matrix rightHandSide)");
    	printTestResult( get2DArray(mat2.add(mat1)), e1, 2, "add(Matrix rightHandSide)");
    	data1 = new int[][]{{5, 2}, {2, 7}, {7, 7}, {1, 1}, {9, 3}};
    	data2 = new int[][]{{1, 3}, {4, 6}, {1, 6}, {8, 5}, {3, 3}};
    	e1 = new int[][]{{6, 5}, {6, 13}, {8, 13}, {9, 6}, {12, 6}};
    	mat1 = new Matrix(data1);
    	mat2 = new Matrix(data2);
    	printTestResult( get2DArray(mat1.add(mat2)), e1, 3, "add(Matrix rightHandSide)");
    	System.out.println("");
    	
    	//test14 matrix çıkarma testi
    	System.out.println("Test 14");
    	e1 = new int[][]{{4, -1}, {-2, 1}, {6, 1}, {-7, -4}, {6, 0}};
    	printTestResult( get2DArray(mat1.subtract(mat2)), e1, 1, "subtract(MathMatrix rightHandSide)");
    	System.out.println("");
    	
    	//test15 matrix çıkarma testi
    	System.out.println("Test 14");
    	e1 = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    	printTestResult( get2DArray(mat1.subtract(mat1)), e1, 2, "subtract(MathMatrix rightHandSide)");
    	System.out.println("");

    	//test16 matrix çarpma testi
    	System.out.println("Test 16");
    	data1 = new int[][] {{1, 2}, {2, 2}, {1, 1}};
    	data2 = new int[][] {{3}, {1}};
    	mat1 = new Matrix(data1);
    	mat2 = new Matrix(data2);
    	e1 = new int[][]{{5}, {8}, {4}};
    	printTestResult( get2DArray(mat1.multiply(mat2)), e1, 1, "multiply(MathMatrix rightHandSide)");
    	System.out.println("");

    	//test17 matrix çarpma testi
    	System.out.println("Test 17");
    	data1 = new int[][] {{1}, {2}, {3}, {4}, {5}};
    	data2 = new int[][] {{5, 5, 5, 5, 5}};
    	mat1 = new Matrix(data1);
    	mat2 = new Matrix(data2);
    	e1 = new int[][]{{5, 5, 5, 5, 5}, {10, 10, 10, 10, 10}, {15, 15, 15, 15, 15}, {20, 20, 20, 20, 20}, {25, 25, 25, 25, 25}};
    	printTestResult( get2DArray(mat1.multiply(mat2)), e1, 2, "multiply(MathMatrix rightHandSide)");
    	System.out.println("");

    	//test18 matrix ölçekleme testi
    	System.out.println("Test 18");
    	e1 = new int[][]{{10}, {10}, {10}, {10}, {10}};
    	e1 = new int[][]{{10, 10, 10, 10, 10}};
    	mat2.getScaledMatrix(2);
    	printTestResult( get2DArray(mat2), e1, 1, "getScaledMatrix(int factor)");
    	mat2.getScaledMatrix(5);
    	e1 = new int[][]{{50, 50, 50, 50, 50}};
    	printTestResult( get2DArray(mat2), e1, 2, "getScaledMatrix(int factor)");    
    	System.out.println("");
    	
    	//test19 matrix transposetesti
    	System.out.println("Test 19");
    	data1 = new int[][]{{3, 5, 6, 7, 8}, {2, 3, 54, 9, 5}};
    	mat1 = new Matrix(data1);
    	e1 = new int[][]{{3, 2}, {5, 3}, {6, 54}, {7, 9}, {8, 5}};
    	mat1.getTranspose();
    	if (!equals(get2DArray(mat1),data1))    //makes sure mat1 IS altered by the transpose method.
    		printTestResult( get2DArray(mat1), e1, 1, "getTranspose()");
    	else
    		System.out.println("Failed  getTranspose().");

    	data1 = new int[][]{{3, 5, 6, 7, 8}};
    	mat1 = new Matrix(data1);
    	e1 = new int[][]{{3}, {5}, {6}, {7}, {8}};
    	mat1.getTranspose();
    	if (!equals(get2DArray(mat1),data1))    //makes sure mat1 IS altered by the transpose method.
    		printTestResult( get2DArray(mat1), e1, 2, "getTranspose()");
    	else
    		System.out.println("Failed  getTranspose().");
    	System.out.println("");
    	
    	//test20 matrix eşitlik kontrol methodu testi
    	System.out.println("Test 20");
    	data1 = new int[][]{{3, 5, 6, 7, 8}};
    	data2 = new int[][]{{3, 5, 6, 7, 8}};
    	mat1 = new Matrix(data1);
    	mat2 = new Matrix(data2);
    	if (mat1.equals(mat2))
    		System.out.println("Passed  equals().");
    	else
    		System.out.println("Failed  equals().");
    	System.out.println("");
    	
    	
    	//test21 matrix eşitlik kontrol methodu testi
    	System.out.println("Test 21");
    	data1 = new int[][]{{3, 5, 6, 5, 8}};
    	data2 = new int[][]{{3, 5, 6, 5}};
    	mat1 = new Matrix(data1);
    	mat2 = new Matrix(data2);
    	if (!mat1.equals(mat2))
    		System.out.println("Passed  equals().");
    	else
    		System.out.println("Failed  equals().");
    	System.out.println("");
    	
    	
    	
    	//test22 to string testi
    	System.out.println("Test 22 - toString");
    	
    	data1 = new int[][] {    { 1,  11,  111,      1111},
    		                     {-1, -11, -111, -11111111},
    		                     { 3,   6,    8,        10}};
    	mat1 = new Matrix(data1);
        String expected = "|..........1.........11........111.......1111|\n|.........-1........-11.......-111..-11111111|\n|..........3..........6..........8.........10|";
    	System.out.println("Expected,");
    	System.out.println(expected);
    	System.out.println("Matrix to String,");
        System.out.println(mat1.toString());
    	System.out.println("");
    		
        //stopWatch ile zaman ölçümü
    				
    	Stopwatch watch = new Stopwatch();
        	
    	watch.start();
    	for(int i=0;i<10;i++) {
    		int[][] matrix1 = randomMat(1000, 10);
        	int[][] matrix2 = randomMat(1000, 15);
        	mat1 = new Matrix(matrix1);
            mat2 = new Matrix(matrix2);
            Matrix Multresult = mat1.multiply(mat2);
    	}        	    		
    	watch.stop();
    		
    	System.out.println("Çarpma işlemi  "+ watch.toString());
    	System.out.println("");
    		
    	watch.start();
    	for(int i=0;i<10;i++) {
    		int[][] matrix1 = randomMat(1000, 10);
        	int[][] matrix2 = randomMat(1000, 15);
        	mat1 = new Matrix(matrix1);
            mat2 = new Matrix(matrix2);
            Matrix Addresult = mat1.add(mat2);
    	}        	    		
    	watch.stop();
    		
    	System.out.println("Toplama işlemi  "+ watch.toString());
    	System.out.println("");
    		
    		
    		
    		
    	//diğer testler
    	System.out.println("Diğer Testler....");
    	data1 = new int[][] {    {1, 2, 3, 0},
    		{0, 3, 2, 3},
    		{0, -1, 4, -1},
    		{0, 0, 0, 12}};
    		mat1 = new Matrix(data1);
    		if( !mat1.isUpperTriangular())
    			System.out.println("Passed  isUpperTriangular().");
    		else
    			System.out.println("Failed  isUpperTriangular().");

    		data1 = new int[][] {    {0, 0, 0, 0},
    			{0, 0, 0, 0},
    			{0, -1, 0, 0},
    			{0, 0, 0, 0}};
    			mat1 = new Matrix(data1);
    			if( !mat1.isUpperTriangular())
    				System.out.println("Passed  isUpperTriangular().");
    			else
    				System.out.println("Failed  isUpperTriangular().");

    			data1 = new int[][] {    {5, 6, -10},
    				{0, 3, 6},
    				{0, 0, 34}};
    				mat1 = new Matrix(data1);
    				if( mat1.isUpperTriangular())
    					System.out.println("Passed  isUpperTriangular().");
    				else
    					System.out.println("Failed  isUpperTriangular().");

    				data1 = new int[][] {    {5, 6}, 
    					{-1, 90234}};
    					mat1 = new Matrix(data1);
    					if( !mat1.isUpperTriangular())
    						System.out.println("Passed  isUpperTriangular().");
    					else
    						System.out.println("Failed  isUpperTriangular().");


    					data1 = new int[][] {    {5}};
    					mat1 = new Matrix(data1);
    					if( mat1.isUpperTriangular())
    						System.out.println("Passed  isUpperTriangular().");
    					else
    						System.out.println("Failed  isUpperTriangular().");




    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(Matrix mat) {
    	if (mat == null) {
    		throw new IllegalArgumentException("mat may not be null");
    	} 
    	int result = 0;
    	final int ROWS =  mat.getNumRows();
    	final int COLS = mat.getNumColumns();
    	for (int r = 0; r < ROWS; r++) {
    		for (int c = 0; c < COLS; c++) {
    			result += mat.getVal(r, c); // likely to overflow, but can still do simple check
    		}
    	}
    	return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static Matrix createMat(Random randNumGen, int rows,
    		int cols, final int LIMIT) {

    	if (randNumGen == null) {
    		throw new IllegalArgumentException("randomNumGen variable may no be null");
    	} else if(rows <= 0 || cols <= 0) {
    		throw new IllegalArgumentException("rows and columns must be greater than 0. " +
    				"rows: " + rows + ", cols: " + cols);
    	}

    	int[][] temp = new int[rows][cols];
    	final int SUB = LIMIT / 4;
    	for(int r = 0; r < rows; r++) {
    		for(int c = 0; c < cols; c++) {
    			temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
    		}
    	}

    	return new Matrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
    	System.out.print( testingWhat +". The test ");
    	String result = equals(data1, data2) ? "passed" : "failed";
    	System.out.println(result);
    }

    private static int[][]  randomMat(int n, int max){
    	Random r=new Random();
    	int[][] a=new int[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			a[i][j]=r.nextInt(max);
    		}	  
    	}
    	return a;

    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with 
    // the same elements
    private static int[][] get2DArray(Matrix m) {
    	//check precondition
    	if  ((m == null) || (m.getNumRows() == 0) 
    			|| (m.getNumColumns() == 0)) {
    		throw new IllegalArgumentException("Violation of precondition: get2DArray");
    	}

    	int[][] result = new int[m.getNumRows()][m.getNumColumns()];
    	for(int r = 0; r < result.length; r++) {
    		for(int c = 0; c < result[0].length; c++) {
    			result[r][c] = m.getVal(r,c);
    		}
    	}
    	return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
    	//check precondition
    	if((data1 == null) || (data1.length == 0) 
    			|| (data1[0].length == 0) || !rectangularMatrix(data1)
    			||  (data2 == null) || (data2.length == 0)
    			|| (data2[0].length == 0) || !rectangularMatrix(data2)) {
    		throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");
    	}
    	boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
    	int row = 0;
    	while (result && row < data1.length) {
    		int col = 0;
    		while (result && col < data1[0].length) {
    			result = (data1[row][col] == data2[row][col]);
    			col++;
    		}
    		row++;
    	}

    	return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
    	if (mat == null || mat.length == 0 || mat[0].length == 0) {
    		throw new IllegalArgumentException("Violation of precondition: "
    				+ " Parameter mat may not be null" 
    				+ " and must be at least 1 by 1");
    	}
    	return Matrix.rectangularMatrix(mat);
    }


}

