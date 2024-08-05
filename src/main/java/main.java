import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int M = sc.nextInt();
        // int N = sc.nextInt();
        //
        // int[] preempt = new int[M];
        // for (int i = 0; i < M; ++i) {
        //     preempt[i] = sc.nextInt();
        // }
        //
        // int[] value = new int[M];
        // for (int i = 0; i < M; ++i) {
        //     value[i] = sc.nextInt();
        // }

        int M = 6;
        int N = 2;
        int[] preempt = new int[]{2, 2, 3, 1, 5, 2};
        int[] value = new int[]{2, 3, 1, 5, 4, 3};


        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < M; i++) {
            if (preempt[0] <= i) {
                dp[0][i] = value[0];
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                // 可以放入
                if (preempt[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i][j - preempt[j]]);
                }
                else {
                    // 如果当前物品放不进背包，则保持上一个物品的价值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
