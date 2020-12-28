package donemProjesi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		// Oyun giriş görselleştirmeleri
		Transition.transition("~",10);
		Transition.intro();
		Transition.transition("~",10);
		
		// Yeni oyun veya Puan durumu görselleştirilmesi seçeneği
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("                "+RenkTerminal.RED_BACKGROUND_BRIGHT+"Yeni Oyun için 1  " + RenkTerminal.BLUE_BACKGROUND+"Puan Durumu için 2");
		System.out.println(RenkTerminal.RESET);
		
		System.out.println("Seçiminiz?:");
		int secim = myObj1.nextInt();
		
		
		//sqlite bağlantısı için yeni Db sınıfı
		
		Db db = new Db();
		
		//yeni oyun veya puan durumu yönlendirme IF sorgusu
		if(secim == 1) {
			
			//Oyuncu isminin alınması
			Scanner myObj0 = new Scanner(System.in);  
		    System.out.println("Adınız:");
		    String oyuncu = myObj0.nextLine();
		    
		    
		    /* eğer girilen oyuncu zaten önceden girilmişse puan daha önceki puanını alıp 
		     * yeni oyuncu sınıfı yarat, değilse varsayılan ilk puan değeriyle sınıfı yara
		     */
		    int ilkPuan;
		    System.out.println(db.sorgu(oyuncu));
		    if(!db.sorgu(oyuncu)) {			    	
		    	db.insert(oyuncu, 0);
		    	ilkPuan = 0;
		    }else {
		    	ilkPuan = db.sorguPuan(oyuncu);
		    }		    		    
		    Oyuncu o = new Oyuncu(oyuncu,ilkPuan);
		    
		    /*
		     * Oyun soru sayısı seçtirilip oyun sınıfı yaratılır
		     */
		    Scanner myObj2 = new Scanner(System.in);  
		    System.out.println("Çözmek istediğiniz soru sayısı giriniz...");
		    int soruSayısı = myObj2.nextInt();
		    
			Oyun session = new Oyun(soruSayısı);

			
			KelimeSet hasan = new KelimeSet(session.soruSayısı);

			/*
			 * istenilen sayı kadar soru sorulması
			 */
			for(int i = 0; i< hasan.kelimeSayı;i++) {
				
				String a = hasan.kelimeSec()[i];
				System.out.println();
				System.out.println(a.split(",")[0]);
				System.out.println();
				System.out.println("İpucu: "+ ilkSon(a.split(",")[1]));
				
				
				Scanner myObj = new Scanner(System.in);  
			    System.out.println("Cevabınız:");

			    String cevap = myObj.nextLine();
				
				System.out.println(cevap);
				
				if(kelimeKontrol(cevap,a)) {
					o.arttirPuan(100);
					System.out.println();
					System.out.println(RenkTerminal.GREEN + kelimeKontrol(cevap,a) + RenkTerminal.RESET);
					System.out.println();
					System.out.println(o.getAd()+" Puan: "+o.getPuan());
				}else {
					o.eksiltPuan(5);
					System.out.println();
					System.out.println(RenkTerminal.RED + kelimeKontrol(cevap,a) + RenkTerminal.RESET);
					System.out.println();
					System.out.println(o.getAd()+" Puan: "+o.getPuan());
				}
				
				
				
				System.out.println("Cevap:"+ a.split(",")[1]);
				
			}
			
			db.update(o.getAd(), o.getPuan());
			Transition.transition("+",5);
			db.select();		
			Transition.transition("+",15);
			
		}else if(secim == 2) {
			
			db.select();
			
			Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
			System.out.println();
		    System.out.println("Oyunu yeniden başlatmak için 1 , sonlandırmak herhangibir  giris yapınız");

		    int secim1 = myObj2.nextInt();
		    if(secim1 == 1) {
		    	//baştan başlat
		    	main(args);
		    }else {
		    	//JVM sonlandır
		    	System.exit(0); 
		    }
						
		}else {			
			//JVM sonlandır
			main(args);			
		}
		
	}

	public static boolean kelimeKontrol(String kelime, String kontrol) {
		
		if(kelime.length()<2) {
			return false;
			
			
		}else {
			return kontrol.contains(kelime);
			
		}
		
		
	}
	
	public static String ilkSon(String kelime) {
		String kelimeSorted = kelime.trim();
		int uzunluk = kelimeSorted.length();
		char ilk = kelimeSorted.charAt(0);
		char son = kelimeSorted.charAt(uzunluk-1);
		String orta = "";
		for(int i=0; i<uzunluk-2;i++) {
			
			orta += "_ ";
			
		}
		
		return ilk+orta+son;
	}
}
