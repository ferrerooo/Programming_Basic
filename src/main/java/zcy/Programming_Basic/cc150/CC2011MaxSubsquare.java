package zcy.Programming_Basic.cc150;

public class CC2011MaxSubsquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubSquare(int[][] matrix) {
		
		if (matrix == null || matrix.length == 0)
			return 0;
		
		int N = matrix.length;
		
		int[][] leftRight = new int[N][N];
		int[][] rightLeft = new int[N][N];
		int[][] upDown = new int[N][N];
		int[][] downUp = new int[N][N];
		
		for (int i=0;i<N;i++) {
			for (int j=N-1; j>=0; j--) {
				if (matrix[i][j] == 0)
					leftRight[i][j] = 0;
				else {
					if (j == N-1)
						leftRight[i][j] = 1;
					else 
						leftRight[i][j] = 1+ leftRight[i][j+1];
				}
			}
		}
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (matrix[i][j] == 0) 
					rightLeft[i][j] = 0;
				else {
					if (j==0)
						rightLeft[i][j] = 1;
					else
						rightLeft[i][j] = 1+rightLeft[i][j-1];
				}
			}
		}
		for (int j=0;j<N;j++) {
			for (int i=N-1; i>=0;i--) {
				if (matrix[i][j] == 0)
					upDown[i][j] = 0;
				else {
					if (i==N-1) 
						upDown[i][j] = 1;
					else
						upDown[i][j] = 1+upDown[i+1][j];
				}
			}
		}
		for (int j=0;j<N; j++) {
			for (int i=0;i<N;i++) {
				if (matrix[i][j] == 0)
					downUp[i][j] = 0;
				else {
					if (i == 0)
						downUp[i][j] = 1;
					else 
						downUp[i][j] = 1+downUp[i-1][j];
				}
			}
		}
		
		int maxSize = 0;
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				int localSize = Math.min(leftRight[i][j], upDown[i][j]);
				if (localSize<=maxSize)
					continue;
				else {
					int i1 = i+localSize-1;
					int j1 = j+localSize-1;
					if (  Math.min(rightLeft[i1][j1],downUp[i][j]) >=localSize ) {
						maxSize = localSize;
					}
				}
			}
		}
		
		return maxSize;
	}

}
