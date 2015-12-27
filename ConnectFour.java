//Final Game File to be run to play the game.
import java.io.*;
import java.util.*;

public class ConnectFour
{
	public static int getKey(Player p){
		String name = (p.getName()).toUpperCase();
		if(name == "BILLY" ||  name == "BILLSTER" || name == "BILBO")
			return 0;
		if(name == "AJ")
			return 1;
		if(name == "IAN" || name == "I-DOG")
			return 2;
		if(name == "BRICE")
			return 3;
	}

	public static void main(String[] args){
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print((char)27 + "[32mEnter Player 1 Name" + (char)27+"[0m"+ "  >>  ");
		String player1Name = sc.nextLine();
		System.out.print((char)27 + "[32mEnter Player 2 Name" + (char)27+"[0m"+ "  >>  ");
		String player2Name = sc.nextLine();
		Player player1 = new Player(player1Name,0)
		Player player2 = new Player(player1Name,1)
		CFour game = new CFour(player1,player2);
		int winner = -1;
		while(winner == -1){
			int playerInput = 0; //Temp value -- The GUI Will determine the value.
			game.move();
			winner = game.checkWin();
			if(winner == -1){
				game.switchPlayer();
			}
		}
	}
}