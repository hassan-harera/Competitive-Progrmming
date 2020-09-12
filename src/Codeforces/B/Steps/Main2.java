/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.Steps;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(in.readLine());
        int curR = Integer.parseInt(stk.nextToken());
        int curC = Integer.parseInt(stk.nextToken());

        long ans = 0;
        int VS = Integer.parseInt(in.readLine());
        for (int i = 0; i < VS; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            Point p = new Point(0, 0);
            if (a == 0 && b == 0) {
                continue;
            }
            if (a == 0) {
                if (b > 0) {
                    p.y = (m - curC) / b;
                } else if (b < 0) {
                    p.y = (1 - curC) / b;
                }
                p.x = Integer.MAX_VALUE;
            } else if (b == 0) {
                if (a > 0) {
                    p.x = (n - curR) / a;

                } else if (a < 0) {
                    p.x = (1 - curR) / a;
                }
                p.y = Integer.MAX_VALUE;
            } else {
                if (a > 0) {
                    p.x = (n - curR) / a;

                } else if (a < 0) {
                    p.x = (1 - curR) / a;
                }

                if (b > 0) {
                    p.y = (m - curC) / b;
                } else if (b < 0) {
                    p.y = (1 - curC) / b;
                }
            }
            int steps = Integer.min(p.x, p.y);
            curR += steps * a;
            curC += steps * b;
            ans += steps;
        }
        System.out.println(ans);
    }

}
