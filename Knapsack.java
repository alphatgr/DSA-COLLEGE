public class Knapsack {

    // Method to solve 0/1 Knapsack problem
    public static int knapSack(int W, int[] weights, int[] profits, int n) {
        // Create a DP table to store results of subproblems
        int[][] dp = new int[n + 1][W + 1];

        // Build the table in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] profits = {60, 100, 120}; // Profits for each item
        int[] weights = {10, 20, 30}; // Weights for each item
        int W = 50; // Maximum weight capacity of the knapsack
        int n = profits.length; // Number of items

        int maxProfit = knapSack(W, weights, profits, n);
        System.out.println("Maximum profit we can obtain = " + maxProfit);
    }
}
