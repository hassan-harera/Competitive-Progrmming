package Codeforces.C.DZYLovesPhysics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[] idx;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        if (m == 0) {
            System.out.println("0.000");
            return;
        }

        idx = new int[n + 1];
        graph = new int[n + 1][n + 1];

        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            idx[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        List<Double> dests = new ArrayList();
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                if(graph[i][j] != 0){
                    dests.add(1.00 * (idx[i] + idx[j]) / graph[i][j]);
                }
            }
        }
        Collections.sort(dests);
        System.out.println(dests.get(dests.size()- 1));
    }
}
