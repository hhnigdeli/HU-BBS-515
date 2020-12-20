/**
 * 
 * B515 Ödev: İKİ YÖNLÜ ASAL SAYI BULMA 
 *
 *
 * @author Hasan Hüseyin Niğdeli
 * @version 0.0.1 
 * @since  2020-10-06
 * 
 */
 
public class Solution1 {
	
	
		// Verilen rakamın asal sayı olup olmadığını test eder
		public static boolean isPrime(int number) {
			// Sayının asal sayı olması için 1 den farklı, büyük ve pozitif sayı olması gerekli.
			if(number > 1 ) {
				//Verilen sayıyı kendisinden 2 ye kadar olan sayılara bölümünden kalana bakılır
				//eğer herhangi bir kalan sıfır ise asal sayı değildir.
				for (int i = 2; i < number; i++) {
					if(number%i == 0) {
						return false;					
					}
				}
				// For döngüsünden çıktıysa tam bölen yoktur,asal sayıdır.
				return true;							
			}else {
				// 1 veya 1 den küçük bir sayıysa asal sayı değildir.
				return false;
			}						
		}
		
		
		// Verilen sayının rakamlarının tersine çevirir
		public static int reverse(int number) {
			int ters = 0;
			// verilen tam sayının 10 a bölümünden kalan ilk basağı verecektir.
			// verilen tam sayıyı  10 a bölmek ise ilk basamağı elemek demektir.
			while(number != 0)
		    { 
			  // bir önceki değeri 10 ile çarpıp birler basamağını elde etmek için kalan ile 
			  // topluyoruz bu şekilde verilen integerin tersini elde edebiliriz.
		      ters = ters * 10;
		      ters = ters + number%10;
		      number = number/10;
		    }
			return ters;
		}
		
		
		// Verilen aralıktaki ilk ve son değer dahil olarak aralıktaki iki yönlü asal sayıları listeler
		public static void printEprimes(int start , int end) {
			for( int t = start ; t < end+1; t++) {		
				if(isPrime(t) & isPrime(reverse(t))) {
					System.out.println(t);	
				}				
			}		
		}
}
