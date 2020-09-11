package Codeforces.C.KingsPath;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static Map<Point, Boolean> map;
    static Point start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        start = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        end = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));

        int n = Integer.parseInt(in.readLine());

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            for (int j = a < b ? a : b; j <= (b > a ? b : a); j++) {
                map.put(new Point(j, r), Boolean.TRUE);
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        int cost = Integer.MAX_VALUE;

        int[] chan = new int[]{0, 1, -1};
        int[] chan2 = new int[]{0, 1, -1};

        Queue<Pair> q = new LinkedList();
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.c.x == end.x && cur.c.y == end.y) {
                cost = Integer.min(cost, cur.cost);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == 0 &&  j == 0)
                        continue;
                    if (map.containsKey(new Point(cur.c.x + chan[i], cur.c.y + chan2[j]))) {
                        if (cur.cost + 1 < cost) {
                            Point p = new Point(cur.c.x + chan[i], cur.c.y + chan2[j]);
                            q.add(new Pair(p, cur.cost + 1));
                        }
                    }
//                    if (map.containsKey(new Point(cur.c.x + chan2[i], cur.c.y + chan[j]))) {
//                        q.add(new Pair(new Point(cur.c.x + chan2[i], cur.c.y + chan[j]), cur.cost + 1));
//                    }
                }
            }
        }

        return cost;
    }
}

class Pair {

    Point c;
    int cost;

    public Pair(Point c, int cost) {
        this.c = c;
        this.cost = cost;
    }
}
