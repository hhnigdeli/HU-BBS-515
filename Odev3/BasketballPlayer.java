package bbs515.fall2020.odev3;

/**
 * 
 * 
 * 
 * @author Hasan Hüseyin Niğdeli
 * @version initial version
 */

public class BasketballPlayer {
	protected String name;
	protected String position;
	protected String team;
	protected int height;
	protected int weight;
	protected int agility;
	protected int speed;
	protected int ballHandling;
	/**
     * yeni basketbol oyuncusu yaratıcı methodu
     */
	public BasketballPlayer() {
		
	}
	 /**
     * yeni basketbol oyuncusu yaratıcı methodu
     * 
     * @param  name , position, team
     * 
     */
	public BasketballPlayer(String name, String position, String team) {
		
		this.name = name;
		this.position = position;
		this.team = team;
		this.height = 0;
		this.weight = 0;
		this.agility = 0;
		this.speed = 0;
		this.ballHandling = 0;
		
	}
	 /**
     * yeni basketbol oyuncusu yaratıcı methodu
     * 
     * @param  name , position, team, height, weight, agility, speed, ballhandling
     * 
     */
	public BasketballPlayer(String name, String position, String team, int height, int weight, int agility,int speed, int ballHandling) {
		
		this.name = name;
		this.position = position;
		this.team = team;
		this.height = height;
		this.weight = weight ;
		this.agility = agility;
		this.speed = speed;
		this.ballHandling = ballHandling;
		
	}
	 /**
     * oyuncu adını döndürür
     */
	public String getName() {
		return name;
	}
	 /**
     * pozisyonu döndürür
     */
	public String getPosition() {
		return position;
	}
	 /**
     * takımı döndürür
     */
	public String getTeam() {
		return team;
	}
	 /**
     * oyuncu ağırlığını döndürür
     */
	public int  getWeight() {
		return weight;
	}
	 /**
     * oyuncu boyunu döndürür
     */
	public int  getHeight() {
		return height;
	}
	 /**
     * oyuncu çevikliği döndürür
     */
	public int  getAgility() {
		return agility;
	}
	 /**
     * oyuncu hızını döndürür
     */
	public int  getSpeed() {
		return speed;
	}
	 /**
     * oyuncu top sürüş yeteneğini döndürür
     */
	public int  getBallHandling() {
		return ballHandling;
	}
	 /**
     * java toString üzerine yazar
     * 
     * örnek: BasketballPlayer name=Tim Duncan, position=Center, team=Spurs, value=8
     * 
     */
	public String toString() {
		return  this.getClass().getSimpleName()+" name="+name+","+" position="+position+", team="+team+", value="+getValue();
	}
	/**
     * oyuncu değerini döndürür
     */
	public int getValue() {
		if(position == "Center") {
			if(height < 76) {
				return 0;
			}else if( height>=82  && ballHandling > 5 && weight< 250 && weight > 220) {
				return 10;
			}else if( height>=80 &&  ballHandling > 5 && weight< 260 && weight > 210) {
				return 8;
			}else if( height>=80  && ballHandling > 4 && ballHandling <= 5 ) {
				return 6;
			}else if(height>=78 && agility > 7 ) {
				return 5;
			}else if (height>=78  && agility <= 7 ){
				return 4;
			}else if(height>=76  && agility < 5 ){
				return 2;
			}else {
				return 0;
			}
							
		}else if(position == "Forward") {
			if(height < 74) {
				return 0;
			}else if( height >= 80 && (agility > 8 || speed > 7)) {
				return 10;
			}else if( height >= 78  && agility > 6 && speed > 5 ) {
				return 8;
			}else if( height >= 77  && agility > 5) {
				return 6;
			}else if( height >= 76  && speed > 4) {
				return 5;
			}else if( height >= 75  &&(agility > 3 || speed > 3)  ) {
				return 3;
			}else if( height >= 74 && (agility <= 3 || speed <= 3)){
				return 1;
			}else {
				return 0;
			}
				
		
		}else if(position == "Guard"){
			if( ballHandling<=4 && agility <=4) {
				return 0;
			}else if( height >= 78  && ballHandling>7 && (agility>7 || speed>7 )) {
				return 10;
			}else if( height >= 76  && ballHandling>7 && (agility>6 || speed>6 )) {
				return 8;
			}else if( height >= 74  && agility > 5 && speed > 6 && ballHandling>5 ) {
				return 6;
			}else if( ballHandling>6 && agility >6 && speed>5 ) {
				return 4;
			}else if( ballHandling>4  && agility>4 ) {
				return 2;
			}else {
				return 0;
			}
			
		}else {
			return 0;
		}	
		
	}

}
