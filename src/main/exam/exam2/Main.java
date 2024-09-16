package exam2;

/**
 * @author qifei
 * @since 2024-09-12
 */
public class Main {
    public static void main(String[] args) {
        // int[][] arr = new int[][]{{1, 3, 1}, {-1, -1, 1}, {4, -1, 1}};
        int[][] arr = new int[][]{{1, 3}};
        System.out.println(new Main().maxPriceValue(arr));
    }

    public int maxPriceValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            if (grid[0][i] == -1) {
                break;
            }
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            if (grid[i][0] == -1) {
                break;
            }
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int cur = grid[i][j];
                if (grid[i][j] != -1) {
                    int temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = cur + temp;
                }
            }
        }


        // for (int[] ints : dp) {
        //     System.out.println(Arrays.toString(ints));
        // }
        return dp[n - 1][m - 1];
    }

    public int maxPriceValue1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            if (grid[0][i] == -1) {
                break;
            }
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            if (grid[i][0] == -1) {
                break;
            }
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int cur = grid[i][j];
                if (grid[i][j] != -1) {
                    int temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = cur + temp;
                }
            }
        }


        // for (int[] ints : dp) {
        //     System.out.println(Arrays.toString(ints));
        // }
        return dp[n - 1][m - 1];
    }

}
