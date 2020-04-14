package MonkandtheIslands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TestClass {

    static TreeSet<Integer>[] Graph;
    static Boolean[] vis;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {

            stk = new StringTokenizer(bf.readLine());

            int nov = Integer.parseInt(stk.nextToken());
            int noe = Integer.parseInt(stk.nextToken());

            Graph = new TreeSet[nov];
            for (int i = 0; i < nov; i++) {
                Graph[i] = new TreeSet<>();
            }

            vis = new Boolean[nov];
            for (int i = 0; i < nov; i++) {
                vis[i] = false;
            }
            while (noe-- > 0) {
                stk = new StringTokenizer(bf.readLine());

                int v1 = Integer.parseInt(stk.nextToken()) - 1;
                int v2 = Integer.parseInt(stk.nextToken()) - 1;
                Graph[v1].add(v2);
                Graph[v2].add(v1);
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            int[] level = new int[nov];
            out:
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int x : Graph[u]) {
                    if (vis[x] == false) {
                        vis[x] = true;
                        level[x] += level[u] + 1;
                        q.add(x);
                    }
                    if (x == nov - 1) {
                        sb.append(level[nov - 1] + "\n");
                        break out;
                    }
                }

            }
        }

        System.out.print(sb);

    }

}
