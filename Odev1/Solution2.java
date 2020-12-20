/**
 * 
 * B515 Ödev:  VE / VEYA SORGULARI  
 *
 *
 * @author Hasan Hüseyin Niğdeli
 * @version 0.0.1 
 * @since  2020-10-06
 * 
 */
public class Solution2 {
	
	
	// ve: listelerin kesişimi
	public static int[] and(int[] list1 , int[] list2) {
		
		int list1Boyut = list1.length; 
		int list2Boyut = list2.length;		
		int[] kesListe = {0};		
		//liste1 tüm elemanları liste2 elemanlarıyla kıyaslamak için iç içe for döngüsü 		
		int i;
		for (i = 0; i < list1Boyut; i++) {
			
			int j;
			
			for (j = 0; j < list2Boyut; j++) {
				
				//birbirine eşit olanları ve 0 dan büyük olanların bulunması
				if ((list1[i]==list2[j]) & (list1[i]>0)) {
					
			      //daha önce oluşturduğumuz kesListe  içine elemanları koyma işlemi
					if (j == 0) {
						
						kesListe[0] = list1[i];
						
					} else {
						
						//geçici liste oluşturuyorum orjinalinden bir eleman büyük
						// orjinal listenin elemanlarıyla geçici listenin elemanlarını eşitliyorum
						// arta kalan bir boş yere yeni elemanı koyuyorum.
						int[] tempListe = new int[kesListe.length+1];
						int t;
						for (t=0; t < kesListe.length; t++) {
							
							tempListe[t] = kesListe[t];
							
						}
						
						tempListe[kesListe.length] = list1[i];
						kesListe = tempListe;
						
					}					
				}				
			}
		}
	 return kesListe;			
	}
	
	
	// veya: listelerin birleşimi
	public static int[] or(int[] list1 , int[] list2) {
		
				
		int m = list1.length; 
		int n = list2.length;
		int[] birListe = {};
		
		int i = 0, j = 0; 
		
		/*
		 İki listenin küçük boyutlu listesinin eleman sayısında döngü oluşturuyoruz
		 && ancak iki değerde true olursa true döner
		 */
        while (i < m && j < n) { 
        	//elemanları teker teker kıyaslıyoruz hangi listedeki eleman daha küçükse
        	// o listedekini ilk olarak nihai listemize ekliyoruz
            if (list1[i] < list2[j]) {
            	if (list1[i]>0) {
            		int[] tempListe = new int[birListe.length+1];
    				int t;
    				for (t=0; t < birListe.length; t++) {
    					
    					tempListe[t] = birListe[t];
    					
    				}
    				
    				tempListe[birListe.length] = list1[i++];
    				birListe = tempListe;         		
            	}else {
            		i++;
            	}
            	
            	
            }
            else if (list2[j] < list1[i]) {
            	if (list2[j] > 0) {
            		int[] tempListe = new int[birListe.length+1];
    				int t;
    				for (t=0; t < birListe.length; t++) {
    					
    					tempListe[t] = birListe[t];
    					
    				}
    				
    				tempListe[birListe.length] = list2[j++];
    				birListe = tempListe;
            		
            	} else {
            		j++;
            	}
            	
            } 
            //iki listedeki elemanda birbirine eşitse herhangi birini alıyoruz. fakat i ve j yi de arttıyoruz!
            else if((list1[i]==list2[j]) && (list1[i] > 0)){
            	int[] tempListe = new int[birListe.length+1];
				int t;
				for (t=0; t < birListe.length; t++) {
					
					tempListe[t] = birListe[t];
					
				}
				
				tempListe[birListe.length] = list2[j++];
				birListe = tempListe;
                i++; 
            }else {
            	i++;
            	j++;
            }
        } 
  
        //önceden küçük listeye göre yaptığımız için büyük listedeki artan elemanları ekliyoruz.
        while (i < m) {
        	if(list1[i]>0) {
        		int[] tempListe = new int[birListe.length+1];
    			int t;
    			for (t=0; t < birListe.length; t++) {
    				
    				tempListe[t] = birListe[t];
    				
    			}
    			tempListe[birListe.length] = list1[i++];
    			birListe = tempListe;       		
        	}else {
        		i++;
        	}
        	
        }
   
        while (j < n) {
        	if(list2[j]>0) {
        		int[] tempListe = new int[birListe.length+1];
    			int t;
    			for (t=0; t < birListe.length; t++) {
    				
    				tempListe[t] = birListe[t];
    				
    			}
    			
    			tempListe[birListe.length] = list2[j++];
    			birListe = tempListe;
        		
        	}else {
        		j++;
        	}
        	
        	
        }
            		
		return birListe;
	}
	
}
