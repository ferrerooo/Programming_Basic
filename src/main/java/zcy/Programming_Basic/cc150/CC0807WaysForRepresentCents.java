package zcy.Programming_Basic.cc150;

public class CC0807WaysForRepresentCents {
	
	public int howManyWays(int cents) {
		
		int[] ways = new int[1];
		recur(cents, ways, 1);
		return ways[0];
	}
	
	private void recur(int total, int[] ways, int index) {
		if (index == 4){
			ways[0]++;
			return;
		}
		
		if (index == 1) {
			
			for (int i=0; i*25<=total; i++) {
				recur(total-i*25, ways, 2);
			}			
		} else if (index == 2) {
			for (int i=0;i*10<=total;i++) {
				recur(total-i*10, ways, 3);
			}
		} else {
			for (int i=0;i*5<=total; i++) {
				recur(total-i*5, ways, 4);
			}
		}
	}

}
