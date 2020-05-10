package UVA.UVA784;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
    2
XXXXXXXXX
X   X   X
X *     X
X   X   X
XXXXXXXXX
X   X
X   X
X   X
XXXXX
_____
XXXXX
X   X
X * X
X   X
XXXXX
_____
    */
    
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        List<Point> points = new ArrayList();

        int row = 0, col = - 1;
        String str;
        List<String> strs = new ArrayList();
        while (!(str = in.readLine()).equals("")) {
            strs.add(str);
            row++;
            col = Integer.max(col, str.length());
        }
//        row--;
        
        char[][] grid = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = ' ';
            }
        }

        for (int i = 0; i < row; i++) {
            String s = strs.get(i);
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == '*') {
                    points.add(new Point(i, j));
                }
            }
        }

        Boolean[][] vis = new Boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                vis[i][j] = false;
            }
        }

        for (Point point : points) {
            solve(point.x, point.y, grid, vis);

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }

    }

    private static void solve(int i, int j, char[][] grid, Boolean[][] vis) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (vis[i][j] || grid[i][j] == 'X') {
            return;
        }

        grid[i][j] = '#';
        vis[i][j] = true;

        solve(i + 1, j, grid, vis);
        solve(i, j + 1, grid, vis);
        solve(i - 1, j, grid, vis);
        solve(i, j - 1, grid, vis);

    }
}
