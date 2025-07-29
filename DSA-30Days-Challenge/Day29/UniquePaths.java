public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] = dp[col] + dp[col - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;

        System.out.println("Unique paths in 3x7 grid: " + uniquePaths(m, n));
    }
}
