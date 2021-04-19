package UVA.UVA11573;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] grid = new int[10005][10005];
    static int[][] cost = new int[10005][10005];
    static int[] moveR = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] moveC = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int r, c;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        r = in.nextInt();
        c = in.nextInt();

        for (int i = 0; i < r; i++) {
            String st = in.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = Integer.parseInt("" + st.charAt(j));
            }
        }

        int p = in.nextInt();
        int[][] points = new int[p][4];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 4; j++) {
                points[i][j] = in.nextInt();
            }

            for (int k = 0; k < r; k++) {
                for (int t = 0; t < c; t++) {
                    cost[k][t] = Integer.MAX_VALUE;
                }
            }
            dijstra(points[i]);

        }
    }

    private static void dijstra(int[] arr) {
        Point s = new Point(arr[0], arr[1]);

        Queue<Point> q = new LinkedList<>();
        q.add(s);

        cost[s.x][s.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 7; i++) {
                Point next = new Point(cur.x + moveR[i], cur.y + moveC[i]);
                if (next.x > r || next.y > c || next.x < 0 || next.y < 0) {
                    continue;
                }

                if (grid[cur.x][cur.y] == i) {
                    if (cost[next.x][next.y] > cost[cur.x][cur.y]) {
                        cost[next.x][next.y] = cost[cur.x][cur.y];
                        q.add(next);
                    }
                } else if (cost[next.x][next.y] > cost[cur.x][cur.y] + 1) {
                    cost[next.x][next.y] = cost[cur.x][cur.y] + 1;
                    q.add(next);
                }
            }
        }
        Point d = new Point(arr[2], arr[3]);
        System.out.println(cost[d.x][d.y]);
    }
}
