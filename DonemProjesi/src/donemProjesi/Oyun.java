package donemProjesi;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Oyun {
	
	public String oyunZamanı;
	public int soruSayısı;
		
public Oyun() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		this.oyunZamanı = dateOnly.format(cal.getTime());
		soruSayısı = 5;
		
		
	}
	
	public Oyun(int soruSayısı) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		this.oyunZamanı = dateOnly.format(cal.getTime());
		this.soruSayısı = soruSayısı;
		
		
	}
	
	public void zamanYazdir() {
		System.out.println(oyunZamanı);
	}
	
	public String zamanDondur() {
		return oyunZamanı;
	}
}
