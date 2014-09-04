package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0705JigZawPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class JigzawPuzzle{
		List<Card> list;
		Board board;
		
		Card pickACard(){return null;}
		void placeACard(){}
		boolean finished(){return true;}
	}
	
	class Card{
		String image;
		boolean placedCorrectly;
	}
	class Board{
		boolean correct(Card card, int row, int col){return true;}
	}

}
