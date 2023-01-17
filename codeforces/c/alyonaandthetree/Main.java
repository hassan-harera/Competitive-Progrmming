package Codeforces.C.AlyonaandtheTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Edge>[] G;
    static int[] cost = new int[100005];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] A = new int[n + 1];
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
//            G[a+1].add(new Edge(b, c));
        }

        dijkstra();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(cost[i] > A[i]){
                ans++;
            }
        }
        
        System.out.println(ans);
    }

    private static void dijkstra() {
        Queue<Integer> q = new LinkedList();
        q.add(1);

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge edge : G[cur]) {
                if (cost[edge.dest] > cost[cur] + edge.cost) {
                    q.add(edge.dest);
                    cost[edge.dest] = cost[cur] + edge.cost;
                }
            }
        }
    }
}

class Edge {

    int dest, cost;

    public Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}
