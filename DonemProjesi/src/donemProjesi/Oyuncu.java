package donemProjesi;

public class Oyuncu {
	
	private String ad;
	private int puan;
	
	public Oyuncu() {
			
	}
	
	public Oyuncu(String ad) {
		this.ad = ad;
		puan = 0;
	}
	
	public Oyuncu(String ad, int puan) {
		this.ad = ad;
		this.puan = puan;
		

	}
	
	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void arttirPuan(int arttır) {
		this.puan += arttır;
	}
	
	public void eksiltPuan(int eksilt) {
		this.puan -= eksilt;
	}

}
