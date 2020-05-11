//Beth Lester and Dimitrios Vlahos
public class Record {
	private Player player;
	private int score;
	
	public Record(Player thisPlayer){
		player = thisPlayer;
		score = 0;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void updateScore(int addToScore){
		score = score + addToScore;
	}
	
	public int getScore(){
		return score;
	}
}
