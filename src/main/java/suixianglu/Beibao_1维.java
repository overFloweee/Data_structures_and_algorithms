package suixianglu;

import java.util.Scanner;

public class Beibao_1维 {
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

        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            if (preempt[0] <= i) {
                dp[i] = value[0];
            }
        }
        dp[0] = 0;


        for (int i = 1; i < M; i++) {
            for (int j = N; j >= 0; j--) {
                // 如果当前物品可以放入背包
                if (preempt[i] <= j) {
                    dp[j] = Math.max(dp[j], value[i] + dp[j - preempt[i]]);
                }
            }
        }


        System.out.println(dp[N]);
    }
}
