package Codeforces.C.KefaandPark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer>[] graph;
    static Boolean[] isThereCats;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        isThereCats = new Boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }

        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i < isThereCats.length; i++) {
            int x = Integer.parseInt(stk.nextToken());
            isThereCats[i] = x == 1;
        }

        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(in.readLine());
            int a1 = Integer.parseInt(stk.nextToken());
            int a2 = Integer.parseInt(stk.nextToken());

            graph[a1 < a2 ? a1 : a2].add(a1 < a2 ? a2 : a1);
        }

        int result = BFS();
        System.out.println(result);
    }

    private static int BFS() {
        int[] cost = new int[graph.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Boolean[] visited = new Boolean[graph.length];
        Arrays.fill(visited, false);

        Stack<Integer> q = new Stack();
        q.add(1);
        cost[1] = isThereCats[1] ? 1 : 0;

        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.pop();

            for (Integer next : graph[cur]) {
                if (cost[cur] + (isThereCats[next] ? 1 : 0) <= m) {
                    cost[next] = isThereCats[next] ? (cost[cur] + (isThereCats[next] ? 1 : 0)) : 0;
                    q.add(next);
                }
            }

            if (graph[cur].isEmpty() && cost[cur] <= m) {
                ans++;
            }
        }

        return ans;
    }
}
