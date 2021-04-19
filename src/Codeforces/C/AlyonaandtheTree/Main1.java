package Codeforces.C.AlyonaandtheTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    static ArrayList<Edge>[] G;
    static int[] A;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = in.nextInt();
        }

        G = new ArrayList[n + 1];
        for (int i = 0; i < G.length; i++) {
            G[i] = new ArrayList();
        }
        for (int a = 1; a < n; a++) {
            int b = in.nextInt();
            int c = in.nextInt();

            G[b].add(new Edge(a + 1, c));
        }

        System.out.println(n - DFS(1, 0, 0));
    }

    private static int DFS(int cur, long cost, long total) {
        if (A[cur] < total || A[cur] < total - cost) {
            return 0;
        }

        int ans = 1;

        for (Edge edge : G[cur]) {
            ans += DFS(edge.dest, Long.min(cost, total + edge.cost), total + edge.cost);
        }
        return ans;
    }
}

class Edge {

    int dest, cost;

    public Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}
