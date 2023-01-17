package Spoj.WanderingQueen;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] grid;
    static int n, m;
    static int[][] moves;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        moves = new int[][]{{0, 0, 1, -1, -1, 1, 1, -1}, {1, -1, 1, -1, 1, -1, 0, 0}};

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(in.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            grid = new char[n][m];
            Point start = null;
            Point end = null;
            for (int i = 0; i < n; i++) {
                String str = in.readLine();
                for (int j = 0; j < str.length(); j++) {
                    grid[i][j] = str.charAt(j);
                    if (grid[i][j] == 'S') {
                        start = new Point(i, j);
                    }
                    if (grid[i][j] == 'F') {
                        end = new Point(i, j);
                    }
                }
            }

            System.out.println(search(start, end));
        }
    }

    private static int search(Point p, Point end) {
        Queue<Point> q = new LinkedList();

        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        q.add(p);
        cost[p.x][p.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 8; i++) {
                for (int j = 1;; j++) {
                    int nr = cur.x + (j * moves[0][i]);
                    int nc = cur.y + (j * moves[1][i]);

                    if (nr < 0 || nr >= n || nc >= m || nc < 0 || grid[nr][nc] == 'X') {
                        break;
                    } else if (grid[nr][nc] != 'S' && cost[cur.x][cur.y] + 1 <= cost[nr][nc]) {
                        q.add(new Point(nr, nc));
                        cost[nr][nc] = cost[cur.x][cur.y] + 1;
                    }
                }
            }
        }

        if (cost[end.x][end.y] == Integer.MAX_VALUE) {
            return -1;
        }
        return cost[end.x][end.y];
    }
}
