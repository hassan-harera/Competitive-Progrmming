package UVA.UVA460;

import UVA.UVA476.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        List<Figure> figs = new ArrayList<>();

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            for (int i = 0; i < 2; i++) {
                stk = new StringTokenizer(in.readLine());

                Figure f;
                Point dl = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
                Point ur = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
                f = new Figure(dl,ur);
                figs.add(f);
                if (i > 0) {
                    Figure f2 = figs.get(0);
                    if (f2..x > f.dl.x && f2.ul.x < f.dr.x && f2.ul.y > f.dr.y && f2.ul.y < f.ur.y) {
                        sb.append(f2.ul.x + " " + f.dl.y + " " + f.dr.x + " " + f2.ul.y);
                    }
                }
            }

        }
        
        System.out.print(sb);
        
        
    }

}

class Figure {

    Point dl, ur;

    public Figure(Point dl,Point ur) {
        this.dl = dl;
        this.ur = ur;
    }

}

class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
