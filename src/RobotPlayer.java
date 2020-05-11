//Beth Lester and Dimitrios Vlahos
public class RobotPlayer extends Player {
	private int cap;
	
	public RobotPlayer(String playerName,int maxScore){
		super(playerName);
		cap = maxScore;
	}
	
	
	public boolean keepRolling(Game diceGame){
		int turnScore = diceGame.getTurnScore();
		if (turnScore < cap){
			return true;
		}
		return false;
	}
}
