package Codeforces.B.Meeting;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.print.attribute.HashAttributeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int x1 = Integer.parseInt(stk.nextToken());
        int y1 = Integer.parseInt(stk.nextToken());
        int x2 = Integer.parseInt(stk.nextToken());
        int y2 = Integer.parseInt(stk.nextToken());

        int n = Integer.parseInt(in.readLine());

        int X[] = new int[n];
        int Y[] = new int[n];
        int R[] = new int[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            X[i] = x;
            Y[i] = y;
            R[i] = r;
        }

        Map<Point, Integer> map = new HashMap();

        int sx = Integer.min(x1, x2);
        int ex = Integer.max(x1, x2);
        int sy = Integer.min(y1, y2);
        int ey = Integer.max(y1, y2);
        for (int i = sx; i <= ex; i++) {
            map.put(new Point(i, sy), i);
        }
        for (int i = sx; i <= ex; i++) {
            map.put(new Point(i, ey), i);
        }

        for (int i = sy; i <= ey; i++) {
            map.put(new Point(sx, i), i);
        }
        for (int i = sy; i <= ey; i++) {
            map.put(new Point(ex, i), i);
        }
        int ans = 0;
        for (Point p : map.keySet()) {
            Boolean flag = false;
            for (int i = 0; i < n; i++) {
                double dis = Math.sqrt(Math.pow(p.x- X[i], 2)+ Math.pow(p.y - Y[i], 2));
                if (dis <= R[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans++;
            }
        }
//        for (Point p : map.keySet()) {
//            System.out.println(p.x + " " + p.y);
//        }

        System.out.println(ans);
    }
}
