package exam2;

import java.util.LinkedList;

/**
 * @author qifei
 * @since 2024-09-12
 */
public class Main1 {
    public static void main(String[] args) {
        int n = 6;
        int[] points = new int[]{8, 3, 7, 5, 6, 2};
        int[][] dependencies = new int[][]{{1, 0}, {2, 1}, {3, 1}, {4, 2}};
        int k = 3;
        System.out.println(new Main1().maxPoints(n, points, dependencies, k));
    }

    public int maxPoints(int n, int[] points, int[][] dependencies, int k) {
        int[][] dp = new int[n + 1][k + 1];

        int[] select = new int[n];
        for (int[] dependency : dependencies) {
            select[dependency[1]]++;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (select[i] == 0) {
                list.offer(i);
            }
        }

        while (!list.isEmpty()) {
            int cur = list.poll();
            for (int j = 1; j <= k; j++) {
                dp[cur + 1][j] = Math.max(dp[cur + 1][j], dp[cur][j]);
                if (j > 0) {
                    dp[cur + 1][j] = Math.max(dp[cur + 1][j], dp[cur][j - 1] + points[cur]);
                }
            }
            for (int[] dep : dependencies) {
                if (dep[0] == cur) {
                    select[dep[1]]--;
                    if (select[dep[1]] == 0) {
                        list.offer(dep[1]);
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(dp[0]));

        return dp[n][k];
    }
}
