package zcy.Programming_Basic.cc150;

import java.util.*;

public class CC2003RandomSelection {
	
	
	public Set<Integer> randomSelection(List<Integer> list, int m) {
		
		Set<Integer> hs = new HashSet<Integer>();
		
		for (int i=0;i<m;i++) {
			int randVal = getRandom(list) ;
			hs.add(randVal);
		}
		return hs;
	}
	
	private int getRandom(List<Integer> list) {
		// here should be random function to get an index based on the length of list
		int index = 1;
		return list.get(index);
	}

}
