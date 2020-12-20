package bbs515.fall2020.odev3;

/**
 * Pro Basketbol oyuncusu sub class Basketbol oyuncusu class ı extend ediyor
 * 
 * 
 * @author Hasan Hüseyin Niğdeli
 * @version initial version
 */

public class ProBasketballPlayer extends BasketballPlayer{
	
	private int yearsInLeague ;
	private String role ;
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     */
	public ProBasketballPlayer(){
		
		super();
		this.yearsInLeague = 0;
		this.role = "bench";
				
	}
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     * 
     * @param  name , position, team
     * 
     */
	public ProBasketballPlayer(String name, String position, String team){
		
		super(name,position,team);
		this.yearsInLeague = 0;
		this.role = "bench";
						
	}
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     * 
     * @param  name , position, team, height,  weight,  agility, speed,  ballHandling,  yearsInLeague,  role
     * 
     */
	public ProBasketballPlayer(String name, String position, String team, int height, int weight, int agility,int speed, int ballHandling, int yearsInLeague, String role){
		
		super(name,position,team,height,weight,agility,speed,ballHandling);
		this.yearsInLeague = yearsInLeague;
		this.role = role;
				
	}
	/**
     * ligte geçen süreyi döndürür
     */
	public int getYearsInLeague() {
		
		return yearsInLeague;
		
	}
	/**
     * oyuncu rolü döndürür
     */
	public String getRole() {
		
		return role;
	}
	/**
     * Java toSting üzerine yazar basketbol oyuncu sınıfındakini genişletir.
     */
	public String toString() {
		
		return super.toString() + ", yearsInLeague="+yearsInLeague+", "+"role="+role;
	}
	/**
     * oyuncu için yeni sözleşme nedelini döndürür
     */
	public int newContractValue() {
		
		if(getRole() == "bench") {
			if(yearsInLeague < 7) {
				return 500000;
			}else if( getValue() > 8  && yearsInLeague >= 10 ) {
				return 7500000;
			}else if( getValue() > 7  && yearsInLeague >= 8) {
				return 5000000;
			}else if( getValue() > 5  && yearsInLeague >= 10) {
				return 4500000;
			}else if( getValue()<=5 && yearsInLeague >= 7) {
				return 2000000;
			}else {
				return 500000;
			}
							
		}else if(getRole() == "starter") {
			if( getValue() > 8 &&yearsInLeague >= 10 ) {
				return 12000000;
			}else if( getValue() > 7 &&yearsInLeague >= 8  ) {
				return 10000000;
			}else if( getValue() > 7 &&yearsInLeague >= 5 ) {
				return 8000000;
			}else if( getValue() > 5  && yearsInLeague >= 10) {
				return 6000000;
			}else if( getValue()<=5 && yearsInLeague < 5) {
				return 2000000;
			}else if( yearsInLeague < 5 && getValue()<5) {
				return 1000000;
			}else {
				return 0;
			}
				
			
		}else {
			return 0;
		}
		
		
		
	}

}
