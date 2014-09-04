package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0701DeckCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	abstract class DeckOfCard{
		
		List<Card> cardList;
		Rule rule;
		
		abstract public void shuffle();
		abstract public List<Card> dispatch();
		abstract public Card issueCard();
		public void setRule(Rule _rule){
			this.rule = _rule;
		};
	}
	
	class GunZiCard extends DeckOfCard{
		public void shuffle(){
			
		}
		public List<Card> dispatch() {
			return null;
		}
		public Card issueCard() {
			return null;
		}
	}
	
	class Card{
		String val;
		CardType type;
	}
	
	enum CardType {
		SPADES("heitao"), DIAMONDS("fangpian"), HEARTs("hongtao"), CLUBS("meihua");
		
		public String value = "";
		
		public String getValue(){
			return this.value;
		}
		CardType(String str) {
			this.value = str;
		}
		
	}
	
	class Rule{}

}

