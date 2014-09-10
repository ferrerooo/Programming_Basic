package zcy.Programming_Basic.cc150;

public class CC2012MaxSubmatrixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubMatrixSum(int[][] matrix) {
		
		if (matrix == null || matrix.length == 0)
			return 0;
		
		int[][] dp = new int[matrix.length][matrix.length];
		int n = matrix.length;
		
		dp[0][0] = matrix[0][0];
		
		for (int i=1;i<n;i++) {
			dp[0][i] = matrix[0][i] + dp[0][i-1];
		}
		for (int i=1;i<n;i++) {
			dp[i][0] = matrix[i][0] + dp[i-1][0];
		}
		for (int i=1;i<n;i++) {
			for (int j=1;j<n;j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i][j];
			}
		}
		
		int maxSum = Integer.MIN_VALUE;
		
		for (int r1=0;r1<n;r1++) {
			for (int r2=0;r2<n;r2++) {
				for (int c1=0;c1<n;c1++) {
					for (int c2=0;c2<n;c2++) {
						
						if (r1 == 0 && c1 == 0) {
							maxSum = Math.max(maxSum, dp[r2][c2]);
						} else if (r1 == 0 && c1 != 0) {
							maxSum = Math.max(maxSum, dp[r2][c2]-dp[r2][c1-1]);
						} else if (r1!=0 && c1 == 0) {
							maxSum = Math.max(maxSum, dp[r2][c2]-dp[r1-1][c2]);
						} else {
							maxSum = Math.max(maxSum, dp[r2][c2]-dp[r2][c1-1]-dp[r1-1][c2]+dp[r1-1][c1-1]);
						}
						
					}
				}
			}
		}
		
		
		return maxSum;
		
	}

}
