import java.util.Scanner;

//Beth Lester and Dimitrios Vlahos
public class GameManager {

	private final static String AGAIN = "Y";

	public static void main(String[] args) {
//		testGame();
//		testPlayer();
//		testHumanPlayer();
//		testRobotPlayer();
//		testRecord();
		play();
	}

//	public static void testGame() {
//		Game test1 = new Game();
//		int score = test1.getTurnScore();
//		System.out.println("Actual= " + score);
//		System.out.println("Expected= 0");
//	}
//
//	public static void testPlayer() {
//		 Player p1;
//		 Player p2 = new Player("Dimitrios");
//
//	}
//	
//	public static void testHumanPlayer() {
//		Scanner in = new Scanner(System.in);
//		Game test2 = new Game();
//		HumanPlayer me  = new HumanPlayer("Dimitrios", in);
//		System.out.println(me.getName());
//		me.keepRolling(test2);
//	}
//	
//	public static void testRobotPlayer() {
//		Game robotGame = new Game();
//		RobotPlayer roboCop1 = new RobotPlayer("Player 1", 0);
//		RobotPlayer roboCop2 = new RobotPlayer("Player 2", 5);
//		RobotPlayer roboCop3 = new RobotPlayer("Player 3", -2);
//		RobotPlayer roboCop4 = new RobotPlayer("Player 4", 3);
//		RobotPlayer roboCop5 = new RobotPlayer("Player 5", -4);
//		
//		System.out.println("Robot Turn Score= " + robotGame.getTurnScore());
//		
//		System.out.println(roboCop1.getName());
//		System.out.println(roboCop1.keepRolling(robotGame));
//		System.out.println(roboCop2.getName());
//		System.out.println(roboCop2.keepRolling(robotGame));
//		System.out.println(roboCop3.getName());
//		System.out.println(roboCop3.keepRolling(robotGame));
//		System.out.println(roboCop4.getName());
//		System.out.println(roboCop4.keepRolling(robotGame));
//		System.out.println(roboCop5.getName());
//		System.out.println(roboCop5.keepRolling(robotGame));
//	}
//	
//	public static void testRecord() {
//		Scanner in = new Scanner(System.in);
//		HumanPlayer p1 = new HumanPlayer("Beth", in);
//		RobotPlayer roboP1 = new RobotPlayer("Dimitrios", 4);
//		
//		Record humanRecord = new Record(p1);
//		Record roboRecord = new Record(roboP1);
//		
//		Player human = humanRecord.getPlayer();
//		Player robot = roboRecord.getPlayer();
//		if (human == p1){
//			System.out.println("Human Match");
//		}
//		else{
//			System.out.println("No Human Match");
//		}
//		if (robot == roboP1){
//			System.out.println("Robot Match");
//		}
//		else{
//			System.out.println("No Robot Match");
//		}
//		
//		humanRecord.updateScore(5);
//		roboRecord.updateScore(3);
//		System.out.println(humanRecord.getScore());
//		System.out.println(roboRecord.getScore());
//		
//		humanRecord.updateScore(3);
//		roboRecord.updateScore(5);
//		System.out.println(humanRecord.getScore());
//		System.out.println(roboRecord.getScore());
//	}
	
	public static void play() {
		System.out.println("LET'S PLAY!");

		// Setup input
		Scanner in = new Scanner(System.in);

		String playAgain = AGAIN;
		while (playAgain.equals(AGAIN)) {
			// establish game goal
			System.out.print("           Play to: ");
			int goal = Integer.parseInt(in.nextLine());

			// setup human player
			System.out.print("  Human Player Name: ");
			String name = in.nextLine();
			HumanPlayer human = new HumanPlayer(name, in);

			// setup robot player
			System.out.print("  Robot Player Cap: ");
			int cap = Integer.parseInt(in.nextLine());
			RobotPlayer robot = new RobotPlayer("Robot", cap);

			// setup player list
			Player[] list = { human, robot };

			// establish game type and play
			System.out.println("Reg or Mult Game: ");
			String type = in.nextLine().substring(0, 1).toUpperCase();
			if (type.equals("R")) {
				runGame(new Game(list, goal));
			} else if (type.equals("M")) {
				System.out.print("         NUM DICE: ");
				int numDice = Integer.parseInt(in.nextLine());
				runGame(new MultGame(list, goal, numDice));
			}

			System.out.print("\n PLAY AGAIN? ");
			playAgain = in.nextLine().substring(0, 1).toUpperCase();

		}
	}

	public static void runGame(Game game) {
		while (!game.isOver()) {
			System.out.println("\n\n" + game.status());
			if (game.currPlayer().keepRolling(game)) {
				String result = game.roll();
				System.out.println("Rolled " + result);
			} else {
				game.endTurn(); // player decided to end turn
			}
		}

		System.out.println("Game Over!");
		String finalScore = game.status();
		System.out.println(finalScore.substring(0, finalScore.lastIndexOf("\n")));
	}
}
