import java.util.Scanner;

//Beth Lester and Dimitrios Vlahos
public class HumanPlayer extends Player {
	Scanner input = new Scanner(System.in);
	
	public HumanPlayer(String playerName, Scanner in) {
		super(playerName);
		input = in;
	}
	

	public boolean keepRolling(Game diceGame){
		System.out.println("Do you want to roll?");
		String answer = input.next();
		if (answer.length() > 0){
			return false;
		}
		return true;
	}

	
}
