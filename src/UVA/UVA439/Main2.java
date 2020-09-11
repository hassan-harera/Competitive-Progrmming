package UVA.UVA439;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        String str;
        while (!(str = in.readLine()).equals("")) {
            stk = new StringTokenizer(str);

            System.out.println(BFS(stk.nextToken(), stk.nextToken()));
        }

    }

    private static int BFS(String start, String end) {
        int[][] mat = new int[8][8];
        for (int[] is : mat) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }

        int[] chan = new int[]{2, -2};
        int[] chan2 = new int[]{1, -1};

        Point p = new Point(start.charAt(0) - 'a', Integer.parseInt(start.charAt(1) + "") - 1);
        mat[p.x][p.y] = 0;

        Queue<Point> q = new LinkedList();
        q.add(p);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (cur.x + chan[i] >= 0 && cur.y + chan2[j] >= 0 && cur.x + chan[i] < 8 && cur.y + chan2[j] < 8 && mat[cur.x][cur.y] + 1 < mat[cur.x + chan[i]][cur.y + chan2[j]]) {
                        q.add(new Point(cur.x + chan[i], cur.y + chan2[j]));
                        mat[cur.x + chan[i]][cur.y + chan2[j]] = mat[cur.x][cur.y] + 1;
                    }
                    if (cur.x + chan2[i] >= 0 && cur.y + chan[j] >= 0 && cur.x + chan2[i] < 8 && cur.y + chan[j] < 8 && mat[cur.x][cur.y] + 1 < mat[cur.x + chan2[i]][cur.y + chan[j]]) {
                        q.add(new Point(cur.x + chan2[i], cur.y + chan[j]));
                        mat[cur.x + chan2[i]][cur.y + chan[j]] = mat[cur.x][cur.y] + 1;
                    }
                }
            }
        }

        return mat[end.charAt(0) - 'a'][Integer.parseInt(end.charAt(1) + "") - 1];
    }

}
