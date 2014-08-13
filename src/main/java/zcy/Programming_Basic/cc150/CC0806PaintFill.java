package zcy.Programming_Basic.cc150;

import java.util.*;
public class CC0806PaintFill {
	
	public void paintFill(int[][] board, int sx, int sy, int color) {
		
		if (board==null || board.length==0 || board[0].length == 0)
			return ;
		int m = board.length;
		int n = board[0].length;
		
		if (sx<0 || sx>=m || sy<0 || sy>=n)
			return ;
		
		LinkedList<Grid> ll = new LinkedList<Grid>();
		ll.add(new Grid(sx, sy));
		
		while (!ll.isEmpty()) {
			Grid cur = ll.pop();
			if (board[cur.x][cur.y] != color) {
				
				board[cur.x][cur.y] = color;
				
				if (cur.x-1>=0 && board[cur.x-1][cur.y]!=color)
					ll.add(new Grid(cur.x-1, cur.y));
				if (cur.x+1<m && board[cur.x+1][cur.y]!=color)
					ll.add(new Grid(cur.x+1, cur.y));
				if (cur.y-1 >=0 && board[cur.x][cur.y-1]!=color)
					ll.add(new Grid(cur.x, cur.y-1));
				if (cur.y+1<n && board[cur.x][cur.y+1]!= color)
					ll.add(new Grid(cur.x, cur.y+1));
			}
		}
		
	}
	
	class Grid{
		int x;
		int y;
		public Grid(int _x, int _y){
			x = _x;
			y = _y;
		}
	}
}

