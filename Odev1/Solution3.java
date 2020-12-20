/**
 * 
 * B515 Ödev:  EN UZUN DİZİ   
 *
 *
 * @author Hasan Hüseyin Niğdeli
 * @version 0.0.1 
 * @since  2020-10-06
 *
 */
public class Solution3 {
	// verilen sayının matristeki en uzun ardışık tekrar sayısını hesaplar
	public static int checkMatrix(int [][] matrix , int val) {
		
		
		int MaxYatay = 0;
		int sayacYatay = 0;
	
		
		for(int i=0;i<matrix.length+1;i++) {
			if(MaxYatay < sayacYatay) {
				MaxYatay = sayacYatay+1;
				sayacYatay = 0;
			}else if(i==matrix.length+1) {
				MaxYatay = sayacYatay+1;
				
			}
			sayacYatay = 0;
			
			if(i<matrix.length) {
				for (int j=1;j<matrix[i].length;j++) {

					if (matrix[i][j] == matrix[i][j-1]) {
						if(matrix[i][j] == val) {
							sayacYatay++;
							System.out.println("döngü "+ i +" sayac "+sayacYatay);
							
							
						}										
					}
				}	
			}						
		}
		int MaxDikey= 0;
		int sayacDikey = 0;
		
		for(int j=0;j<matrix.length+1;j++) {
			if(MaxDikey < sayacDikey) {
				MaxDikey = sayacDikey+1;
				sayacDikey = 0;
			}else if(j==matrix.length+1) {
				MaxDikey = sayacDikey+1;
				
			}
			sayacDikey = 0;
			
			if(j<matrix.length) {
				for (int i=1;i<matrix[j].length;i++) {

					if (matrix[i][j] == matrix[i-1][j]) {
						if(matrix[i][j] == val) {
							sayacDikey++;
							System.out.println("döngü "+ j +" sayac "+sayacDikey);							
						}										
					}
				}	
			}						
		}
	
		
				
		return MaxDikey;
	
	}
	}

