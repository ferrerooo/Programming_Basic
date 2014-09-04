package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0704ChessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ChessGame{
		Board board;
		List<Soldier> slist ;
		Player p1;
		Player p2;
		
		public Player whoWin(){return null;}
		void startGame(){}
		void cancelGame(){}
		void restartGame(){}
		
	}
	
	class Player{}
	class Board{}
	abstract class Soldier{
		abstract public void move();
	}
	class King extends Soldier{
		public void move(){}
	}
	class Queen extends Soldier{
		public void move(){}
	}
	class Horse extends Soldier{
		public void move(){}
	}
}
