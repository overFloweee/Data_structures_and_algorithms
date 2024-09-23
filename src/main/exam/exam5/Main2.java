package exam5;

/**
 * @author qifei
 * @since 2024-09-20
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(new Main2().numberOfWays(1, 2, 3));
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        if (startPos == endPos && k == 0) {
            return 1;
        }


        int MOD = (int) (Math.pow(10, 9) + 7);

        int[][] dp = new int[2001][k + 1];

        dp[startPos + 1000][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 2001; j++) {
                if (j + 1 < 2001) {
                    dp[j + 1][i] = (dp[j + 1][i] + dp[j][i - 1]) % MOD;
                }

                if (j - 1 >= 0) {
                    dp[j - 1][i] = (dp[j - 1][i] + dp[j][i - 1]) % MOD;
                }
            }
        }


        return dp[endPos + 1000][k];
    }
}
