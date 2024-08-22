class Solution {
    // 编辑距离算法
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; ++i) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                int left_top = dp[i - 1][j - 1];

                if (arr1[i - 1] != arr2[j - 1]) {
                    dp[i][j] = Math.min(Math.min(left, top), left_top + 1);
                }
                else {
                    dp[i][j] = Math.min(Math.min(left, top), left_top);
                }
            }
        }
        return dp[n1][n2];
    }
}
