public class Knapsack {

    // Method to solve 0/1 Knapsack problem
    public static int knapSack(int C, int[] capacity, int[] profits, int n) {
        // Create a DP table to store results of subproblems
        int[][] dp = new int[n + 1][C + 1];

        // Build the table in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int c = 0; c <= C; c++) {
                if (i == 0 || c == 0) {
                    dp[i][c] = 0;
                } else if (capacity[i - 1] <= c) {
                    dp[i][c] = Math.max(profits[i - 1] + dp[i - 1][c - capacity[i - 1]], dp[i - 1][c]);
                } else {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }

        return dp[n][C];
    }

    public static void main(String[] args) {
        int[] profits = {10, 15, 40}; // Profits for each item
        int[] capacity = {1, 2, 3}; // Weights for each item
        int C = 50; // Maximum weight capacity of the knapsack
        int n = profits.length; // Number of items

        int maxProfit = knapSack(C, capacity, profits, n);
        System.out.println("Maximum profit we can obtain = " + maxProfit);
    }
}
