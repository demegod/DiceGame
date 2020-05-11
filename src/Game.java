import java.util.Random;

//Beth Lester and Dimitrios Vlahos
public class Game {
	private int turnScore;
	private Random die = new Random();
	private Record[] records;
	private int current;
	private int goalScore;
	
	public Game(Player[] players, int setGoal){
		records = new Record[players.length];
		for (int i = 0; i < records.length; i++){
			records[i] = new Record(players[i]);
		}
		current = 0;
		goalScore = setGoal;
	}
	
	public boolean isOver(){
		for (int i = 0; i < records.length; i++){
			int currentRecord = records[i].getScore();
			if (currentRecord >= goalScore){
				return true;
			}
		}
		return false;
	}
	
	public Player currPlayer(){
		Player player = records[current].getPlayer();
		return player;
	}
	
	public void endTurn(){
		records[current].updateScore(turnScore);
		turnScore = 0;
		if (current <= records.length-2){
			current++;
		}
		else {
			current = 0;
		}
	}
	
	private int toss(int numSides) {
		return die.nextInt(numSides) + 1;
	}
	
	public String roll(){
		int thisRoll = toss(6);
		if (thisRoll == 1){
			turnScore = 0;
			endTurn();
			return("" + 0);
		}
		else{
			turnScore = turnScore + thisRoll;
			if (isOver()){
				endTurn();
			}
			return("" + turnScore);
		}
	}
	
	
	public int getTurnScore() {
		return turnScore;
	}


	public String status() {

		String playerLine = "";
		String scoreLine = "";
		
		for (Record r : records) {
			String name = r.getPlayer().getName();
			playerLine += " " + name;
			String fmt = "%" + name.length() + "d";
			scoreLine += " " + String.format(fmt, r.getScore());
		}
		
		String currName = records[current].getPlayer().getName();
		String turnLine = "It is " + currName + "'s turn and so far " + turnScore + " has been rolled.";
		
		return playerLine + "\n" + scoreLine + "\n" + turnLine;
	}
}
