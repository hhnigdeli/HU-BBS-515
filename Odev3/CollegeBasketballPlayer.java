package bbs515.fall2020.odev3;

/**
 * College Basketbol oyuncusu sub class Basketbol oyuncusu class ı extend ediyor
 * 
 * 
 * @author Hasan Hüseyin Niğdeli
 * @version initial version
 */

public class CollegeBasketballPlayer extends BasketballPlayer{
	
	private int eligibilityRemaining ;
	private String role ;
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     */
	public CollegeBasketballPlayer(){
		
		super();
		this.eligibilityRemaining = 4;
		this.role = "bench";
				
	}
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     * 
     * @param  name , position, team
     * 
     */
	public CollegeBasketballPlayer(String name, String position, String team){
		
		super(name,position,team);
		this.eligibilityRemaining = 4;
		this.role = "bench";
						
	}
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     * 
     * @param  name , position, team, height,  weight,  agility, speed,  ballHandling,  eligibilityRemaining,  role
     * 
     */
	public CollegeBasketballPlayer(String name, String position, String team, int height, int weight, int agility,int speed, int ballHandling, int eligibilityRemaining, String role){
		
		super(name,position,team,height,weight,agility,speed,ballHandling);
		this.eligibilityRemaining = eligibilityRemaining;
		this.role = role;
				
	}
	/**
     * oyuncu serbestlik kalan zamanı döndürür
     */
	public int getEligibilityRemaining() {
		
		return eligibilityRemaining;
		
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
		
		return super.toString() + ", eligiblityRemaining="+eligibilityRemaining+", "+"role="+role;
	}
	/**
     * oyuncu alınabilirliğini döndürür
     */
	public boolean draftable() {
		
		if(getRole() == "starter" && getValue() > 4) {
			return true;
		}else if(getRole() == "bench" && getValue() >= 8) {
			return true;
		}else {
			return false;
		}
		
	}

}
