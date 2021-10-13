package projecteuler;
/*
 * Lattice Paths
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


	How many such routes are there through a 20×20 grid?
 */
public class Problem15 {

	public static void main(String args[]) {
		int length = 21,breadth = 21;
		
		System.out.println(numberOfPaths(length, breadth));
	}
	
	static long numberOfPaths(int m, int n)
    {
        // Create a 1D array to store results of subproblems
        long[] dp = new long[n];
        dp[0] = 1;
 
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
 
        return dp[n - 1];
    }
 
}
