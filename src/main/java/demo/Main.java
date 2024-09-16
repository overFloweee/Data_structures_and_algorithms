package demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        double minYears = findMinYears(points, n);
        System.out.println((int) Math.ceil(minYears));
    }

    private static double findMinYears(int[][] points, int n) {
        int E = n * (n - 1) / 2;
        Edge[] edges = new Edge[E];
        int edgeCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(
                        Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                edges[edgeCount++] = new Edge(i, j, distance);
            }
        }

        Arrays.sort(edges, Comparator.comparingDouble(e -> e.weight));

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double totalWeight = 0;
        for (Edge edge : edges) {
            int root1 = find(edge.src);
            int root2 = find(edge.dest);
            if (root1 != root2) {
                union(root1, root2);
                totalWeight += edge.weight;
                if (countComponents() == 1) {
                    return totalWeight;
                }
            }
        }
        return -1; // Should not reach here
    }

    private static int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }
            else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    private static int countComponents() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    static class Edge {
        int src, dest;
        double weight;

        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
