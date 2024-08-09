package suixianglu;

import java.util.Arrays;
import java.util.Scanner;

public class Beibao_2维 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] preempt = new int[M];
        for (int i = 0; i < M; ++i) {
            preempt[i] = sc.nextInt();
        }

        int[] value = new int[M];
        for (int i = 0; i < M; ++i) {
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[M][N + 1];

        for (int i = 0; i <= N; i++) {
            if (preempt[0] <= i) {
                dp[0][i] = value[0];
            }
        }
        dp[0][0] = 0;


        for (int i = 1; i < M; i++) {
            for (int j = 0; j <= N; j++) {
                // 可以放入
                if (preempt[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - preempt[i]]);
                }
                else {
                    // 如果当前物品放不进背包，则保持上一个物品的价值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(dp[M - 1][N]);
    }
}
