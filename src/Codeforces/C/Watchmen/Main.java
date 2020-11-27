/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.Watchmen;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Harera
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Map<Integer, Integer> X = new HashMap<>(), Y = new HashMap<>();
        Map<Point, Integer> points = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point p = new Point(x, y);
            if (points.containsKey(p)) {
                points.replace(p, points.get(p) + 1);
            } else {
                points.put(p, 1);
            }

            if (X.containsKey(x)) {
                X.replace(x, X.get(x) + 1);
            } else {
                X.put(x, 1);
            }

            if (Y.containsKey(y)) {
                Y.replace(y, Y.get(y) + 1);
            } else {
                Y.put(y, 1);
            }
        }
        long ans = 0;
        for (Integer i : X.keySet()) {
            long k = (X.get(i) * (X.get(i)- 1)) / 2;
            ans += k;
        }
        for (Integer i : Y.keySet()) {
            long k = (Y.get(i) * (Y.get(i) -1 )) / 2;
            ans += k;
        }
        for (Point p : points.keySet()) {
            long k = (points.get(p) * (points.get(p) -1 )) / 2;
            ans -= k;
        }
        System.out.println(ans);
    }
}
