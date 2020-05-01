package Codeforces.B.DZYLovesChemistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static long ans = 1;
    static Boolean[] vis;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }

        vis = new Boolean[graph.length];
        Arrays.fill(vis, false);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            BFS(i);
        }
        
        System.out.println(ans);
    }

    public static void BFS(int start) {
        Queue<Integer> s = new LinkedList();
        s.add(start);
        vis[start] = true;
        while (!s.isEmpty()) {
            int curr = s.poll();
            for (Integer i : graph[curr]) {
                if (!vis[i]) {
                    ans *= 2;
                    s.add(i);
                    vis[i] = true;
                }
            }
        }
    }
}
