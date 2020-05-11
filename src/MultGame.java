import java.util.ArrayList;

//Beth Lester and Dimitrios Vlahos
public class MultGame extends Game {
	private int numDice;
	
	public MultGame(Player[] players, int setGoal, int diceTossed){
		super(players, setGoal);
		numDice = diceTossed;	
	}
	
	@Override
	public String roll(){
		ArrayList<String> numsRolled = new ArrayList<String>();
		for (int i = 0; i < numDice; i++){
			String result = super.roll();
			if (result.contains("0")){
				return ("1");
				//if a 1 is rolled, then turnScore is set to 0, so the result from roll would be 0; in this case we want to return 1 immediately and not continue
			}
			else{
				numsRolled.add(result);
				//this add the number rolled to the list of numbers rolled thus far
			}
		}
		String noOnes = String.join(" ", numsRolled); //outputs all the numbers rolled separated by spaces
		return(noOnes);
	}
}
