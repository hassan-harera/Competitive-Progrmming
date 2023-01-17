package UVA.UVA439;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input;
        int cd, rd, rs = 0, cs = 0;
        Point dest = null;
        while (!(input = in.readLine()).equals("")) {
            Map<Point, Integer> graph = new HashMap();
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    graph.put(new Point(i, j), 0);
                }
            }
            rs = input.charAt(0) - 'a' + 1;
            cs = Integer.parseInt(input.charAt(1) + "");
            rd = input.charAt(3) - 'a' + 1;
            cd = Integer.parseInt(input.charAt(4) + "");

            dest = new Point(rd, cd);
            graph.put(new Point(rd, cd), Integer.MAX_VALUE);

            System.out.println(solve(rs, cs, graph, dest));
        }
    }

    public static int solve(int rs, int cs, Map<Point, Integer> graph, Point dest) {
        int dr[] = {2, 2, 1, -1, 1, -1, -2, -2};
        int dc[] = {1, -1, 2, 2, -2, -2, 1, -1};

        Queue<Point> q = new LinkedList();

        q.add(new Point(rs, cs));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int R = (int) curr.getX();
            int C = (int) curr.getY();
            for (int i = 0; i < 8; i++) {
                int nr = R + dr[i];
                int nc = C + dc[i];
                Point np = new Point(nr, nc);

                if (np.equals(dest)) {
                    graph.put(dest, graph.get(dest) < graph.get(curr) + 1 ? graph.get(dest) : graph.get(curr) + 1);
                    continue;
                } else if (!graph.containsKey(np) || graph.get(np) != 0) {
                    continue;
                }

                q.add(np);
                graph.put(np, graph.get(curr) + 1);
            }
        }
        if (dest.equals(new Point(rs, cs))) {
            return 0;
        } else {
            return graph.get(dest);
        }
    }

}
