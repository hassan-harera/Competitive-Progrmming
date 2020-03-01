package TheTwoRoutes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main {

    static int n, m;
    static List<Integer>[] graph, graph2;
    static int[] cost;
    static Boolean[][] e;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;

        graph = new List[n + 1];
        graph2 = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        e = new Boolean[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(e[i], false);
        }
        while (m-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            graph[u].add(v);
            graph[v].add(u);
            e[u][v] = true;
            e[v][u] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (!e[i][j]) {
                    graph2[i].add(j);
                    graph2[j].add(i);
                }
            }
        }
        if (e[1][n]) {
            System.out.println(dijkstra(2));
        } else {
            System.out.println(dijkstra(1));
        }
    }

    public static int dijkstra(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        Boolean[] visit = new Boolean[n + 1];
        Arrays.fill(visit, false);
        visit[1] = true;
        while (!q.isEmpty()) {
            int c = q.poll();
            if (c == n) {
                return cost[c];
            }
            if (i == 1) {
                for (Integer ind : graph[c]) {
                    if (!visit[ind]) {
                        q.add(ind);
                        visit[ind] = true;
                        cost[ind] = Integer.min(cost[ind], cost[c] + 1);

                    }
                }
            } else if (i == 2) {
                for (Integer ind : graph2[c]) {
                    if (!visit[ind]) {
                        q.add(ind);
                        visit[ind] = true;
                        cost[ind] = Integer.min(cost[ind], cost[c] + 1);

                    }
                }
            }
        }
        return -1;
    }
}
