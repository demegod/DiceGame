//Beth Lester and Dimitrios Vlahos
public abstract class Player {
	private String name;
	
	public Player(String playerName){
		name = playerName; 
	}
	
	public String getName(){
		return name;
	}
	
	abstract boolean keepRolling(Game diceGame);
}