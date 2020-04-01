package Codeforces.B.FormingTeams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static Boolean[] vis;
    static Boolean[] color;
    static List<Integer> anss;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        anss = new ArrayList<>();

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        vis = new Boolean[n + 1];
        color = new Boolean[n + 1];
        Arrays.fill(vis, false);
        Arrays.fill(color, true);

        while (m-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i < n + 1; i++) {
            search(i);
        }

        N = 0;
        check(1);
        System.out.println(N + (n - N) % 2);

    }

    static void search(int n) {
        if (vis[n]) {
            return;
        }
        vis[n] = true;
        for (Integer integer : graph[n]) {
            if (!vis[integer]) {
                vis[integer] = true;
                color[integer] = !color[n];
            }
        }
    }

    static void check(int n) {
        if (n >= graph.length) {
            return;
        }
        for (Integer integer : graph[n]) {
            if (color[integer] != null) {
                if (color[integer] == color[n]) {
                    color[n] = null;
                    if (isOdd(integer)) {
                        N++;
                    }
                }
            }
        }
        check(n + 1);
    }

    static Boolean isOdd(int n) {
        if (color[graph[n].get(0)] == color[graph[n].get(1)]) {
            return true;
        }
        return false;
    }
}
