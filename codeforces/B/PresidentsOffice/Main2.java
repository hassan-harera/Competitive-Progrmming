/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.PresidentsOffice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        List<Point> pRoom = new ArrayList();
        char pres = stk.nextToken().charAt(0);

        Map<Character, Boolean> map = new HashMap<>();

        char[][] mat = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                mat[i][j] = ch;
                if (ch == pres) {
                    pRoom.add(new Point(i, j));
                }
            }
        }

        for (Point p : pRoom) {
            int i = p.x;
            int j = p.y;

            if (i - 1 >= 0 && i - 1 < n && mat[i - 1][j] != pres && mat[i - 1][j] != '.') {
                map.put(mat[i - 1][j], Boolean.TRUE);
            }
            if (i + 1 >= 0 && i + 1 < n && mat[i + 1][j] != pres && mat[i + 1][j] != '.') {
                map.put(mat[i + 1][j], Boolean.TRUE);
            }
            if (j - 1 >= 0 && j - 1 < m && mat[i][j - 1] != pres && mat[i][j - 1] != '.') {
                map.put(mat[i][j - 1], Boolean.TRUE);
            }
            if (j + 1 >= 0 && j + 1 < m && mat[i][j + 1] != pres && mat[i][j + 1] != '.') {
                map.put(mat[i][j + 1], Boolean.TRUE);
            }
        }
        System.out.println(map.keySet().size());
    }
}