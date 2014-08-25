package zcy.Programming_Basic.leetcode;

import java.util.*;

public class L135MaxPointsOnLine {

	public static void main(String[] args) {
		L135MaxPointsOnLine l = new L135MaxPointsOnLine();
		
		Point[] points = new Point[4];
		Point p1 = new Point(3,1);
		Point p2 = new Point(12,3);
		Point p3 = new Point(3,1);
		Point p4 = new Point(-6,-1);
		
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;
		
		System.out.println(l.maxPoints(points));
		
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		if (points.length <= 2)
			return points.length;

		Hashtable<Line, Integer> ht = new Hashtable<Line, Integer>();
		int maxNum = 0;
		

		for (int i = 0; i < points.length; i++) {
			Point base = points[i];
			int dup = 0;
			ht.clear();
			int localmax = 1;
			for (int j = i + 1; j < points.length; j++) {

				if (base.x == points[j].x && base.y == points[j].y) {
					dup++;
					continue;
				} else {

					Line line = geneLine(base, points[j]);
					if (ht.containsKey(line)) {
						ht.put(line, ht.get(line) + 1);
					} else {
						ht.put(line, 2);
					}
					
					localmax = Math.max(localmax, ht.get(line));

				}

			}
			maxNum = Math.max(maxNum, dup + localmax);
		}
		return maxNum;
	}
	
	private Line geneLine(Point p1, Point p2) {
        if (p2.x == p1.x) {
            return new Line(Double.MAX_VALUE, (double)p1.x, Double.MIN_VALUE);
        } 
        else if (p2.y == p1.y) {
            return new Line(0, Double.MIN_VALUE, (double)p1.y);
        }
        double s = (double)(p2.y-p1.y) / (double)(p2.x-p1.x);
        double y = (double)p1.y - (double)p1.x * s;
        double x = (double)p1.x - (double)p1.y/s;
        return new Line(s, x, y);
    }

}

class Line {
	double slope;
	double xinterception;
	double yinterception;

	public Line(double d1, double d2, double d3) {
		slope = d1;
		xinterception = d2;
		yinterception = d3;
	}

	@Override
	public boolean equals(Object o) {
		Line other = (Line) o;
		if (Math.abs(this.slope - other.slope) < 0.001
				&& Math.abs(this.xinterception - other.xinterception) < 0.001
				&& Math.abs(this.yinterception - other.yinterception) < 0.001) {
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		int a = (int) (this.xinterception * 1000);
		int b = (int) (this.yinterception * 100);
		return a | b;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}