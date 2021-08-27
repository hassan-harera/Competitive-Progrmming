package Codeforces.C.Hackepackyourbags;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();

        ArrayList<Integer>[] days = new ArrayList[200005];
        Point[] vos = new Point[200005];
        int[] mn = new int[200005];

        Arrays.fill(mn, Integer.MAX_VALUE);
        Arrays.fill(days, new ArrayList());

        int L = Integer.MAX_VALUE, R = -1;
        long ans = Long.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            vos[i] = new Point(b - a + 1, c);
            days[a].add(-i);
            days[b].add(i);
            L = Integer.min(L, a);
            R = Integer.max(R, b);
        }
        
        for (int i = L; i <= R; i++) {
            ArrayList<Integer> dvos = days[i];
            Collections.sort(dvos);

            for (int j = 0; j < dvos.size(); j++) {
                int cur = dvos.get(j);

                if (cur < 0) {
                    cur = -cur;
                    int len = vos[cur].x;
                    int reqLen = x - len;
                    if (reqLen >= 0 && mn[reqLen] < Integer.MAX_VALUE) {
                        ans = Long.min(ans, (long) (vos[cur].y + mn[reqLen]));
                    }
                } else {
                    int len = vos[cur].x;
                    mn[len] = Integer.min(mn[len], vos[cur].y);
                }
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
