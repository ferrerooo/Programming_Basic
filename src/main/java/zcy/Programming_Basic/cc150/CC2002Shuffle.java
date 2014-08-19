package zcy.Programming_Basic.cc150;

public class CC2002Shuffle {
	
	public int[] shuffle() {
		
		int[] cards = new int[52];
		for (int i=0;i<cards.length;i++)
			cards[i] = i+1;
		
		for (int i=52; i>1; i--) {
			int index = getRand(i)-1;
			swap(cards, index, i-1);
		}
		return cards;
		
	}
	private void swap(int[] cards, int i, int j) {
		int temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
	
	// return random from [1,n]
	private int getRand(int n) {
		return 1;
	}

}
