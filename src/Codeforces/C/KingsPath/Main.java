package Codeforces.C.KingsPath;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int x0 = Integer.parseInt(stk.nextToken());
        int y0 = Integer.parseInt(stk.nextToken());
        int x1 = Integer.parseInt(stk.nextToken());
        int y1 = Integer.parseInt(stk.nextToken());

        int n = Integer.parseInt(in.readLine());

        Map<Point, Integer> graph = new HashMap();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c0 = Integer.parseInt(stk.nextToken());
            int c1 = Integer.parseInt(stk.nextToken());
            for (int j = c0; j <= c1; j++) {
                graph.put(new Point(r, j), 0);
            }
        }

        int dr[] = {0, 0, 1, 1, 1, -1, -1, -1};
        int dc[] = {1, -1, 0, 1, -1, 0, 1, -1};

        Queue<Point> q = new LinkedList();

        q.add(new Point(x0, y0));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int R = (int) curr.getX();
            int C = (int) curr.getY();
            for (int i = 0; i < 8; i++) {
                int nr = R + dr[i];
                int nc = C + dc[i];
                Point np = new Point(nr, nc);

                if (!graph.containsKey(np) || graph.get(np) != 0) {
                    continue;
                }

                q.add(np);
                graph.put(np, graph.get(curr) + 1);
                if (nr == x1 && nc == y1) {
                    System.out.println(graph.get(np));
                    return;
                }
            }
        }

        System.out.println(-1);
    }

}
