class Solution {
    // 动态规划 - 三维数组
    public int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;

        int[][][] dp = new int[len][m+1][n+1];


        for (int k = 0; k < len; ++k) {
            // 计算0、1的数量
            int zeroNum = 0, oneNum = 0;
            for (char ch : strs[k].toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            if (k == 0) {
                // 开始填充背包
                for (int i = 0; i <= m; ++i) {
                    for (int j = 0; j <= n; ++j) {
                        if (i >= zeroNum && j >= oneNum) {
                            dp[0][i][j] = 1;
                        }
                    }
                }
                continue;
            }

            // 开始填充背包
            for (int i = 0; i <= m; ++i) {
                for (int j = 0; j <= n; ++j) {
                    if (i >= zeroNum && j >= oneNum) {
                        dp[k][i][j] = Math.max(dp[k-1][i][j], 1 + dp[k-1][i-zeroNum][j-oneNum]);
                    }
                    else {
                        dp[k][i][j] = dp[k-1][i][j];
                    }
                }
            }
        }

        return dp[len - 1][m][n];
    }


    // 二维数组优化
    public int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;

        int[][] dp = new int[m+1][n+1];


        for (int k = 0; k < len; ++k) {
            // 计算0、1的数量
            int zeroNum = 0, oneNum = 0;
            for (char ch : strs[k].toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            if (k == 0) {
                // 开始填充背包
                for (int i = 0; i <= m; ++i) {
                    for (int j = 0; j <= n; ++j) {
                        if (i >= zeroNum && j >= oneNum) {
                            dp[i][j] = 1;
                        }
                    }
                }
                continue;
            }

            // 开始填充背包
            for (int i = m; i >= 0; --i) {
                for (int j = n; j >= 0; --j) {
                    if (i >= zeroNum && j >= oneNum) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i-zeroNum][j-oneNum]);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
