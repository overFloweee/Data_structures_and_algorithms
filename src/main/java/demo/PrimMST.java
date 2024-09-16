package demo;

import java.util.Arrays;

public class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int[][] graph) {
        int V = graph.length; // 顶点的数量
        int[] min = new int[V]; // 存储到达每个顶点的最小权重
        boolean[] inMST = new boolean[V]; // 标记顶点是否已经在MST中

        // 初始化
        Arrays.fill(min, INF);
        min[0] = 0; // 从顶点0开始构建MST
        inMST[0] = true;

        for (int i = 0; i < V - 1; i++) {
            // 找到未包含在MST中权重最小的顶点
            int u = -1;
            for (int v = 0; v < V; v++) {
                if (!inMST[v] && (u == -1 || min[v] < min[u])) {
                    u = v;
                }
            }

            inMST[u] = true; // 将找到的顶点加入MST

            // 更新与顶点u相邻的顶点的最小权重
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < min[v]) {
                    min[v] = graph[u][v];
                }
            }
        }

        // 打印构建的MST
        printMST(min);
    }

    private static void printMST(int[] min) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < min.length; i++) {
            if (min[i] != Integer.MAX_VALUE) {
                System.out.println("0-" + i + "\t" + min[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}
        };
        primMST(graph);
    }
}
